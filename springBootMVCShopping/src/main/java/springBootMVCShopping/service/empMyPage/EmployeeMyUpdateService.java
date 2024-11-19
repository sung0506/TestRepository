package springBootMVCShopping.service.empMyPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.mapper.EmployeeInfoMapper;

@Service
public class EmployeeMyUpdateService {
	@Autowired
	EmployeeInfoMapper employeeInfoMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(EmployeeCommand employeeCommand, HttpSession session) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpHireDate(employeeCommand.getEmpHireDate());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpJumin(employeeCommand.getEmpJumin());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpPost(employeeCommand.getEmpPost());
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String currentEmpPw = auth.getUserPw();
		if(passwordEncoder.matches(employeeCommand.getEmpPw(), currentEmpPw)) {
			employeeInfoMapper.employeeUpdate(dto);
		}
	}
}
