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

        System.out.println("========== OTP EMAIL START ==========");
        System.out.println("EMAIL: " + userEmail);
        System.out.println("OTP: " + otp);

        try {
            MimeMessage mimeMessage =
                    javaMailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setSubject(subject);
            helper.setText(text + otp, true);
            helper.setTo(userEmail);

            System.out.println("========== CALLING SMTP ==========");

            javaMailSender.send(mimeMessage);

            System.out.println("========== EMAIL SENT SUCCESSFULLY ==========");

        } catch (Exception e) {

            System.err.println("========== SMTP ERROR ==========");
            System.err.println("Exception Type: "
                    + e.getClass().getName());
            System.err.println("Exception Message: "
                    + e.getMessage());

            Throwable cause = e.getCause();

            while (cause != null) {
                System.err.println("CAUSE TYPE: "
                        + cause.getClass().getName());
                System.err.println("CAUSE MESSAGE: "
                        + cause.getMessage());

                cause = cause.getCause();
            }

            e.printStackTrace();

            System.err.println("========== SMTP ERROR END ==========");

            throw e;
        }
    }
}