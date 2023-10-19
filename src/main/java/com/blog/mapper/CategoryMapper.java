package com.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.blog.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		try {
			CategoryModel category = new CategoryModel();
			category.setId(resultSet.getLong("id"));
			category.setName(resultSet.getString("name"));
			category.setCode(resultSet.getString("code"));
			category.setCreatedAt(resultSet.getTimestamp("createdAt"));
			category.setCreatedBy(resultSet.getString("createdBy"));
			category.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
			category.setUpdatedBy(resultSet.getString("updatedBy"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
