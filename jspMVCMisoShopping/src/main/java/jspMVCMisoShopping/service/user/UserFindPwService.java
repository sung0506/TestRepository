package jspMVCMisoShopping.service.user;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.UserDAO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class UserFindPwService {
	public void execute(HttpServletRequest req) {
		String userId = req.getParameter("userId");
		String userPhone = req.getParameter("userPhone");
		
		UserDAO dao = new UserDAO();
		MemberDTO dto = dao.findPwSelect(userId, userPhone);
		req.setAttribute("dto", dto);	
	}
}
