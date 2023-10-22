package com.blog.dao.impl;

import java.util.List;

import com.blog.dao.IUserDAO;
import com.blog.mapper.UserMapper;
import com.blog.model.UserModel;

public class UserDAO extends BaseDAO<UserModel> implements IUserDAO {

	private UserMapper rowMapper;
	public UserDAO() {
		this.rowMapper = new UserMapper();
	}
	
	@Override
	public UserModel authUser(String username, String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user u ");
		sql.append("inner join role r on u.role_id = r.id ");
		sql.append("where username=? and password=? and status=1");
		List<UserModel> users =  query(sql.toString(), rowMapper, username, password);
		return !users.isEmpty() ? users.get(0) : null;
	}

}
