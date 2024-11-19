package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.service.employee.EmployeeDeleteService;
import jspMVCMisoShopping.service.employee.EmployeeDetailService;
import jspMVCMisoShopping.service.employee.EmployeeModifyService;
import jspMVCMisoShopping.service.employee.EmployeePassService;
import jspMVCMisoShopping.service.member.MemberDetailService;
import jspMVCMisoShopping.service.member.MemberUpdateService;
import jspMVCMisoShopping.service.user.MemberDropService;
import jspMVCMisoShopping.service.user.MemberPassService;

public class MyPageFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberMyPage.my")) {
			System.out.println("memberMyPage.my");
			MemberDetailService action = new MemberDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/myPage/memberMyPage.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberUpdate.my")) {
			MemberDetailService action = new MemberDetailService();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/myPage/myModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberModify.my")) {
			MemberUpdateService action = new MemberUpdateService();
			int i = action.execute(request);
			if(i == 1) response.sendRedirect("memberMyPage.my");
			else {
				MemberDetailService action1 = new MemberDetailService();
				action1.execute(request);
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/myPage/myModify.jsp");
				dispatcher.forward(request, response);
			}
		} else if (command.equals("/userPwModify.my")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/myPage/myPwCon.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/memberPwModify.my")) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
			String path = null;
			if(request.getParameter("memberPw").equals(auth.getUserPw())) {
				path = "/myPage/myNewPw.jsp";
			} else {
				request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
				path = "/myPage/myPwCon.jsp";
			}
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		} else if (command.equals("/memberPwPro.my")) {
			MemberPassService action = new MemberPassService();
			int i = action.execute(request);
			if( i == 1) {
				response.sendRedirect("memberMyPage.my");
			} else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("mypage/myPwCon.jsp");
				dispatcher.forward(request, response);
			}
		} else if (command.equals("/memberDrop.my")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("mypage/myDrop.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/memberDropOk.my")) {
			MemberDropService action = new MemberDropService();
			int i = action.execute(request);
			if( i == 1) response.sendRedirect("Logout.login");
			else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("mypage/memberDrop.jsp");
				dispatcher.forward(request, response);
			}
			
		} else if(command.equals("/empMyPage.my")) {
			EmployeeDetailService action = new EmployeeDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/empMyPage/empMyPage.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/empUpdate.my")) {

			EmployeeDetailService action = new EmployeeDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/empMyPage/empModify.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/empModify.my")) {
			EmployeeModifyService action = new EmployeeModifyService();
			int i = action.execute(request);
			if(i == 1) response.sendRedirect("empMyPage.my");
			else {
				EmployeeDetailService action1 = new EmployeeDetailService();
				action1.execute(request);
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/empMyPage/empModify.jsp");
				dispatcher.forward(request, response);
			}
		} else if (command.equals("/empUserPwModify.my")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/empMyPage/empPwCon.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/empPwModify.my")) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
			String path = null;
			if(request.getParameter("empPw").equals(auth.getUserPw())) {
				path = "/empMyPage/empNewPw.jsp";
			} else {
				request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
				path = "/empMyPage/empPwCon.jsp";
			}
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/empPwPro.my")) {
			EmployeePassService action = new EmployeePassService();
			int i = action.execute(request);
			if( i == 1) {
				response.sendRedirect("empMyPage.my");
			} else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("empMypage/empPwCon.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
