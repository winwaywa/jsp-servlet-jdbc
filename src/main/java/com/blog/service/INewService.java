package com.blog.service;

import java.util.List;

import com.blog.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
}
