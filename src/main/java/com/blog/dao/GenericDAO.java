package com.blog.dao;

import java.util.List;

import com.blog.mapper.RowMapper;

public interface GenericDAO<T> {

	List<T> query(String sql, RowMapper<T> rowMapper, Object ...parameters);

}