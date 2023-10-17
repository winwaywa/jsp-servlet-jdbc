package com.blog.dao;

import java.util.List;

import com.blog.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	
	List<CategoryModel> findAll();
	Long save(CategoryModel categoryModel);
}
