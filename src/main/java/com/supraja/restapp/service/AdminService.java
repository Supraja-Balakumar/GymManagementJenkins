package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.Admin;

public interface AdminService 
{
	public Admin addAdmin(Admin admin);

	public Admin getAdmin(int id);

	public List<Admin> getAllAdmin();

	public void updateAdmin(Admin admin);

	public void deleteAdmin(int id);
	
	public List<Integer> getAllId();

	public Admin findByEmail(String email);
}
