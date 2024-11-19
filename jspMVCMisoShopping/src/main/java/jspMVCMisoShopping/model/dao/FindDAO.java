package jspMVCMisoShopping.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FindDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public FindDAO() {
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
	
	public String userSearch(String userId, String userPhone) {
		String i = null;
		con = getConnection();
		sql = "select 'mem' from members "
			+ " where member_id = ? and "
			+ " (member_phone1 = ? or member_phone2 = ?)"
			+ " union"
			+ " select 'emp' from employees "
			+ " where emp_id = ? and emp_phone = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPhone);
			pstmt.setString(3, userPhone);
			pstmt.setString(4, userId);
			pstmt.setString(5, userPhone);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = rs.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return i;
	}
	
	public void userPwUpdate(String userId, String newPw, String grade) {
		con = getConnection();
		switch(grade) {
		case "mem" : sql = " update members "
						 + " set member_pw = ?"
						 + " where member_id = ?";
					break;
		case "emp" : sql = " update employees "
						 + " set emp_pw = ?"
						 + " where emp_id = ?";
					break;
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			int i = pstmt.executeUpdate();
			System.out.println("비밀번호가 변경되었습니다.");
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
