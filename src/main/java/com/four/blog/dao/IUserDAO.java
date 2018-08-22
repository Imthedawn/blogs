package com.four.blog.dao;

import java.io.Serializable;

import com.four.blog.po.User;

public interface IUserDAO {

	Serializable insert(User user);

	User findByName(String userName);

}
