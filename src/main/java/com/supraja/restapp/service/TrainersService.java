package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.Trainers;

public interface TrainersService 
{
	public Trainers addTrainers(Trainers trainers);

	public Trainers getTrainers(int id);

	public List<Trainers> getAllTrainers();

	public void updateTrainers(Trainers trainers);

	public void deleteTrainers(int id);
	
	public List<Integer> getAllId();

	public Trainers findBytrainerEmail(String trainerEmail);
	
	 long count();

}
