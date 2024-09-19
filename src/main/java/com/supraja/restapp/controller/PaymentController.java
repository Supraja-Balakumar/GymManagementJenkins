package com.supraja.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supraja.restapp.model.Payment;
import com.supraja.restapp.service.EmailService;
import com.supraja.restapp.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins="http://localhost:3000/")
public class PaymentController 
{
	@Autowired
	private PaymentService service;
	
	 @Autowired
	    private EmailService emailService;
	
	@PostMapping
	public String insertPayment(@RequestBody Payment payment) {
		String msg = "Failure";
		String paymentDetails = String.format(
	            "Payment Type: %s\nDate: %s\nAmount: Rs. %s",
	            payment.getPaymentType(),
	            payment.getDate(),
	            payment.getAmount()
	        );
		try {
			System.out.println(payment.getEmail());
			service.addPayment(payment);
     		emailService.sendPaymentConfirmationEmail(payment.getEmail(), paymentDetails);
			msg = "Successfully added";	
		} catch (Exception e) {
			msg = "Failure";
		}
		return msg;
	}
	
	@GetMapping("{id}")
	public Payment getPaymentbyId(@PathVariable("id") int id) {
		return service.getPayment(id);
	}

	@GetMapping("/all")
	public List<Payment> getPayment() {
		return service.getAllPayment();
	}
	
	@PutMapping
	public String updatePayment(@RequestBody Payment payment) {
		String msg = "";
		try {
			service.updatePayment(payment);
			msg = "Updated Success";
		} catch (Exception e) {
			msg = "Updated Failure";
		}

		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deletePayment(@PathVariable int id) {
		String msg = "";
		try {
			service.deletePayment(id);
			msg = "Deleted Successfully";
		} catch (Exception e) {
			msg = "Deletion Failure";
		}

		return msg;
	}
	
	@GetMapping("/idlist")
	public List<Integer> getIDList() {
		return service.getAllId();
	}
	
	
}
