package com.shopwave.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
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
            String text) throws MessagingException {

        try {
            MimeMessage mimeMessage =
                    javaMailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setSubject(subject);
            helper.setText(text + otp, true);
            helper.setTo(userEmail);

            System.out.println("CALLING SMTP");

            javaMailSender.send(mimeMessage);

            System.out.println("EMAIL SENT SUCCESSFULLY");

        } catch (Exception e) {

            System.err.println(
                    "SMTP_FAILURE: "
                            + e.getClass().getName()
                            + " | "
                            + e.getMessage()
                            + " | CAUSE="
                            + (e.getCause() != null
                            ? e.getCause().getClass().getName()
                              + ": "
                              + e.getCause().getMessage()
                            : "none")
            );

            throw e;
        }
    }
}