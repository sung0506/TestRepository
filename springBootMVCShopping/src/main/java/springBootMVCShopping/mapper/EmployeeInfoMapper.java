package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.EmployeeDTO;

@Mapper
public interface EmployeeInfoMapper {
	public EmployeeDTO employeeSelectOne(String empId);
	public Integer employeeUpdate(EmployeeDTO dto);
	public Integer employeePwUpdate(
			@Param("newPw") String newPw
			,@Param("empId") String empId);
	public void employeeDelte(String empId);
	
}
