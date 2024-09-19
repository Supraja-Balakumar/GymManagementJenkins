package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.Membership;


public interface MembershipService 
{
	public String addMembership(Membership membership);

	public Membership getMembership(int id);

	public List<Membership> getAllMembership();

	public void updateMembership(Membership membership);

	public void deleteMembership(int id);

	public List<Integer> getAllId();

//	Membership updateCardStatus(int cardreqid, String cardStatus);
}
