package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Payment;

public interface PaymentRepo 
{

	public List<Integer> getIDList();

	void save(Payment payment);

	List<Payment> findAll();

	void deleteById(int paymentid);

	Payment findById(int paymentid);
	
}
