package com.supraja.restapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "membership")
public class Membership 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int membershipid;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String membershipType;  
	@Column
	private String membershipStartdate;
	@Column 
	private String membershipEnddate;
	@Column
	private String timings;
	@Column
	private String medicalConditions;
	
	
	@OneToOne(targetEntity = Member.class, cascade = CascadeType.ALL)
	private Member member;


	public int getMembershipid() {
		return membershipid;
	}


	public void setMembershipid(int membershipid) {
		this.membershipid = membershipid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMembershipType() {
		return membershipType;
	}


	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}


	public String getMembershipStartdate() {
		return membershipStartdate;
	}


	public void setMembershipStartdate(String membershipStartdate) {
		this.membershipStartdate = membershipStartdate;
	}


	public String getMembershipEnddate() {
		return membershipEnddate;
	}


	public void setMembershipEnddate(String membershipEnddate) {
		this.membershipEnddate = membershipEnddate;
	}


	public String getTimings() {
		return timings;
	}


	public void setTimings(String timings) {
		this.timings = timings;
	}


	public String getMedicalConditions() {
		return medicalConditions;
	}


	public void setMedicalConditions(String medicalConditions) {
		this.medicalConditions = medicalConditions;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Membership(int membershipid, String name, String email, String membershipType, String membershipStartdate,
			String membershipEnddate, String timings, String medicalConditions, Member member) {
		super();
		this.membershipid = membershipid;
		this.name = name;
		this.email = email;
		this.membershipType = membershipType;
		this.membershipStartdate = membershipStartdate;
		this.membershipEnddate = membershipEnddate;
		this.timings = timings;
		this.medicalConditions = medicalConditions;
		this.member = member;
	}


	public Membership() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
