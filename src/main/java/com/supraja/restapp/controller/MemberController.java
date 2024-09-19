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

import com.supraja.restapp.model.Member;
import com.supraja.restapp.service.MemberService;


@RestController
@RequestMapping("/member")
@CrossOrigin(origins="http://localhost:3000/")
public class MemberController 
{
	@Autowired
	  private MemberService service;
	
	@PostMapping
	public String insertMember(@RequestBody Member member) {
		String msg = "";
		try {
			service.addMember(member);
			msg = "Successfull";
		} catch (Exception e) {
			msg = "Failure";
		}

		return msg;
	}
	
	@GetMapping("{id}")
	public Member getMemberbyId(@PathVariable("id") int id) {
		return service.getMember(id);
	}
  
  @GetMapping("/all")
	public List<Member> getMember() {
		return service.getAllMember();
	}
  
  @PutMapping
 	public String updateMember(@RequestBody Member member) {
 		String msg = "";
 		try {
 			service.updateMember(member);
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
  public Member register(@RequestBody Member member) {
      return service.addMember(member);
  }
  
  @PostMapping("/login")
  public Member login(@RequestBody Member member) {
      Member existingMember = service.findByEmail(member.getEmail());

      if (existingMember != null && member.getPassword().equals(existingMember.getPassword())) {
          return existingMember;
      } else {
          return null;
      }
  }
  
  
  @GetMapping("/count")
  public long getMemberCount() {
      return service.getMemberCount();
  }
  
  
}
