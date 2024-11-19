package springBootMVCShopping.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.PurchaseDTO;
import springBootMVCShopping.mapper.PurchaseMapper;

@Service
public class PurchaseListService {
	@Autowired
	PurchaseMapper purchaseMapper;
	public void execute(Model model) {
		List<PurchaseDTO> list = purchaseMapper.purchaseList();
		model.addAttribute("list", list);
	}
}
