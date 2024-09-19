package com.supraja.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberid;
	@Column
	private String plantype;
	@Column
	private String name;
	@Column
	private String gender;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String age;
	@Column
	private String weight;
	@Column
	private String height;
    @Column
    private String bmi;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String gymbefore;
    @Column
    private String password;
    
    @Column
    private String contactname;
    @Column
    private String relationship;
    @Column
    private String contactnumber;
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getPlantype() {
		return plantype;
	}
	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGymbefore() {
		return gymbefore;
	}
	public void setGymbefore(String gymbefore) {
		this.gymbefore = gymbefore;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public Member(int memberid, String plantype, String name, String gender, String email, String phone, String age,
			String weight, String height, String bmi, String address, String city, String gymbefore, String password,
			String contactname, String relationship, String contactnumber) {
		super();
		this.memberid = memberid;
		this.plantype = plantype;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.bmi = bmi;
		this.address = address;
		this.city = city;
		this.gymbefore = gymbefore;
		this.password = password;
		this.contactname = contactname;
		this.relationship = relationship;
		this.contactnumber = contactnumber;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
}
