package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.Membership;
import com.supraja.restapp.repoimpl.MembershipRepoimpl;
import com.supraja.restapp.service.MembershipService;


@Service
public class MembershipServiceimpl implements MembershipService
{
	@Autowired
	MembershipRepoimpl repo;
	
	@Override
	public String addMembership(Membership membership) {
		repo.save(membership);
		return "AddSuccess";
	}

	@Override
	public Membership getMembership(int id) {
		Membership membership = repo.findById(id);
		return membership;
	}

	@Override
	public List<Membership> getAllMembership() {
		return repo.findAll();
	}

	@Override
	public void updateMembership(Membership membership) {
		repo.save(membership);

	}

	@Override
	public void deleteMembership(int id) {
		repo.deleteById(id);

	}

	public List<Integer> getAllId() {
		return repo.getIDList();
	}
}
