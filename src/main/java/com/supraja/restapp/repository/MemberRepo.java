package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Member;



public interface MemberRepo 
{
public List<Integer> getIDList();
    
	Member save(Member member);
	
	List<Member> findAll();
	
	void deleteById(int id);
	
	Member findById(int id);
	
    Member findByEmail(String email);
    
    long getMemberCount();
}
