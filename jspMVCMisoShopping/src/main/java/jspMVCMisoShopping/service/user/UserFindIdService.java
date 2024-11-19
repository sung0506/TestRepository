package jspMVCMisoShopping.service.user;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.UserDAO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class UserFindIdService {
	public void execute(HttpServletRequest req) {
		String userEmail = req.getParameter("userEmail");
		String userName = req.getParameter("userName");
		
		//MemberDTO dto = new MemberDTO();
		//dto.setMenerName(userName);
		//dto.setMemberEmail(userEmail);
		
		UserDAO dao = new UserDAO();
		//dao.findIdSelect(dto);
		MemberDTO dto = dao.findIdSelect(userName, userEmail);
		req.setAttribute("dto", dto);
	}
}
