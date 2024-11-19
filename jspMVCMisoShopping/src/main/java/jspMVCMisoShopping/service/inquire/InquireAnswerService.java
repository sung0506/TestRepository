package jspMVCMisoShopping.service.inquire;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.InquireDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.InquireDTO;

public class InquireAnswerService {
	public void execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String inquireNum = req.getParameter("inquireNum");
		String inquireAnswer = req.getParameter("inquireAnswer");
		
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		EmployeeDAO empDao = new EmployeeDAO();
		String empNum = empDao.empNumSelect(auth.getUserId());
		
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(Long.parseLong(inquireNum));
		dto.setInquireAnswer(inquireAnswer);
		dto.setEmpNum(empNum);
		
		InquireDAO dao = new InquireDAO();
		dao.inquireReplyUpdate(dto);
	}
}
