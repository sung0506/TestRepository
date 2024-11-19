package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.user.IdCheckService;
import jspMVCMisoShopping.service.user.UserWriteService;

public class UserFrontController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/userAgree.nhn")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("user/userAgree.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/userWrite.nhn")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("user/userForm.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/userRegist.nhn")) {
			UserWriteService action = new UserWriteService();
			action.execute(req);
			resp.sendRedirect(req.getContextPath());
		} else if (command.equals("/idCheck.nhn")) {
			IdCheckService action = new IdCheckService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("user/idCheck.jsp");
			dispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}