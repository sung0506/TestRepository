package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.review.ReviewDeleteService;
import jspMVCMisoShopping.service.review.ReviewDetailService;
import jspMVCMisoShopping.service.review.ReviewListService;
import jspMVCMisoShopping.service.review.ReviewWriteService;

public class ReviewFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/reviewRegist.review")) {
			ReviewDetailService action = new ReviewDetailService();
			action.execute(req);
			
			req.setAttribute("purchaseNum", req.getParameter("purchaseNum"));
			req.setAttribute("goodsNum", req.getParameter("goodsNUm"));
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("review/reviewForm.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/reviewWrite.review")) {
			ReviewWriteService action = new ReviewWriteService(req);
			action.execute(req);
			resp.sendRedirect("purchaseList.item");
		} else if (command.equals("/reviewDelete.review")) {
			ReviewDeleteService action = new ReviewDeleteService();
			action.execute(req);
			resp.sendRedirect("purchaseList.item");
		} else if (command.equals("/reviewList.review")) {
			ReviewListService action = new ReviewListService();
			action.execute(req);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("review/reviewList1.jsp");
			dispatcher.forward(req, resp);	
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
