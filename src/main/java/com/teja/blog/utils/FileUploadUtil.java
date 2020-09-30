package com.teja.blog.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadUtil {
    public static Boolean upload(MultipartFile file, String path, String fileName){

        File dest = new File(path, fileName);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
