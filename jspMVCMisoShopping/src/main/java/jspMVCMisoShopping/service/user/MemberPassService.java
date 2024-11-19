package jspMVCMisoShopping.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class MemberPassService {
	public int execute(HttpServletRequest req) {
		String oldPw = req.getParameter("oldPw");
		String newPw = req.getParameter("newPw");
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		int i = 0;
		if(auth.getUserPw().equals(oldPw)) {
			MemberDAO dao = new MemberDAO();
			dao.memberPwUpdate(newPw, auth.getUserId());
			auth.setUserPw(newPw);
			i = 1;
		} else {
		req.setAttribute("errPw", "비밀번호가 틀렸습니다.");	
		}
		return i ;
	}

}
