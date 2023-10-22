package com.blog.dao;

import java.util.List;

import com.blog.model.NewsModel;
import com.blog.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	
	UserModel authUser(String username, String password);
}
