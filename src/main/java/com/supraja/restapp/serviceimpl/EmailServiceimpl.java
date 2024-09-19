package com.supraja.restapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.supraja.restapp.service.EmailService;

@Service
public class EmailServiceimpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

//    @Override
//    public void sendPaymentConfirmationEmail(String recipientEmail, String paymentDetails) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(recipientEmail);
//        message.setSubject("Payment Confirmation - Thank You!");
//        message.setText("Dear Customer,\n\nYour membership payment has been processed successfully.\n\nDetails:\n" + paymentDetails + "\n\nThank you for your payment!");
//
//        mailSender.send(message);
//        
//        System.out.println("Mail sent");
//    }
    
    @Override
    public void sendPaymentConfirmationEmail(String recipientEmail, String paymentDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Payment Confirmation - Thank You!");
        
        String emailBody = "Dear Valued Customer,\n\n"
                         + "Thank you for your payment! We are pleased to inform you that your membership payment has been processed successfully.\n\n"
                         + "Payment Details:\n"
                         + paymentDetails + "\n\n"
                         + "If you have any questions or need further assistance, please do not hesitate to contact our support team.\n\n"
                         + "Thank you for choosing us!\n\n"
                         + "Best Regards,\n"
                         + "The [Your Company Name] Team";

        message.setText(emailBody);

        mailSender.send(message);
        
        System.out.println("Mail sent");
    }


//	@Override
//	public void sendEmailPassword(String email, String password) {
//		SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setSubject("Trainer Login Credientials");
//        message.setText("Dear Trainer,\n\n"
//        		+ "Your Login Credientials.\n\n Email : " + email + "\n" +
//        				"Password : " + password + "\n\n" + 
//        				"Thank you !");
//
//        mailSender.send(message);
//        
//        System.out.println("Mail sent");
//
//		
//	}
    
    @Override
    public void sendEmailPassword(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Trainer Login Credentials");
        message.setText("Dear Trainer,\n\n" +
                "Welcome to our Training Platform!\n\n" +
                "We are excited to have you on board. Here are your login credentials to access your account:\n\n" +
                "Email: " + email + "\n" +
                "Password: " + password + "\n\n" +
                "Thank you for being a part of our community!\n\n" +
                "Best Regards,\n" +
                "The Training Team\n" +
                "Contact Us: suprajaa33@gmail.com\n" +
                "Website: www.gymfit.com");

        mailSender.send(message);
        
        System.out.println("Mail sent");
    }

}
