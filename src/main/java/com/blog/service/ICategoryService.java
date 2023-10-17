package com.blog.service;

import java.util.List;

import com.blog.model.CategoryModel;

public interface ICategoryService {
	
	List<CategoryModel> findAll();
	CategoryModel save(CategoryModel categoryModel);
}
