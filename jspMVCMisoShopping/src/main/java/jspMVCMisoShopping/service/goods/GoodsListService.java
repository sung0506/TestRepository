package jspMVCMisoShopping.service.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsListService {
	public void execute(HttpServletRequest req) {
		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> list = dao.goodsSelectAll();
		req.setAttribute("list", list);
	}
}
