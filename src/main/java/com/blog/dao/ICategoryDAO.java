package com.blog.dao;

import java.util.List;

import com.blog.model.CategoryModel;
import com.blog.paging.Pageble;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {

	List<CategoryModel> findAll(Pageble pageble);

	CategoryModel findOne(Long id);

	Long save(CategoryModel categoryModel);

	boolean update(CategoryModel categoryModel);

	boolean delete(long id);

	int count();
}
