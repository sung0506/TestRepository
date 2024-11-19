package jspMVCMisoShopping.model.dto;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	String memberNum;
	String memberId;
	String memberPw;
	String menerName;	
	String memberPhone1;
	String memberPhone2;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	String gender;
	String memberEmail;
	Date memberBirth;
	
	Date memberRegist;
}
