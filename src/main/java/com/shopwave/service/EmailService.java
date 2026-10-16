package com.shopwave.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationOtpEmail(
            String userEmail,
            String otp,
            String subject,
            String text
    ) throws MessagingException, MailSendException {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setSubject(subject);
            helper.setText(text + otp, true);
            helper.setTo(userEmail);

            javaMailSender.send(mimeMessage);

        } catch (MailException e) {

            System.err.println("========== EMAIL SEND FAILED ==========");
            System.err.println("EXCEPTION CLASS: " + e.getClass().getName());
            System.err.println("EXCEPTION MESSAGE: " + e.getMessage());

            Throwable cause = e.getCause();

            while (cause != null) {
                System.err.println("CAUSE CLASS: " + cause.getClass().getName());
                System.err.println("CAUSE MESSAGE: " + cause.getMessage());
                cause = cause.getCause();
            }

            System.err.println("=======================================");

            throw new MailSendException("Failed to send email", e);
        }
    }
}