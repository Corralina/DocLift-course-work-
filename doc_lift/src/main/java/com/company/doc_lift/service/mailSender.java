package com.company.doc_lift.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class mailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void send(String emailTo, String subject, String mes, String filePath, String fileName, String imgPath, String imgName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        FileSystemResource file
                = new FileSystemResource(new File(filePath));
        FileSystemResource img
                = new FileSystemResource(new File(imgPath));


        helper.addAttachment(imgName, img);
        helper.addAttachment(fileName, file);
        helper.setTo(emailTo);
        helper.setSubject(subject);
        helper.setText(mes);

        mailSender.send(message);

    }
}
