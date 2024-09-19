package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.Member;
import com.supraja.restapp.repository.MemberRepo;
import com.supraja.restapp.service.MemberService;



@Service
public class MemberServiceimpl implements MemberService
{
	@Autowired
	MemberRepo repo;
	
	@Override
	public Member addMember(Member member) {
		return repo.save(member);
	}

	@Override
	public Member getMember(int id) {
		Member member = repo.findById(id);
		return member;
	}

	@Override
	public List<Member> getAllMember() {
		return repo.findAll();
	}

	@Override
	public void updateMember(Member member) {
		repo.save(member);
		
	}

	@Override
	public void deleteMember(int id) {
		repo.deleteById(id);
		
	}
	
	public List<Integer> getAllId() {
		return repo.getIDList();
	}

	@Override
	public Member findByEmail(String email) {
		 return repo.findByEmail(email);
	}
	
	@Override
    public long getMemberCount() {
        return repo.getMemberCount();
    }

}
