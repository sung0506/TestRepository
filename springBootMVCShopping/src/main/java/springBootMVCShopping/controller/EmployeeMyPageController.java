package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.service.empMyPage.EmployeeDropService;
import springBootMVCShopping.service.empMyPage.EmployeeMyInfoService;
import springBootMVCShopping.service.empMyPage.EmployeeMyUpdateService;
import springBootMVCShopping.service.empMyPage.EmployeePwUpdateService;

@Controller
@RequestMapping("empMyPage")
public class EmployeeMyPageController {
	@Autowired
	EmployeeMyInfoService employeeMyInfoService;
	@Autowired
	EmployeeMyUpdateService employeeMyUpdateService;
	@Autowired
	EmployeePwUpdateService employeePwUpdateService;
	@Autowired
	EmployeeDropService employeeDropService;
	@RequestMapping("empMyPage")
	public String empMyPage(HttpSession session, Model model) {
		employeeMyInfoService.execute(session, model);
		return "thymeleaf/empMyPage/empMyPage";
	}
	@GetMapping("empUpdate")
	public String empUpdate(HttpSession session, Model model) {
		employeeMyInfoService.execute(session, model);
		return "thymeleaf/empMyPage/empMyModify";
	}
	@PostMapping("empModify")
	public String empModify(EmployeeCommand employeeCommand, HttpSession session) {
		employeeMyUpdateService.execute(employeeCommand, session);
		return "redirect:empMyPage";
	}
	@RequestMapping(value ="empPwModify", method = RequestMethod.GET)
	public String employeePwModify() {
		return "thymeleaf/empMyPage/empMyNewPw";
	}
	@RequestMapping(value ="empPwPro", method = RequestMethod.POST)
	public String empNewPw(
			String oldPw, String newPw, HttpSession session) {
		employeePwUpdateService.execute(oldPw, newPw, session);
		return "redirect:empMyPage";
	}
	@GetMapping("empDrop")
	public String empDrop() {
		return "thymeleaf/empMyPage/empDrop";
	}
	@PostMapping("empDropOk")
	public String empDropOk(HttpSession session, String empPw) {
		employeeDropService.execute(session, empPw);
		return "redirect:/login/logout";
	}
}
