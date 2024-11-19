package jspMVCMisoShopping.service.item;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.GoodsDAO;

public class GoodsVisitCountService {
	public void execute(HttpServletRequest req) {
	String goodsNum = req.getParameter("goodsNum");
	GoodsDAO dao = new GoodsDAO();
	dao.visitCount(goodsNum);	
	}
}
