package jspMVCMisoShopping.service.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberWriteService {
	public void execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		MemberDTO dto = new MemberDTO();
		dto.setGender(req.getParameter("gender"));
		dto.setMemberAddr(req.getParameter("memberAddr"));
		dto.setMemberAddrDetail(req.getParameter("memberAddrDetail"));
		dto.setMemberEmail(req.getParameter("memberEmail"));
		dto.setMemberId(req.getParameter("memberId"));
		dto.setMenerName(req.getParameter("memberName"));
		dto.setMemberNum(req.getParameter("memberNum"));
		dto.setMemberPhone1(req.getParameter("memberPhone1"));
		dto.setMemberPhone2(req.getParameter("memberPhone2"));
		dto.setMemberPost(req.getParameter("memberPost"));
		dto.setMemberPw(req.getParameter("memberPw"));
		
		String birth = req.getParameter("memberBirth"); // yyyy-mm-dd
		// 자바에서 문자열을 날짜로 형 변환
		Date date = null;
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-mm-dd");
		try {
			date = sdf.parse(birth);
		} catch(Exception e) {
			e.printStackTrace();
		}
		dto.setMemberBirth(date);
		
		MemberDAO dao = new MemberDAO();
		dao.memberInsert(dto);
	}
}
