package com.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.blog.model.RoleModel;
import com.blog.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setPassWord(resultSet.getString("password"));
			user.setFullName(resultSet.getString("fullname"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleId(resultSet.getLong("role_id"));
			try {
				RoleModel roleModel = new RoleModel();
				roleModel.setCode(resultSet.getString("code"));
				roleModel.setName(resultSet.getString("name"));
				user.setRoleModel(roleModel);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			user.setCreatedAt(resultSet.getTimestamp("createdAt"));
			user.setCreatedBy(resultSet.getString("createdBy"));
			user.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
			user.setUpdatedBy(resultSet.getString("updatedBy"));
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
}
