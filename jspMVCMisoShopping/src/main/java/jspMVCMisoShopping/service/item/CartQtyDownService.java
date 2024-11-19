package jspMVCMisoShopping.service.item;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.service.MemberAuthService;

public class CartQtyDownService extends MemberAuthService{

	public CartQtyDownService(HttpServletRequest req) {
		super(req);
	}
	public void execute(HttpServletRequest req) {
		String goodsNum = req.getParameter("goodsNum");
		ItemDAO dao = new ItemDAO();
		dao.itemQtyDownUpdate(goodsNum, memberNum);
	}
}
