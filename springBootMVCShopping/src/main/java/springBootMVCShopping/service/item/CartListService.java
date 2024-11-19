package springBootMVCShopping.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsCartDTO;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class CartListService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO memberDTO = memberMapper.memberSelectOne1(auth.getUserId());
		
		List<GoodsCartDTO> list = cartMapper.cartSelectList(memberDTO.getMemberNum(), null);
		model.addAttribute("list", list);
		Integer totPri = 0;
		Integer totQty = 0;
		for (GoodsCartDTO dto : list) {
            totPri = dto.getGoodsDTO().getGoodsPrice() * dto.getCartDTO().getCartQty(); // 상품 가격 가져오기
            totQty = dto.getCartDTO().getCartQty(); // 장바구니 수량 가져오기
        }
		
		model.addAttribute("totPri", totPri);
		model.addAttribute("totQty", totQty);
	}
}
