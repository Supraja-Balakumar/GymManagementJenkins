package com.supraja.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supraja.restapp.model.Admin;
import com.supraja.restapp.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class AdminController 
{
	@Autowired
	  private AdminService service;
	
	@PostMapping
	public String insertAdmin(@RequestBody Admin admin) {
		String msg = "";
		try {
			service.addAdmin(admin);
			msg = "Successfull";
		} catch (Exception e) {
			msg = "Failure";
		}

		return msg;
	}
	
	@GetMapping("{id}")
	public Admin getAdminbyId(@PathVariable("id") int id) {
		return service.getAdmin(id);
	}
  
  @GetMapping("/all")
	public List<Admin> getAdmin() {
		return service.getAllAdmin();
	}
  
  @PutMapping
	public String updateAdmin(@RequestBody Admin admin) {
		String msg = "";
		try {
			service.updateAdmin(admin);
			msg = " Update Success";
		} catch (Exception e) {
			msg = "Failure update";
		}

		return msg;
	}
  
  @GetMapping("/idlist")
	public List<Integer> getIDList() {
		return service.getAllId();
	}

@PostMapping("/register")
public Admin register(@RequestBody Admin admin) {
    return service.addAdmin(admin);
}

@PostMapping("/login")
public Admin login(@RequestBody Admin admin) {
    Admin existingAdmin = service.findByEmail(admin.getEmail());

    if (existingAdmin != null && admin.getPassword().equals(existingAdmin.getPassword())) {
        return existingAdmin;
    } else {
        return null;
    }
}
}
