package com.techprimers.repository.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techprimers.model.User;
import com.techprimers.repository.LoginJpaRespository;



@Repository
@Transactional
public class LoginJpaRespositoryImpl   implements LoginJpaRespository   {

	@Autowired
	private EntityManager entityManager;
	
	
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@Override
	public int loginValidate(int user_id, String password) {	
		/*
		 * Query query=entityManager.
		 * createQuery("SELECT COUNT(*)  FROM User WHERE user_id=:user_id and pwd=:pwd")
		 * .setParameter("user_id", user_id).setParameter("pwd", password); return
		 * query.getResultList().size();
		 */
		
		Session session=getSession();
		Criteria criteria=session.createCriteria(User.class);
	                      criteria.add(Restrictions.eq("user_id", user_id));
	                      criteria.add(Restrictions.eq("pwd", password));
	   return criteria.list().size();
	   
	}



}
