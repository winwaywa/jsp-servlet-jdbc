package com.blog.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.model.CategoryModel;
import com.blog.paging.PageRequest;
import com.blog.paging.Pageble;
import com.blog.service.ICategoryService;
import com.blog.service.impl.CategoryService;
import com.blog.sorter.Sorter;
import com.blog.utils.ParameterToModelUtil;

@WebServlet(urlPatterns = { "/admin-category" })
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4999638233993917508L;

	private ICategoryService categoryService;

	public CategoryController() {
		categoryService = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bind parameter to model
		CategoryModel model = ParameterToModelUtil.bindToModel(CategoryModel.class, req);

		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortName(), model.getSortValue()));
		model.setDataList(categoryService.findAll(pageble));
		model.setTotalItems(categoryService.getTotalItems());
		model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItem()));

		req.setAttribute("model", model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
