package com.blog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.dao.INewDAO;
import com.blog.mapper.CategoryMapper;
import com.blog.mapper.NewMapper;
import com.blog.mapper.RowMapper;
import com.blog.model.CategoryModel;
import com.blog.model.NewsModel;

public class NewDAO extends BaseDAO<NewsModel> implements INewDAO {

	private RowMapper<NewsModel> rowMapper;
	public NewDAO() {
		rowMapper = new NewMapper();
	}
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "select * from news where category_id = ?";
		return query(sql, rowMapper, categoryId);
	}

}
