package com.supraja.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Admin;
import com.supraja.restapp.repository.AdminRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class AdminRepoimpl implements AdminRepo
{
	@Autowired
	  private EntityManager entityManager;

	public List<Integer> getIDList() {
		String jpql="Select a.id from Admin a";
		TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
		return query.getResultList();
	}
	
	 public Admin save(Admin admin) {
			return entityManager.merge(admin);
		}
	 
	 public List<Admin> findAll() {
			String jpql="From Admin";
			TypedQuery<Admin> query = entityManager.createQuery(jpql,Admin.class);
			return query.getResultList();
		}
	 
	 public void deleteById(int id) {
			String jpql="delete from Admin where id=" +id;
			entityManager.createQuery(jpql).executeUpdate();
		}

		public Admin findById(int id) {
			return entityManager.find(Admin.class, id);
		}
		
		public Admin findByEmail(String email) {
	        try {
	            String jpql = "SELECT a FROM Admin a WHERE a.email = :email";
	            Query query = entityManager.createQuery(jpql);
	            query.setParameter("email", email);
	            return (Admin) query.getSingleResult();
	        } catch (NoResultException e) {
	            // Handle the case where no result is found
	            return null; // or throw a custom exception depending on your requirements
	        }
	    }
}
