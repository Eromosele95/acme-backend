package acme.inventoryservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage( String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("aceminventory07@gmail.com");
        message.setTo(to);
        message.setText(text);
        message.setSubject(subject);
        emailSender.send(message);
    }

}
