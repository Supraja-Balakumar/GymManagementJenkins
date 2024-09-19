package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.Member;

public interface MemberService 
{
	public Member addMember(Member member);

	public Member getMember(int id);

	public List<Member> getAllMember();

	public void updateMember(Member member);

	public void deleteMember(int id);
	
	public List<Integer> getAllId();

	public Member findByEmail(String email);
	
	long getMemberCount();
}
