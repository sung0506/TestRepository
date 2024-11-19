package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.Data;
@Data
public class PurchaseDTO {
	String purchaseNum;
	Date purchaseDate;
	Long purchasePrice;
	String purchaseName;
	String deliveryAddr;
	String deliveryAddrDetail;
	String deliveryPost;
	String deliveryPhone;
	String deliveryName;
	String message;
	String purchaseStatus;
	String memberNum;
}
