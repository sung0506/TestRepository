package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CartDTO {
	String memberNum;
	String goodsNum;
	Date carDate;
	Integer cartQty; // null 값을 받아올 경우가 있을 때
}
