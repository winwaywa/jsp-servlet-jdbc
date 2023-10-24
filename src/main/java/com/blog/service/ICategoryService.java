package com.blog.service;

import java.util.List;

import com.blog.model.CategoryModel;
import com.blog.paging.Pageble;

public interface ICategoryService {


	List<CategoryModel> findAll(Pageble pageble);

	CategoryModel save(CategoryModel categoryModel);

	CategoryModel update(CategoryModel categoryModel);

	void delete(Long[] ids);

	int getTotalItems();
	
	CategoryModel findOne(Long id);

}
