package com.supraja.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Trainers;
import com.supraja.restapp.repository.TrainersRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class TrainersRepoimpl implements TrainersRepo
{
	@Autowired
	  private EntityManager entityManager;
	
	 public List<Integer> getIDList() {
			String jpql="Select t.id from Trainers t";
			TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
			return query.getResultList();
		}
	 
	 public Trainers save(Trainers trainers) {
			return entityManager.merge(trainers);
		}
	 
	 public List<Trainers> findAll() {
			String jpql="From Trainers";
			TypedQuery<Trainers> query = entityManager.createQuery(jpql,Trainers.class);
			return query.getResultList();
		}
	 
	 public void deleteById(int id) {
			String jpql="delete from Trainers where id=" +id;
			entityManager.createQuery(jpql).executeUpdate();
		}

		public Trainers findById(int id) {
			return entityManager.find(Trainers.class, id);
		}
		
		public Trainers findBytrainerEmail(String trainerEmail) {
	        try {
	            String jpql = "SELECT t FROM Trainers t WHERE t.trainerEmail = :trainerEmail";
	            Query query = entityManager.createQuery(jpql);
	            query.setParameter("trainerEmail", trainerEmail);
	            return (Trainers) query.getSingleResult();
	        } catch (NoResultException e) {
	            // Handle the case where no result is found
	            return null; // or throw a custom exception depending on your requirements
	        }
	    }
		
		
		@Override
	    public long count() {
	        String jpql = "SELECT COUNT(t) FROM Trainers t";
	        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
	        return query.getSingleResult();
	    }
		
		
}
