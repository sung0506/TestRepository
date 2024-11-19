package jspMVCMisoShopping.service.goods;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsRegistService{
	public void execute(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int fileSize = 1024 * 1024 * 100;
		String realPath = req.getServletContext().getRealPath("/goods/upload");
		System.out.println(realPath);
		try {
			MultipartRequest multi = new MultipartRequest(
					req, realPath, fileSize, "utf-8", 
					new DefaultFileRenamePolicy());
		
		
			String goodsNum = multi.getParameter("goodsNum");
			String goodsName = multi.getParameter("goodsName");
			String goodsPrice = multi.getParameter("goodsPrice");
			String goodsContent = multi.getParameter("goodsContent");
		
			String storeMainImage = multi.getFilesystemName("mainImage");
			String mainImage = multi.getOriginalFileName("mainImage");
			
			String storeImage1 = multi.getFilesystemName("iamge1");
			String image1 = multi.getOriginalFileName("iamge1");
			String storeImage2 = multi.getFilesystemName("image2");
			String image2 = multi.getOriginalFileName("image2");
			String storeImage3 = multi.getFilesystemName("image3");
			String image3 = multi.getOriginalFileName("image3");
			
			String goodsDetailStoreImage = storeImage1 + "`" + storeImage2 + "`" + storeImage3;
			String goodsDetailImage = image1 + "`" + image2 + "`" + image3;
			
			GoodsDTO dto = new GoodsDTO();
			dto.setGoodsNum(goodsNum);
			dto.setGoodsName(goodsName);
			dto.setGoodsPrice(Integer.parseInt(goodsPrice));
			dto.setGoodsContent(goodsContent);
		
			HttpSession session = req.getSession();
			AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
			EmployeeDAO empDao = new EmployeeDAO();
			//String empId = auth.getUserId();
			String empNum = empDao.empNumSelect(auth.getUserId());
			dto.setEmpNum(empNum);
			
			dto.setGoodsMainImage(mainImage);
			dto.setGoodsMainStoreImage(storeMainImage);
			dto.setGoodsDetailImage(goodsDetailImage);
			dto.setGoodsDetailStoreImage(goodsDetailStoreImage);
			
			GoodsDAO dao = new GoodsDAO();
			dao.goodsInsert(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
