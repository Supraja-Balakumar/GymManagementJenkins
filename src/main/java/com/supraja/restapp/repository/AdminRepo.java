package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Admin;


public interface AdminRepo 
{
Admin save(Admin admin);
	
	List<Admin> findAll();
	
	void deleteById(int id);
	
	Admin findById(int id);
	
	   
	   Admin findByEmail(String email);

	List<Integer> getIDList();
}
