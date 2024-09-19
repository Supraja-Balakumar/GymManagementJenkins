package com.supraja.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Membership;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class MembershipRepoimpl 
{
	@Autowired
	  private EntityManager entityManager;
	
	 public List<Integer> getIDList() {
			String jpql="Select i.membershipid from Membership i";
			TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
			return query.getResultList();
		}
	 
	 public void save(Membership membership) {
			
			entityManager.merge(membership);
		}
	 
	 public List<Membership> findAll() {
			String jpql="From Membership";
			TypedQuery<Membership> query = entityManager.createQuery(jpql,Membership.class);
			return query.getResultList();
		}
	 
	 public void deleteById(int membershipid) {
			String jpql="delete from Membership where membershipid=" +membershipid;
			entityManager.createQuery(jpql).executeUpdate();
		}
	 
	 public Membership findById(int membershipid) {
			return entityManager.find(Membership.class, membershipid);
		}
	 
//	 public Membership updateCardStatus(int cardreqid, String cardStatus) {
//	        CardRequest cardRequest = entityManager.find(CardRequest.class, cardreqid);
//	        if (cardRequest != null) {
//	            cardRequest.setCardStatus(cardStatus);
//	            entityManager.merge(cardRequest);
//	        }
//	        return cardRequest;
//	    } 
		
}
