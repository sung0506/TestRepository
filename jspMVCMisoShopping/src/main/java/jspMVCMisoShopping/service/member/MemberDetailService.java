package jspMVCMisoShopping.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberDetailService {
	public void execute(HttpServletRequest req) {
		String memberNum = req.getParameter("memberNum");
		MemberDAO dao = new MemberDAO();
		if(memberNum == null) {
			HttpSession session = req.getSession();
			AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
			String memberId = auth.getUserId();
			memberNum = dao.memberNumSelect(memberId);
		}
		
		MemberDTO dto = dao.memberSelectOne(memberNum);
		req.setAttribute("dto", dto);
	}
}
