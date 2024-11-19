package jspMVCMisoShopping.service.item;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;

public class PurchaseService {
	public void execute(HttpServletRequest req) {
		String purchaseNum = req.getParameter("purchaseNum");
		ItemDAO dao = new ItemDAO();
		dao.purchaseStatusUpdate(purchaseNum);
	}
}
