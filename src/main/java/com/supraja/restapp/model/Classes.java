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
@Table(name = "class")
public class Classes 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classid;
	@Column
	private String slot1;  //5 to 6am
	@Column
	private String slot2;  //6 to 8am
	@Column
	private String slot3;  //8 to 10am
	@Column
	private String slot4;  //4 to 5pm
	@Column
	private String slot5;  //5 to 7pm
	@Column
	private String slot6;  //7 to 9pm
	
	
	@OneToOne(targetEntity = Member.class, cascade = CascadeType.ALL)
	private Member member;


	public int getClassid() {
		return classid;
	}


	public void setClassid(int classid) {
		this.classid = classid;
	}


	public String getSlot1() {
		return slot1;
	}


	public void setSlot1(String slot1) {
		this.slot1 = slot1;
	}


	public String getSlot2() {
		return slot2;
	}


	public void setSlot2(String slot2) {
		this.slot2 = slot2;
	}


	public String getSlot3() {
		return slot3;
	}


	public void setSlot3(String slot3) {
		this.slot3 = slot3;
	}


	public String getSlot4() {
		return slot4;
	}


	public void setSlot4(String slot4) {
		this.slot4 = slot4;
	}


	public String getSlot5() {
		return slot5;
	}


	public void setSlot5(String slot5) {
		this.slot5 = slot5;
	}


	public String getSlot6() {
		return slot6;
	}


	public void setSlot6(String slot6) {
		this.slot6 = slot6;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Classes(int classid, String slot1, String slot2, String slot3, String slot4, String slot5, String slot6,
			Member member) {
		super();
		this.classid = classid;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
		this.slot4 = slot4;
		this.slot5 = slot5;
		this.slot6 = slot6;
		this.member = member;
	}


	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

