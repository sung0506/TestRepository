package jspMVCMisoShopping.service.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsDetailService {
	public void execute(HttpServletRequest req) {
		String goodsNum = req.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.goodsSelectOne(goodsNum);
		req.setAttribute("dto", dto);
		
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(auth != null) {
			MemberDAO memDao = new MemberDAO();
			String memberNum = memDao.memberNumSelect(auth.getUserId());
			ItemDAO itemDao = new ItemDAO();
			int i = itemDao.wishSelectOne(memberNum, goodsNum);
			if( i == 1) req.setAttribute("isTrue", "있어요");
		}
	}
}
