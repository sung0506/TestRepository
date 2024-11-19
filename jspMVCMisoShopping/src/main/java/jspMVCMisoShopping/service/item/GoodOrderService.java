package jspMVCMisoShopping.service.item;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dto.PurchaseDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class GoodOrderService extends MemberAuthService{
	public GoodOrderService(HttpServletRequest req) {
		super(req);
	}
	public String execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String purchaseName = req.getParameter("purchaseName");
		String totalPaymentPrice = req.getParameter("totalPaymentPrice");
		String deliveryName = req.getParameter("deliveryName");
		String deliveryAddr = req.getParameter("deliveryAddr");
		String deliveryAddrDetail = req.getParameter("deliveryAddrDetail");
		String deliveryPost = req.getParameter("deliveryPost");
		String deliveryPhone = req.getParameter("deliveryPhone");
		String message = req.getParameter("message");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String purchaseNum = sdf.format(new Date());
		
		PurchaseDTO dto = new PurchaseDTO();
		dto.setDeliveryAddr(deliveryAddr);
		dto.setDeliveryAddrDetail(deliveryAddrDetail);
		dto.setDeliveryPhone(deliveryPhone);
		dto.setDeliveryPost(deliveryPost);
		dto.setMessage(message);
		dto.setPurchasePrice(Long.parseLong(totalPaymentPrice));
		dto.setDeliveryName(deliveryName);
		dto.setMemberNum(memberNum);
		dto.setPurchaseName(purchaseName);
		dto.setPurchaseNum(purchaseNum);
		
		ItemDAO dao = new ItemDAO();
		dao.purchaseInsert(dto);
		String goodsNums[] = req.getParameter("goodsNums").split("-");
		for(String goodsNum : goodsNums) {
			dao.purchaseListInsert(purchaseNum, goodsNum, memberNum);
			dao.itemDelete(goodsNum, memberNum);
		}
		return purchaseNum;
	}
}
