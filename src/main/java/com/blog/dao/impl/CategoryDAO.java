package com.blog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.dao.ICategoryDAO;
import com.blog.mapper.CategoryMapper;
import com.blog.mapper.RowMapper;
import com.blog.model.CategoryModel;

public class CategoryDAO extends BaseDAO<CategoryModel> implements ICategoryDAO {

	private RowMapper<CategoryModel> rowMapper;
	public CategoryDAO() {
		rowMapper = new CategoryMapper();
	}
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, rowMapper);
	}

}
