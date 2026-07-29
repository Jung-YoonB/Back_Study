package com.kh.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTest {
	/*
	 	* Read (데이터 조회) => 회원 정보 조회, 검색 등과 같이 저장 된 데이터를 조회하는 기능
	 	* 	--> SQL (DQL) SELECT 사용!
	 */
	
	public static void main(String[] args) {
		// * member 테이블 전체 조회
		String sql = "SELECT * FROM member";
		
		try (Connection conn = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD)) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rest = pstmt.executeQuery();
			
			System.out.println("| id | name | email | age |");			
			while (rest.next()) {
				/*
			 		* rest.getxxxx(컬럼명 또는 컬럼 순번)
			 		* 현재 커서가 위치한 행에서 지정한 컬럼에 해당하는 값을
			 		* 메소드 타입에 따라 테이터 타입으로 가져옴
			 		* 단, 컬럼명을 잘 못 작성했을 경우 SQLException 예외가 발생 됨! 
			 	*/	
				int id = rest.getInt("id");
				String name = rest.getString("name");
				String email = rest.getString("email");
				int age = rest.getInt("age");
				
				System.out.printf("| %d | %s | %s | %d |\n", 
						id, name, email, age);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
