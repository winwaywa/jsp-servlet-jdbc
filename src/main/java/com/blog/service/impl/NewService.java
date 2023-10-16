package com.blog.service.impl;

import java.util.List;

import com.blog.dao.INewDAO;
import com.blog.dao.impl.NewDAO;
import com.blog.model.NewsModel;
import com.blog.service.INewService;

public class NewService implements INewService {

	private INewDAO newDao;
	public NewService() {
		newDao = new NewDAO();
	}
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

}
