package com.blog.service.impl;

import java.util.List;

import com.blog.dao.ICategoryDAO;
import com.blog.dao.impl.CategoryDAO;
import com.blog.model.CategoryModel;
import com.blog.service.ICategoryService;

public class CategoryService implements ICategoryService{

	private ICategoryDAO categoryDao;
	
	public CategoryService() {
		categoryDao = new CategoryDAO();
	}
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

}
