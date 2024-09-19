package com.supraja.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supraja.restapp.model.Membership;
import com.supraja.restapp.service.MembershipService;


@RestController
@RequestMapping("/membership")
@CrossOrigin(origins="*")
public class MembershipController 
{
	@Autowired
	private MembershipService service;
	
	@PostMapping
	public String insertMembership(@RequestBody Membership membership) {
		String msg = "";
		try {
			service.addMembership(membership);
			msg = "Successfully added";	
		} catch (Exception e) {
			msg = "Failure";
		}
		return msg;
	}
	
	@GetMapping("{id}")
	public Membership getMembershipbyId(@PathVariable("id") int id) {
		return service.getMembership(id);
	}

	@GetMapping("/all")
	public List<Membership> getMembership() {
		return service.getAllMembership();
	}

	@PutMapping
	public String updateMembership(@RequestBody Membership membership) {
		String msg = "";
		try {
			service.updateMembership(membership);
			msg = "Updated Success";
		} catch (Exception e) {
			msg = "Updated Failure";
		}

		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteMembership(@PathVariable int id) {
		String msg = "";
		try {
			service.deleteMembership(id);
			msg = "Deleted Successfully";
		} catch (Exception e) {
			msg = "Deletion Failure";
		}

		return msg;
	}
	
	@GetMapping("/idlist")
	public List<Integer> getIDList() {
		return service.getAllId();
	}
	

	
}
