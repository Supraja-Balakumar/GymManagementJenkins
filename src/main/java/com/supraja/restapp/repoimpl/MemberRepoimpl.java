package com.supraja.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Member;
import com.supraja.restapp.repository.MemberRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class MemberRepoimpl implements MemberRepo
{
	@Autowired
	  private EntityManager entityManager;
	
	 public List<Integer> getIDList() {
			String jpql="Select m.id from Member m";
			TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
			return query.getResultList();
		}
	 
	 public Member save(Member member) {
			return entityManager.merge(member);
		}
	 
	 public List<Member> findAll() {
			String jpql="From Member";
			TypedQuery<Member> query = entityManager.createQuery(jpql,Member.class);
			return query.getResultList();
		}
	 
	 public void deleteById(int id) {
			String jpql="delete from Member where id=" +id;
			entityManager.createQuery(jpql).executeUpdate();
		}

		public Member findById(int id) {
			return entityManager.find(Member.class, id);
		}
		
		 public Member findByEmail(String email) {
		        try {
		            String jpql = "SELECT m FROM Member m WHERE m.email = :email";
		            Query query = entityManager.createQuery(jpql);
		            query.setParameter("email", email);
		            return (Member) query.getSingleResult();
		        } catch (NoResultException e) {
		            // Handle the case where no result is found
		            return null; // or throw a custom exception depending on your requirements
		        }
		    }
		 
		 
		 @Override
		    public long getMemberCount() {
		        String jpql = "SELECT COUNT(m) FROM Member m";
		        Query query = entityManager.createQuery(jpql);
		        return (long) query.getSingleResult();
		    }
}
