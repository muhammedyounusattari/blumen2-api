package com.kastech.blumen.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${blumen2.fromMail}")
    private String from;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    public void sendEMail(
      String to, String subject, String body) {
        LOGGER.info("Attempt made to send mail to {}, with subject {} and body {} ", body);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(body);
        emailSender.send(message);
        LOGGER.info("Email has sent successfully {}", to);
    }

    @Async
    public void sendMail(String to, String subject, String content) {
        LOGGER.debug("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
                true, true, to, subject, content);

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());
            message.setTo(to);
            message.setFrom(from);
            LOGGER.debug("from mail is ..... " + from);
            message.setSubject(subject);
            message.setText(content, true);
            emailSender.send(mimeMessage);
            LOGGER.debug("Sent email to User '{}'", to);
        } catch (MailException | MessagingException e) {
            LOGGER.warn("Email could not be sent to user '{}'", to, e);
        }
    }
}