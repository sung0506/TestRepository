package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {
	String GoodsNum;
	String GoodsName;
	int GoodsPrice;
	String GoodsContent;
	int visitCount;
	String empNum;
	Date goodsRegist;
	String updateEmpNum;
	Date goodsUpdateDate;
	
	String goodsMainImage;
	String goodsMainStoreImage;
	
	String goodsDetailImage;
	String goodsDetailStoreImage;
}
