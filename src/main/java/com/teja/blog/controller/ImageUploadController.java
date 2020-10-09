package com.teja.blog.controller;

import Constants.CommonConstants;
import com.teja.blog.Annotation.OperationLog;
import com.teja.blog.utils.FileUploadUtil;
import com.teja.blog.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@CrossOrigin("*")
@RestController
public class ImageUploadController {

    @Value("${web.upload-path}")
    private String saveDir;

    @PostMapping("/upload/{type}")
    @OperationLog("New image uploaded")
    public Result uploadImg(@RequestParam(value = "file") MultipartFile file,
                            @PathVariable String type) {
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        fileName = fileName.toLowerCase();
        if (fileName.endsWith("jpg") || fileName.endsWith("png") || fileName.endsWith("jpeg")
            || fileName.endsWith("gif")) {
            String fileDir = this.saveDir + "/images/" + type + "/";
            fileName = UUID.randomUUID().toString() + fileName.substring(fileName.length() - 5);
            Boolean result = FileUploadUtil.upload(file, fileDir, fileName);
            if (result) {
                String url = "/images/" + type + "/" + fileName;
                return new Result(url);
            } else {
                return new Result(CommonConstants.ERROR,
                    "Filed to save the image, please try again later!");
            }
        } else {
            return new Result(CommonConstants.ERROR,
                "Please upload images of jpg, png and gif format!");
        }
    }

    @DeleteMapping("/admin/delete")
    @OperationLog("image Deleted")
    public Result deleteImg(@RequestParam(value = "fileName") String fileName) {
        String filePath = saveDir + fileName;
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
            return new Result();
        } else {
            return new Result(CommonConstants.ERROR, "Field to delete the image!");
        }
    }
}
