package com.four.blog.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.four.blog.dao.IUserDAO;
import com.four.blog.po.User;

@Repository
public class UserDaoImpl implements IUserDAO {

	@Autowired SessionFactory sessionFactory;
	@Override
	public Serializable insert(User user) {
		Serializable id = sessionFactory.getCurrentSession().save(user);
		System.out.println(id+"’‚ «id");
		return id;
	}

	@Override
	public User findByName(String userName) {
		String hql = "from User u where u.userName=:username";
		return (User)sessionFactory.getCurrentSession().createQuery(hql)
		     .setParameter("username", userName).uniqueResult();
	}
}
