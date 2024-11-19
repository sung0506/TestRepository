package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("memberDTO")
@Data
public class MemberDTO {
	
	String memberNum;
	String memberId;
	String memberName;
	String memberPw;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	Date memberRegist;
	Date memberBirth;
	String gender;
	String MemberEmail;
	String memberPhone1;
	String memberPhone2;
	
	String memberEmailConf;
}
