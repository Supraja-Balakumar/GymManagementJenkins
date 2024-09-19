package com.supraja.restapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fitness")
public class FitnessStudio 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int fitnessid;
	
	@OneToOne(targetEntity = Member.class, cascade = CascadeType.ALL)
	private Member Member;
	
	@OneToOne(targetEntity = Trainers.class, cascade = CascadeType.ALL)
	private Trainers trainers;

	public int getFitnessid() {
		return fitnessid;
	}

	public void setFitnessid(int fitnessid) {
		this.fitnessid = fitnessid;
	}

	public Member getMember() {
		return Member;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public Trainers getTrainers() {
		return trainers;
	}

	public void setTrainers(Trainers trainers) {
		this.trainers = trainers;
	}

	public FitnessStudio(int fitnessid, com.supraja.restapp.model.Member member, Trainers trainers) {
		super();
		this.fitnessid = fitnessid;
		Member = member;
		this.trainers = trainers;
	}

	public FitnessStudio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
