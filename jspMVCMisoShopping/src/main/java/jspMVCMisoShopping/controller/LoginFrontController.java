package jspMVCMisoShopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.service.login.UserLoginService;

public class LoginFrontController extends HttpServlet{
	
	protected void doprocess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/login.login")) {
			System.out.println("login.login");
			UserLoginService action = new UserLoginService();
			int i = action.execute(req);
			if(i == 1) resp.sendRedirect(contextPath);
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.forward(req, resp);
			}
		} else if (command.equals("/Logout.login")) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect(contextPath);
		} else if(command.equals("/loginCk.login")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		} else if(command.equals("/login1.login")) {
			UserLoginService action = new UserLoginService();
			int i = action.execute(req);
			if(i == 1) {
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html; charset=utf-8");
				out.print("<script type='text/javascript'>");
				out.print("opener.document.location.reload();");
				out.print("window.self.close();");
				out.print("</script>");
				out.close();
			}else {
				RequestDispatcher dispatcher =
						req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
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
