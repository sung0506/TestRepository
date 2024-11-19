package jspMVCMisoShopping.service.review;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ReviewDAO;
import jspMVCMisoShopping.model.dto.ReviewDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class ReviewWriteService extends MemberAuthService{
	public ReviewWriteService(HttpServletRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}

	public void execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String goodsNum = req.getParameter("goodsNum");
		String purchaseNum = req.getParameter("purchaseNum");
		String reviewContent = req.getParameter("reviewContent");
		String memberId = auth.getUserId();
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		dto.setReviewContent(reviewContent);
		dto.setMemberId(memberId);
		
		ReviewDAO dao = new ReviewDAO();
		dao.reviewInsert(dto);
	}
}
