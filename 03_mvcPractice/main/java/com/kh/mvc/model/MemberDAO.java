package com.kh.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mvc.util.DBUtil;

/*
 * * Model - DAO *
 * 
 * Controller 에서 이 클래스의 메소드만 호출하고,
 * 내부에서 어떤 SQL문이 실행 되는지 알 필요가 없음! (관심사 분리) 
 */
public class MemberDAO {
	/*
	 * 등록 된 회원 목록 조회
	 */
	public List<MemberDTO> findAll() {
		// 조회 된 결과를 담을 리스트
		List<MemberDTO> list = new ArrayList<>();
		
		// 실행 할 쿼리문 (sql)
		//		-> 전체 회원 목록 조회 (id 내림차순 정렬)
		String sql = "SELECT * FROM member ORDER BY id DESC";
		
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// DQL (SELECT) -> executeQuery();
			// DML (INSERT / UPDATE / DELETE) -> executeUpdate(); : int
			ResultSet rset = pstmt.executeQuery();
			
			// 조회 결과 행의 개수 
			// 1개? 		--> PK, UQ 컬럼을 조건으로 제시했을 경우
			// 여러 개?	--> PK, UQ 컬럼이 아닌 조건을 제시했을 경우, 전체 조회 ...
			
			// * 조회 결과 유무 : rset.next() : boolean
			while(rset.next()) {
				
				// 조회 결과가 있으면, 각 컬럼의 값을 추출하여 MenberDTO 객체로 저장
				MemberDTO m = new MemberDTO(
						rset.getInt("id"),
						rset.getString("name"),
						rset.getString("email"),
						rset.getInt("age")
						);
				
				// list (조회 결과 리스트)에 추가
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/*
	 * 회원 등록 메소드 (데이터 추가)
	 */
	public void insert(MemberDTO m) {
		String sql = "INSERT INTO member VALUES (seq_member_id.nextval, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getEmail());
			pstmt.setInt(3, m.getAge());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) System.out.println(result + "행이 추가 됨");
			else System.out.println("추가 된 행이 없음");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
