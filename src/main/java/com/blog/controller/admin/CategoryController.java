package com.blog.controller.admin;

import java.io.IOException;
import java.util.ResourceBundle;

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

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	private ICategoryService categoryService;

	public CategoryController() {
		categoryService = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "";

		// bind parameter to model
		CategoryModel model = ParameterToModelUtil.bindToModel(CategoryModel.class, req);

		if (model.getType().equals("list")) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortValue()));
			model.setDataList(categoryService.findAll(pageble));
			model.setTotalItems(categoryService.getTotalItems());
			model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItem()));

			view = "/views/admin/category/list.jsp";

		} else if (model.getType().equals("edit")) {
			if (model.getId() != null) {
				model = categoryService.findOne(model.getId());
			} else {
				model = null;
			}
			view = "/views/admin/category/edit.jsp";

		}
		String message = req.getParameter("message");
		String messageResponse = "";
		String alert = "";
		if (message != null) {
			if (message.equals("insert_success") || message.equals("update_success") || message.equals("delete_success")
					|| message.equals("insert_fail") || message.equals("update_fail") || message.equals("delete_fail")){
				messageResponse = resourceBundle.getString(message);
				if(message.equals("insert_success") || message.equals("update_success") || message.equals("delete_success")) {
					alert = "success";
				}else {
					alert = "danger";
				}
			}
		}
		req.setAttribute("alert", alert);
		req.setAttribute("message", messageResponse);

		req.setAttribute("model", model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
