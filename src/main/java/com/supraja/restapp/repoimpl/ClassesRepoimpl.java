package com.supraja.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Classes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class ClassesRepoimpl 
{
	@Autowired
	  private EntityManager entityManager;
	
	 public List<Integer> getIDList() {
			String jpql="Select c.classid from Classes c";
			TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
			return query.getResultList();
		}
	 
	 public void save(Classes classes) {
			
			entityManager.merge(classes);
		}
	 
	 public List<Classes> findAll() {
			String jpql="From Classes";
			TypedQuery<Classes> query = entityManager.createQuery(jpql,Classes.class);
			return query.getResultList();
		}
	 
	 public void deleteById(int classid) {
			String jpql="delete from Classes where classid=" +classid;
			entityManager.createQuery(jpql).executeUpdate();
		}
	 
	 public Classes findById(int classid) {
			return entityManager.find(Classes.class, classid);
		}
}
