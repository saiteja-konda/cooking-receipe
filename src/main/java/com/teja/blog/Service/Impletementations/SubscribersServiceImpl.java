package com.teja.blog.Service.Impletementations;

import com.teja.blog.Service.Services.SubscribersSerive;
import com.teja.blog.model.Subcribers;
import com.teja.blog.repository.SubscriberRepository;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class SubscribersServiceImpl implements SubscribersSerive {

    @Autowired
    private JavaMailSender sender;
    @Autowired
    private Configuration config;
    @Autowired
    private SubscriberRepository subscriberRepository;

    public void mySendEmail(Subcribers subcribers, Map<String, Object> model) {
        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            // add attachment
//            helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

            Template t = config.getTemplate("new-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            helper.setTo(subcribers.getEmail());
            helper.setFrom("kondasaitej@gmail.com");
            helper.setSubject("Welcome to my blog");
            helper.setText(html, true);
            sender.send(message);

        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(Map<String, Object> model) {
        List<Subcribers> subcribersList = subscriberRepository.findAll();
        subcribersList.forEach(s -> {
            MimeMessage message = sender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                        StandardCharsets.UTF_8.name());

                Template t = config.getTemplate("new-template.ftl");
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

                helper.setTo(s.getEmail());
                helper.setFrom("kondasaitej@gmail.com");
                helper.setSubject("Welcome to my blog");
                helper.setText(html, true);
                sender.send(message);
            } catch (MessagingException | IOException | TemplateException e) {
                e.printStackTrace();
            }
        });

    }

}
