package com.kastech.blumen.mail;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendMailService {

  @Value("${blumen2.fromMail}")
  private String fromMail;

  @Value("${app.sendgrid.key}")
  private String apiKey;

  private static final Logger LOGGER = LoggerFactory.getLogger(SendMailService.class);

  public void sendMail(String toMail, String subject, String body) throws IOException{


    LOGGER.info("Request made to send an email to {}, subject {} and body {}", toMail, subject, body);
    Email from = new Email(fromMail);
    Email to = new Email(toMail);
    Content content = new Content("text/plain", body);
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(apiKey);
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      LOGGER.info("Attempt made to send an email to {}, and the response received is {}", toMail, response.getStatusCode());
      LOGGER.info("response body is {}",response.getBody());
      LOGGER.debug("response headers are {}", response.getHeaders());
    } catch (IOException e) {
      LOGGER.error("Failed to send an email to {}, body {}", toMail, body);
      LOGGER.error("Error message is {}", e.getMessage());
      e.printStackTrace();
      throw e;
    }
  }
}