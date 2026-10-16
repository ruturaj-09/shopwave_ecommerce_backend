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

            // Print the REAL Gmail/SMTP error in Vercel logs
            System.err.println("========== EMAIL SEND FAILED ==========");
            System.err.println("Error message: " + e.getMessage());
            e.printStackTrace();
            System.err.println("=======================================");

            // Keep the original exception as the cause
            throw new MailSendException("Failed to send email", e);
        }
    }
}