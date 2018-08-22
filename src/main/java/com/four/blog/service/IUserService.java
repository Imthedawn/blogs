package com.four.blog.service;

import com.four.blog.po.User;

public interface IUserService {

	boolean addUser(User user);

	User select(User user);
}
