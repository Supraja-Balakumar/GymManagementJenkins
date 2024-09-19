package com.supraja.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.supraja.restapp.model.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class PaymentRepoimpl 
{
	@Autowired
	  private EntityManager entityManager;
	
	 public List<Integer> getIDList() {
			String jpql="Select p.paymentid from Payment p";
			TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
			return query.getResultList();
		}
	 
	 public void save(Payment payment) {
			
			entityManager.merge(payment);
		}
	 
	 public List<Payment> findAll() {
			String jpql="From Payment";
			TypedQuery<Payment> query = entityManager.createQuery(jpql,Payment.class);
			return query.getResultList();
		}
	 
	 public void deleteById(int paymentid) {
			String jpql="delete from Payment where paymentid=" +paymentid;
			entityManager.createQuery(jpql).executeUpdate();
		}
	 
	 public Payment findById(int paymentid) {
			return entityManager.find(Payment.class, paymentid);
		}
}
