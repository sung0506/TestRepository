package jspMVCMisoShopping.service.user;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.UserDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class IdCheckService {
	public void execute(HttpServletRequest req) {
		String userId = req.getParameter("userId");
		UserDAO dao = new UserDAO();
		AuthInfoDTO dto = dao.loginSelect(userId);
		req.setAttribute("auth", dto);
		req.setAttribute("userId", userId);
	}
}
