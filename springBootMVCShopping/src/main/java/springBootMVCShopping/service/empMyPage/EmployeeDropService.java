package springBootMVCShopping.service.empMyPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.EmployeeInfoMapper;

@Service
public class EmployeeDropService {
	@Autowired
	EmployeeInfoMapper employeeInfoMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(HttpSession session, String empPw) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(passwordEncoder.matches(empPw, auth.getUserPw())) {
			employeeInfoMapper.employeeDelte(auth.getUserId());
		}
	}
}
