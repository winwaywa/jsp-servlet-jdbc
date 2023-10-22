package com.blog.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.blog.dao.ICategoryDAO;
import com.blog.dao.impl.CategoryDAO;
import com.blog.model.CategoryModel;
import com.blog.model.UserModel;
import com.blog.paging.Pageble;
import com.blog.service.ICategoryService;
import com.blog.utils.SessionUtil;

public class CategoryService implements ICategoryService {

	private ICategoryDAO categoryDao;

	public CategoryService() {
		categoryDao = new CategoryDAO();
	}

	@Override
	public List<CategoryModel> findAll(Pageble pageble) {
		return categoryDao.findAll(pageble);
	}

	@Override
	public CategoryModel save(CategoryModel categoryModel) {
		categoryModel.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		categoryModel.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		Long categoryId = categoryDao.save(categoryModel);
		return categoryDao.findOne(categoryId);
	}

	public CategoryModel update(CategoryModel categoryNew) {
		CategoryModel categoryOld = categoryDao.findOne(categoryNew.getId());
		if (categoryOld != null) {
			categoryNew.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
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

	@Override
	public int getTotalItems() {
		return categoryDao.count();
	}
}
