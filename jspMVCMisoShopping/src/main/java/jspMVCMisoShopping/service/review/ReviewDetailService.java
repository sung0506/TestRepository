package jspMVCMisoShopping.service.review;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ReviewDAO;
import jspMVCMisoShopping.model.dto.ReviewDTO;

public class ReviewDetailService {
	public void execute(HttpServletRequest req) {
		String purchaseNum = req.getParameter("purchaseNum");
		String goodsNum = req.getParameter("goodsNum");
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		
		dao.reviewSelectOne(dto);
		req.setAttribute("dto", dto);
	}
}
