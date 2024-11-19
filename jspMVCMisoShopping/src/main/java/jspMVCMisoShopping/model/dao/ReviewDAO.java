package jspMVCMisoShopping.model.dao;

import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.ReviewDTO;

public class ReviewDAO extends DataBaseInfo{
	
	public void reviewSelectOne(ReviewDTO dto) {
		con = getConnection();
		sql = " select review_contents from reviews "
			+ " where purchase_num = ? and goods_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getGoodsNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setReviewContent(rs.getString("review_contents"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	public void reviewInsert(ReviewDTO dto) {
		con = getConnection();
		System.out.println(dto.getPurchaseNum());
		System.out.println(dto.getGoodsNum());
		sql = " merge into reviews r "
			+ " using (select purchase_num, goods_num from purchase_list "
			+ " where purchase_num = ? and goods_num = ? ) p "
			+ " on (r.purchase_num = p.purchase_num and r.goods_num = p.goods_num) "
			+ " when matched then "
			+ "	update set review_contents = ? "
			+ " when not matched then "
			+ " insert (review_num, goods_num, purchase_num, review_date, review_contents, member_id ) "
			+ " values (review_seq.nextval, p.goods_num, p.purchase_num, sysdate, ?, ?) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getGoodsNum());
			pstmt.setString(3, dto.getReviewContent());
			pstmt.setString(4, dto.getReviewContent());
			pstmt.setString(5, dto.getMemberId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 병합되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void reviewDelete(String reviewNum) {
		con = getConnection();
		sql = " delete from reviews where review_num = ?";
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, reviewNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch(Exception e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		
	}
	
	public List<ReviewDTO> reviewSelectAll(String goodsNum) {
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		con = getConnection();
		sql = " select review_num, review_contents, review_date, member_id"
			+ " from reviews"
			+ " where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setReviewNum(rs.getInt("review_num"));
				dto.setReviewContent(rs.getString("review_contents"));
				dto.setMemberId(rs.getString("member_id"));
				dto.setReviewDate(rs.getDate("review_date"));
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
