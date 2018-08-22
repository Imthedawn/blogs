package com.four.blog.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.four.blog.dao.IUserDAO;
import com.four.blog.po.User;
import com.four.blog.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired IUserDAO userDao;
	
	@Override
	public boolean addUser(User user) {
		String userName = user.getUserName();
		if(userName != null && userName.length() >= 3 && userName.length() < 10) {
			if(user.getPassword().equals(user.getRepassword())) {
				Serializable oid = userDao.insert(user);
				System.out.println(oid);
				if(oid != null) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public User select(User user) {
		User u = userDao.findByName(user.getUserName());
		if(user != null && u.getPassword().equals(user.getPassword())) {
			return u;
		}
		return null;
	}
}
