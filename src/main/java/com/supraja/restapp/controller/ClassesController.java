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

import com.supraja.restapp.model.Classes;
import com.supraja.restapp.model.Membership;
import com.supraja.restapp.service.ClassesService;

@RestController
@RequestMapping("/slots")
@CrossOrigin(origins="*")
public class ClassesController 
{
	@Autowired
	private ClassesService service;
	
	@PostMapping
	public String insertClasses(@RequestBody Classes classes) {
		String msg = "";
		try {
			service.addClasses(classes);
			msg = "Successfully added";	
		} catch (Exception e) {
			msg = "Failure";
		}
		return msg;
	}
	
	
	@GetMapping("{id}")
	public Classes getClassesbyId(@PathVariable("id") int id) {
		return service.getClasses(id);
	}

	@GetMapping("/all")
	public List<Classes> getClasses() {
		return service.getAllClasses();
	}
	
	@PutMapping
	public String updateClasses(@RequestBody Classes classes) {
		String msg = "";
		try {
			service.updateClasses(classes);
			msg = "Updated Success";
		} catch (Exception e) {
			msg = "Updated Failure";
		}

		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteClasses(@PathVariable int id) {
		String msg = "";
		try {
			service.deleteClasses(id);
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
