package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Trainers;

public interface TrainersRepo 
{
Trainers save(Trainers trainers);
	
	List<Trainers> findAll();
	
	void deleteById(int id);
	
	Trainers findById(int id);

	List<Integer> getIDList();
	
	 Trainers findBytrainerEmail(String trainerEmail);
	 
	 long count();
}
