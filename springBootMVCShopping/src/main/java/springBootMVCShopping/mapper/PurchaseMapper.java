package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.PurchaseDTO;

@Mapper
public interface PurchaseMapper {
	public List<PurchaseDTO> purchaseList();
}
