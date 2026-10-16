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

            System.out.println("==============================");
            System.out.println("OTP EMAIL");
            System.out.println("To: " + userEmail);
            System.out.println("OTP: " + otp);
            System.out.println("==============================");

            MimeMessage mimeMessage =
                    javaMailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setSubject(subject);
            helper.setText(text + otp, true);
            helper.setTo(userEmail);

            System.out.println("Sending email...");

            javaMailSender.send(mimeMessage);

            System.out.println("EMAIL SENT SUCCESSFULLY");

        } catch (MailException e) {

            System.err.println("==============================");
            System.err.println("EMAIL SEND FAILED");
            System.err.println("Exception: " + e.getClass().getName());
            System.err.println("Message: " + e.getMessage());

            Throwable cause = e.getCause();

            while (cause != null) {
                System.err.println("Cause: " + cause.getClass().getName());
                System.err.println("Cause message: " + cause.getMessage());
                cause = cause.getCause();
            }

            e.printStackTrace();

            System.err.println("==============================");

            throw new MailSendException("Failed to send email", e);
        }
    }
}