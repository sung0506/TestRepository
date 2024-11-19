package jspMVCMisoShopping.service.member;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.MemberDAO;

public class MemberAutoNumService {
	public void execute(HttpServletRequest req) {
		MemberDAO dao = new MemberDAO();
		String num = dao.memberAutoNum();
		req.setAttribute("memberNum", num);
	}
}
