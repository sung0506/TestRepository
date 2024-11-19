package jspMVCMisoShopping.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class UserDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public UserDAO() {
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	}
	public Connection getConnection() {
		Connection co = null;
		try {
			Class.forName(jdbcDriver);
			co = DriverManager.getConnection(jdbcURL, "miso", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return co;
	}
	public MemberDTO findPwSelect(String userId, String userPhone) {
		System.out.println(userId);
		System.out.println(userPhone);
		MemberDTO dto = null;	
		con = getConnection();
		sql = "select member_pw from members where member_id = ? and member_Phone1 = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPhone);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMemberPw(rs.getString("member_pw"));
			}
		} catch (Exception e) {
				e.printStackTrace();	
		} finally {
				close();
		}
		return dto;
	}
	public MemberDTO findIdSelect(String userName, String userEmail) {
		MemberDTO dto = null;
		con = getConnection();
		sql = "select member_id from members where mener_name = ? and member_email = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMemberId(rs.getString("member_id"));
			}
		} catch (Exception e) {
				e.printStackTrace();	
		} finally {
				close();
		}
		return dto;
	}
	
	public AuthInfoDTO loginSelect(String userId) {
		AuthInfoDTO dto = null;
		con = getConnection();
		sql = "select member_id user_id, member_pw user_pw, mener_name user_name, member_email user_email, 'mem' grade" 
			+ " from members "
			+ " where member_id = ? "
			+ " union "
			+ " select emp_id, emp_pw, emp_name, emp_email , 'emp' "
			+ " from employees "
			+ " where emp_id = ?";
		try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, userId);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = new AuthInfoDTO();
					dto.setUserId(rs.getString("user_id"));
					dto.setUserPw(rs.getString("user_pw"));
					dto.setUserName(rs.getString("user_name"));
					dto.setUserEmail(rs.getString("user_email"));
					dto.setGrade(rs.getString("grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public void userInsert(MemberDTO dto) {
		con = getConnection();
		String userNum = " select concat('mem_',nvl(substr(max(member_num),5),100000) + 1) from members";
		sql = "insert into members(MEMBER_NUM, MENER_NAME, MEMBER_ID, MEMBER_PW, MEMBER_ADDR, MEMBER_BIRTH"
				+ "					 , MEMBER_POST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2, MEMBER_EMAIL) "
				+ " values((" + userNum + "),?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMenerName());
			pstmt.setString(2, dto.getMemberId());
			pstmt.setString(3, dto.getMemberPw());
			pstmt.setString(4, dto.getMemberAddr());
			pstmt.setDate(5, new Date(dto.getMemberBirth().getTime()));
			pstmt.setString(6, dto.getMemberPost());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getMemberPhone1());
			pstmt.setString(9, dto.getMemberPhone2());
			pstmt.setString(10, dto.getMemberEmail());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개(행)이가 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	
	
	public void close() {
		if(rs != null) try { rs.close(); } catch (Exception e) {}
		if(con != null) try { con.close(); } catch (Exception e) {}
		if(pstmt != null) try { pstmt.close(); } catch (Exception e) {}
	}
	
}
