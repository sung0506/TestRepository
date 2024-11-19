package jspMVCMisoShopping.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class MemberAuthService {
	public HttpSession session;
	public AuthInfoDTO auth;
	public MemberDAO memDao;
	public String memberNum;
	public MemberAuthService(HttpServletRequest req) {
		session = req.getSession();
		auth = (AuthInfoDTO)session.getAttribute("auth");
		memDao = new MemberDAO();
		try {
			memberNum = memDao.memberNumSelect(auth.getUserId());
		} catch(Exception e) {
			
		}
	}
}
