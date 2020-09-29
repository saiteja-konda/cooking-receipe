package com.teja.blog.Service.Impletementations;

import com.teja.blog.Service.Services.CommentsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentsService {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration config;

    @Override
    public void commentNotifcation(String postTitle, Map<String, Object> model ) {
        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Template t = config.getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t,model);
            helper.setTo("kondasaitej@protonmail.com");
            helper.setFrom("kondasitej@gmail.com");
            helper.setSubject("Blog Alert!, New comment on " + postTitle);
            helper.setText(html,true);
            sender.send(message);
        } catch (MessagingException  | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
