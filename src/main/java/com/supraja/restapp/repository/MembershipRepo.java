package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Membership;


public interface MembershipRepo 
{
	public List<Integer> getIDList();

	void save(Membership membership);

	List<Membership> findAll();

	void deleteById(int membershipid);

	Membership findById(int membershipid);
	
//	public CardRequest updateCardStatus(int cardreqid, String cardStatus);

}
