package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.Membership;
import com.supraja.restapp.model.Payment;
import com.supraja.restapp.repoimpl.MembershipRepoimpl;
import com.supraja.restapp.repoimpl.PaymentRepoimpl;
import com.supraja.restapp.service.PaymentService;

@Service
public class PaymentServiceimpl implements PaymentService
{
	@Autowired
	PaymentRepoimpl repo;
	
	@Override
	public String addPayment(Payment payment) {
		repo.save(payment);
		return "AddSuccess";
	}

	@Override
	public Payment getPayment(int id) {
		Payment payment = repo.findById(id);
		return payment;
	}

	@Override
	public List<Payment> getAllPayment() {
		return repo.findAll();
	}

	@Override
	public void updatePayment(Payment payment) {
		repo.save(payment);

	}

	@Override
	public void deletePayment(int id) {
		repo.deleteById(id);

	}

	public List<Integer> getAllId() {
		return repo.getIDList();
	}
}
