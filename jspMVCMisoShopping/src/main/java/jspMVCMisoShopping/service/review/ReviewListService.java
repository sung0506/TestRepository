package jspMVCMisoShopping.service.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ReviewDAO;
import jspMVCMisoShopping.model.dto.ReviewDTO;

public class ReviewListService {
	public void execute(HttpServletRequest req) {
		String goodsNum = req.getParameter("goodsNum");
		ReviewDAO dao = new ReviewDAO();
		List<ReviewDTO> list = dao.reviewSelectAll(goodsNum);
		req.setAttribute("list", list);
		req.setAttribute("newLine", "\n");
	}
}
