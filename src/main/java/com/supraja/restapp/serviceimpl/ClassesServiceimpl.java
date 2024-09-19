package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.Classes;
import com.supraja.restapp.model.Membership;
import com.supraja.restapp.repoimpl.ClassesRepoimpl;
import com.supraja.restapp.repoimpl.MembershipRepoimpl;
import com.supraja.restapp.service.ClassesService;

@Service
public class ClassesServiceimpl implements ClassesService
{
	@Autowired
	ClassesRepoimpl repo;
	
	@Override
	public String addClasses(Classes classes) {
		repo.save(classes);
		return "AddSuccess";
	}

	@Override
	public Classes getClasses(int id) {
		Classes classes = repo.findById(id);
		return classes;
	}

	@Override
	public List<Classes> getAllClasses() {
		return repo.findAll();
	}

	@Override
	public void updateClasses(Classes classes) {
		repo.save(classes);

	}

	@Override
	public void deleteClasses(int id) {
		repo.deleteById(id);

	}

	public List<Integer> getAllId() {
		return repo.getIDList();
	}
}
