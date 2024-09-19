package com.supraja.restapp.service;

public interface EmailService {
    void sendPaymentConfirmationEmail(String recipientEmail, String paymentDetails);
    void sendEmailPassword(String email,String password);
}
