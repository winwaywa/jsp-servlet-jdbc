package com.blog.service.impl;

import com.blog.dao.impl.UserDAO;
import com.blog.model.UserModel;
import com.blog.service.IUserService;

public class UserService implements IUserService{

	private UserDAO userDAO;
	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel authUser(String username, String password) {
		return userDAO.authUser(username, password);
	}

}
