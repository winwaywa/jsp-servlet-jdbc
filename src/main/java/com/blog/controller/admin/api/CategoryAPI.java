package com.blog.controller.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.model.CategoryModel;
import com.blog.service.impl.CategoryService;
import com.blog.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPI extends HttpServlet {

	private static final long serialVersionUID = 4394594317623918701L;

	private CategoryService categoryService;
	public CategoryAPI() {
		categoryService = new CategoryService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel categoryModel = HttpUtil.convertToString(req.getReader()).bindToModel(CategoryModel.class);
		CategoryModel categoryNew = categoryService.save(categoryModel);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), categoryNew);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel categoryModel = HttpUtil.convertToString(req.getReader()).bindToModel(CategoryModel.class);
		CategoryModel categoryNew = categoryService.update(categoryModel);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), categoryNew);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel categoryModel = HttpUtil.convertToString(req.getReader()).bindToModel(CategoryModel.class);
		categoryService.delete(categoryModel.getIds());
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
