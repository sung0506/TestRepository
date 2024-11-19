package jspMVCMisoShopping.service.user;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.UserDAO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class UserWriteService {
	public void execute(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(req.getParameter("userId"));
		dto.setMemberPw(req.getParameter("userPw"));
		dto.setMenerName(req.getParameter("userName"));
		dto.setMemberPhone1(req.getParameter("userPhone1"));
		dto.setMemberPhone2(req.getParameter("userPhone2"));
		dto.setMemberAddr(req.getParameter("userAddr"));
		dto.setMemberPost(req.getParameter("userPost"));
		dto.setMemberEmail(req.getParameter("userEmail"));
		
		String birth = req.getParameter("userBirth"); // yyyy-mm-dd
		// 자바에서 문자열을 날짜로 형 변환
		Date date = null;
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-mm-dd");
		try {
			date = sdf.parse(birth);
		} catch(Exception e) {
			e.printStackTrace();
		}
		dto.setMemberBirth(date);
		
		dto.setGender(req.getParameter("gender"));
		
		UserDAO dao = new UserDAO();
		dao.userInsert(dto);
		
		
	}
}
