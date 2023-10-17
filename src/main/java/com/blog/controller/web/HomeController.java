package com.blog.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.service.ICategoryService;
import com.blog.service.INewService;
import com.blog.service.impl.CategoryService;
import com.blog.service.impl.NewService;

@WebServlet(urlPatterns = { "/home", "/login" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService;
	private INewService newService;
	
	public HomeController() {
		categoryService = new CategoryService();
		newService = new NewService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
