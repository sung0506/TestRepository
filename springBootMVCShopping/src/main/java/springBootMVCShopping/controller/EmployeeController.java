package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.employee.EmployeeDeleteService;
import springBootMVCShopping.service.employee.EmployeeDetailService;
import springBootMVCShopping.service.employee.EmployeeListService;
import springBootMVCShopping.service.employee.EmployeeUpdateService;
import springBootMVCShopping.service.employee.EmployeeWriteService;
import springBootMVCShopping.service.employee.EmployeesDeleteService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeWriteService employeeWriteService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmployeesDeleteService employeesDeleteService;
	@Autowired
	AutoNumService autoNumService;
	@GetMapping("employeeList")
	public String list(
			@RequestParam(value = "page", required=false, defaultValue = "1") Integer page
			,@RequestParam(value="searchWord", required=false) String searchWord
			,Model model) {
		employeeListService.execute(searchWord, page, model);
		return "thymeleaf/employee/employeeList";
	}
	@GetMapping("employeeWrite") 
	public String write(Model model, String autoNum) {
		autoNum = autoNumService.execute("emp_", "emp_num", 5, "employees");
		EmployeeCommand employeeCommand = new EmployeeCommand();
		employeeCommand.setEmpNum(autoNum);
		model.addAttribute("employeeCommand", employeeCommand);
		return "thymeleaf/employee/employeeForm";
	}
	@PostMapping("employeeWrite")
	public String write(@Validated EmployeeCommand employeeCommand
			,BindingResult result
			,Model model) {
		if(result.hasErrors()) {
			System.out.println("employeeWrite");
			return "thymeleaf/employee/employeeForm";
		}
		if(!employeeCommand.isEmpPwEqualEmpPwCon()) {
			System.out.println("adadsa");
			result.rejectValue("empPwCon", "employeeCommand.empPwCon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/employee/employeeForm";
		}
		employeeWriteService.execute(employeeCommand);
		return "redirect:employeeList";
	}
	@GetMapping("employeeDetail")
	public String detail(Model model, String empNum) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/employeeDetail";
	}
	@GetMapping("employeeUpdate")
	public String update(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/employeeUpdate";
	}
	@PostMapping("employeeUpdate") 
	public String update(EmployeeCommand employeeCommand, Model model) {
		employeeUpdateService.execute(employeeCommand, model);
		return "redirect:employeeDetail?empNum=" + employeeCommand.getEmpNum();
	}
	@GetMapping("employeeDelete")
	public String delete(String empNum) {
		employeeDeleteService.execute(empNum);
		return "redirect:employeeList";
	}
	@RequestMapping(value = "employeesDelete")
	public String employeesDelete(@RequestParam("nums") String empNums []) {
		employeesDeleteService.execute(empNums);
		return "redirect:employeeList";
	}
}
