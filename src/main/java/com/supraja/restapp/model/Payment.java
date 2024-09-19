package com.supraja.restapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int paymentid;
	@Column
	private String paymentType;
	@Column
	private String amount;
	@Column
	private String date;
	@Column
	private String email;
	
	@OneToOne(targetEntity = Membership.class, cascade = CascadeType.ALL)
	private Membership membership;

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public Payment(int paymentid, String paymentType, String amount, String date, String email, Membership membership) {
		super();
		this.paymentid = paymentid;
		this.paymentType = paymentType;
		this.amount = amount;
		this.date = date;
		this.email = email;
		this.membership = membership;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}