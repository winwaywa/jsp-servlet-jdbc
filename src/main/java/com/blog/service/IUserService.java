package com.blog.service;

import com.blog.model.UserModel;

public interface IUserService {
	UserModel authUser(String username, String password);
}
