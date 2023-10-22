package com.blog.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.model.UserModel;
import com.blog.service.ICategoryService;
import com.blog.service.INewService;
import com.blog.service.IUserService;
import com.blog.service.impl.CategoryService;
import com.blog.service.impl.NewService;
import com.blog.service.impl.UserService;
import com.blog.utils.ParameterToModelUtil;
import com.blog.utils.SessionUtil;

@WebServlet(urlPatterns = { "/home", "/login", "/logout" })
public class HomeController extends HttpServlet {
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService;
	private INewService newService;
	private IUserService userService;

	public HomeController() {
		categoryService = new CategoryService();
		newService = new NewService();
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String message = req.getParameter("message");
		String alert = req.getParameter("alert");

		if (action != null && action.equals("login")) {
			if (message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/authentication/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel user = ParameterToModelUtil.bindToModel(UserModel.class, req);
			UserModel auth_user = userService.authUser(user.getUserName(), user.getPassWord());
			if (auth_user != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", auth_user);
				if (auth_user.getRoleModel().getCode().equals("admin")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				} else if (auth_user.getRoleModel().getCode().equals("user")) {
					resp.sendRedirect(req.getContextPath() + "/home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login&message=login_fail&alert=danger");
			}
		}
	}
}
