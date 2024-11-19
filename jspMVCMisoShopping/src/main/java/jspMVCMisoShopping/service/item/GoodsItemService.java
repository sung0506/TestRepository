package jspMVCMisoShopping.service.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dto.CartListDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class GoodsItemService extends MemberAuthService{

	public GoodsItemService(HttpServletRequest req) {
		super(req);
	}
	public void execute(HttpServletRequest req) {
		String goodsNums [] = req.getParameterValues("prodCk");
		List<CartListDTO> list = new ArrayList<CartListDTO>();
		ItemDAO dao = new ItemDAO();
		Integer goodsTotalPrice = 0;
		String nums = "";
		for(String goodsNum : goodsNums) {
			CartListDTO dto = dao.itemSelectOne(memberNum, goodsNum);
			list.add(dto);
			goodsTotalPrice += dto.getTotalPrice();
			nums += goodsNum + "-";
		}
		req.setAttribute("list", list);
		req.setAttribute("goodsTotalPrice", goodsTotalPrice);
		req.setAttribute("goodsNums", nums);
	}
	
}
