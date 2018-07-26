package com.zjl.spring.tx.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjl.spring.tx.dao.TestDAO;
import com.zjl.spring.tx.model.User;

@Service
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		// sessionFactory.openSession() 会使事务失效
	   // 但是 getCurrentSession 外层方法不能没有事务........MMP
	}

}
