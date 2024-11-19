package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.help.FindPwService;
import jspMVCMisoShopping.service.user.UserFindIdService;
import jspMVCMisoShopping.service.user.UserFindPwService;

public class HelpFrontController extends HttpServlet{
	
	protected void doprocess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/idInquiry.help")) {
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("help/findId.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/idFind.help")) {
			UserFindIdService action = new UserFindIdService();
			action.execute(req);
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("help/findIdOk.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/pwInquiry.help")) {
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("help/findPw.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/findPwOk.help")) {
			FindPwService action = new FindPwService();
			action.execute(req);
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("help/findPwOk.jsp");
			dispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doprocess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doprocess(req, resp);
	}
}
