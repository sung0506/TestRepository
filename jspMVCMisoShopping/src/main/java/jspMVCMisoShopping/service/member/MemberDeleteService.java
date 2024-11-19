package jspMVCMisoShopping.service.member;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.MemberDAO;

public class MemberDeleteService {
	public void execute(HttpServletRequest req) {
		
		String memberNum = req.getParameter("memberNum");
		
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(memberNum);
	}
}
