package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.employee.EmployeeAutoNumService;
import jspMVCMisoShopping.service.goods.GoodsAutoNumService;
import jspMVCMisoShopping.service.goods.GoodsDeleteService;
import jspMVCMisoShopping.service.goods.GoodsDetailService;
import jspMVCMisoShopping.service.goods.GoodsListService;
import jspMVCMisoShopping.service.goods.GoodsRegistService;
import jspMVCMisoShopping.service.goods.GoodsUpdateService;

public class GoodsFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/goodsList.goods")) {
			GoodsListService action = new GoodsListService();
			action.execute(req);
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("goods/goodsList.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/goodsWrite.goods")) {
			GoodsAutoNumService action = new GoodsAutoNumService();
			action.execute(req);
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("goods/goodsForm.jsp");
			dispatcher.forward(req, resp);
		} else if(command.equals("/goodsRegist.goods")) {
			GoodsRegistService action = new GoodsRegistService();
			action.execute(req);
			resp.sendRedirect("goodsList.goods");
		} else if(command.equals("/goodsInfo.goods")) {
			GoodsDetailService action = new GoodsDetailService();
			action.execute(req);
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("goods/goodsInfo.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/goodsUpdate.goods")) {
			GoodsDetailService action = new GoodsDetailService();
			action.execute(req);
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("goods/goodsModify.jsp");
			dispatcher.forward(req, resp);
		} else if (command.equals("/goodsModify.goods")) {
			GoodsUpdateService action = new GoodsUpdateService();
			action.execute(req);
			resp.sendRedirect("goodsInfo.goods?goodsNum=" +
							req.getParameter("goodsNum"));
		} else if (command.equals("/goodsDelete.goods")) {
			GoodsDeleteService action = new GoodsDeleteService();
			action.execute(req);
			resp.sendRedirect("goodsList.goods");
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
