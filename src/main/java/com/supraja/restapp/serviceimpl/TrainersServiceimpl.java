package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.Member;
import com.supraja.restapp.model.Trainers;
import com.supraja.restapp.repository.MemberRepo;
import com.supraja.restapp.repository.TrainersRepo;
import com.supraja.restapp.service.TrainersService;

@Service
public class TrainersServiceimpl implements TrainersService
{
	@Autowired
	TrainersRepo repo;
	
	@Override
	public Trainers addTrainers(Trainers trainers) {
		return repo.save(trainers);
	}

	@Override
	public Trainers getTrainers(int id) {
		Trainers trainers = repo.findById(id);
		return trainers;
	}

	@Override
	public List<Trainers> getAllTrainers() {
		return repo.findAll();
	}

	@Override
	public void updateTrainers(Trainers trainers) {
		repo.save(trainers);
		
	}

	@Override
	public void deleteTrainers(int id) {
		repo.deleteById(id);
		
	}
	
	public List<Integer> getAllId() {
		return repo.getIDList();
	}
	
	@Override
	public Trainers findBytrainerEmail(String trainerEmail) {
		 return repo.findBytrainerEmail(trainerEmail);
	}
	
	
	@Override
    public long count() {
        return repo.count();
    }

	
	
}
