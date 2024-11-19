package jspMVCMisoShopping.service.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.UserDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class UserLoginService {
	public int execute(HttpServletRequest req) {
		int i = 0;
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		UserDAO dao = new UserDAO();
		AuthInfoDTO auth = dao.loginSelect(userId);
		HttpSession session = req.getSession();
		
		if(auth != null) {
			System.out.println("아이디가 존재합니다.");
			System.out.println(auth.getUserPw());
			System.out.println(userPw);
			if(userPw.equals(auth.getUserPw())) {
				System.out.println("비밀번호가 같습니다.");
				session.setAttribute("auth", auth);
				i = 1;
			} else {
				System.out.println("비밀번호가 다릅니다.");
				req.setAttribute("errPw", "비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
			req.setAttribute("errId", "아이디가 존재하지 않습니다.");
		}
		return i;
	}
}
