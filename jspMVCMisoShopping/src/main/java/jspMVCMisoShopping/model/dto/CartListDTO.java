package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.Data;
@Data
public class CartListDTO {
	String memberNum;
	String goodsNum;
	Integer cartQty;
	Date cartDate;
	
	String goodsName;
	int goodsPrice;
	String goodsImage;
	int totalPrice;
}
