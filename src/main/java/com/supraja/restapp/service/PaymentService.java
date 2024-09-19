package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.Payment;


public interface PaymentService 
{
	public String addPayment(Payment payment);

	public Payment getPayment(int id);

	public List<Payment> getAllPayment();

	public void updatePayment(Payment payment);

	public void deletePayment(int id);

	public List<Integer> getAllId();
}
