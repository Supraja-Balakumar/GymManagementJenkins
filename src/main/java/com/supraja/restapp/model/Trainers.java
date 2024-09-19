package com.supraja.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainers 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int trainerid;
	@Column
	private String trainername;
	@Column
	private String trainerEmail;
	@Column
	private String password;
	@Column
	private String phonenumber;
	@Column
	private String age;
	@Column
	private String specialization;
	@Column
	private String availability;
	
	@Lob
    @Column(name = "certifications",length=1000000000)
    private byte[] certifications;

	public int getTrainerid() {
		return trainerid;
	}

	public void setTrainerid(int trainerid) {
		this.trainerid = trainerid;
	}

	public String getTrainername() {
		return trainername;
	}

	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public byte[] getCertifications() {
		return certifications;
	}

	public void setCertifications(byte[] certifications) {
		this.certifications = certifications;
	}

	public Trainers(int trainerid, String trainername, String trainerEmail, String password, String phonenumber,
			String age, String specialization, String availability, byte[] certifications) {
		super();
		this.trainerid = trainerid;
		this.trainername = trainername;
		this.trainerEmail = trainerEmail;
		this.password = password;
		this.phonenumber = phonenumber;
		this.age = age;
		this.specialization = specialization;
		this.availability = availability;
		this.certifications = certifications;
	}

	public Trainers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
