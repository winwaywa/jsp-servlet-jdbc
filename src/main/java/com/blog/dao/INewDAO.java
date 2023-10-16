package com.blog.dao;

import java.util.List;

import com.blog.model.NewsModel;

public interface INewDAO extends GenericDAO<NewsModel>{
	
	List<NewsModel> findByCategoryId(Long categoryId);
}
