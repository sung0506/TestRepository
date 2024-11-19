package jspMVCMisoShopping.service.goods;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsUpdateService {
	public void execute(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeDAO dao = new EmployeeDAO();
		String goodsNum = req.getParameter("goodsNum");
		int goodsPrice = Integer.parseInt(req.getParameter("goodsPrice"));
		String goodsName = req.getParameter("goodsName");
		String goodsContent = req.getParameter("goodsContent");
		
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String empId = auth.getUserId();
		String empNum = dao.empNumSelect(empId);
		
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsNum);
		dto.setEmpNum(empNum);
		dto.setGoodsContent(goodsContent);
		dto.setGoodsName(goodsName);
		dto.setGoodsPrice(goodsPrice);
		
		GoodsDAO dao1 = new GoodsDAO();
		dao1.goodsUpdate(dto);
		
	}
}
