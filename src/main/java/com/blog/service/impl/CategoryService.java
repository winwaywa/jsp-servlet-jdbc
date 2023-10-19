package com.blog.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.blog.dao.ICategoryDAO;
import com.blog.dao.impl.CategoryDAO;
import com.blog.model.CategoryModel;
import com.blog.service.ICategoryService;

public class CategoryService implements ICategoryService {

	private ICategoryDAO categoryDao;

	public CategoryService() {
		categoryDao = new CategoryDAO();
	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel save(CategoryModel categoryModel) {
		categoryModel.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		categoryModel.setCreatedBy("");
		categoryModel.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		categoryModel.setUpdatedBy("");
		Long categoryId = categoryDao.save(categoryModel);
		return categoryDao.findOne(categoryId);
	}

	public CategoryModel update(CategoryModel categoryNew) {
		CategoryModel categoryOld = categoryDao.findOne(categoryNew.getId());
		if (categoryOld != null) {
			categoryNew.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			categoryNew.setUpdatedBy("");
			categoryDao.update(categoryNew);
		}
		return categoryDao.findOne(categoryNew.getId());
	}

	public void delete(long[] ids) {
		for(long id:ids) {
			// find news by categoryId -> delete
			categoryDao.delete(id);
		}
	}
}
