package springBootMVCShopping.command;

import lombok.Data;

@Data
public class PurchaseCommand {
	String goodsNums;
	Integer totalPaymentPrice;
	String purchaseName;
	String deliveryName;
	String deliveryAddr;
	String deliveryAddrDetail;
	Integer deliveryPost;
	String deliveryPhone;
	String message;
}
