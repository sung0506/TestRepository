package springBootMVCShopping.service.goodsIpgo;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.GoodsIpgoCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsIpgoDTO;
import springBootMVCShopping.mapper.EmployeeMapper;
import springBootMVCShopping.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoRegistService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(GoodsIpgoCommand goodsIpgoCommand, HttpSession session) {
		GoodsIpgoDTO dto = new GoodsIpgoDTO();
		/*
		dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());
		dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
		dto.setIpgoNum(goodsIpgoCommand.getIpgoNum());
		dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
		dto.setIpgoPrice(goodsIpgoCommand.getIpgoPrice());
		dto.setMadeDate(Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
		*/
		
		BeanUtils.copyProperties(goodsIpgoCommand, dto);
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String empNum = employeeMapper.getEmpNum(auth.getUserId());
        dto.setEmpNum(empNum);
		dto.setMadeDate(Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
		
		goodsIpgoMapper.goodsIpgoInsert(dto);
		}
}
