package com.kh.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest {
	/*
	 	* Delete (데이터 삭제) : 회원 삭제, 도서 삭제 등과 같이
	 	* 			기존에 저장 된 데이터 자체를 제거하는 기능
	 	* 	--> DML 중 DELETE 사용!
	 */
	
	public static void main(String[] args) {
		// 삭제할 ID 값을 입력 받아, 해당 데이터를 DB 에서 삭제
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 ID : ");
		int id = sc.nextInt();
		
		String sql = "DELETE FROM member WHERE id = ?";
		
		try (Connection conn = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD)) {
			PreparedStatement pr = conn.prepareStatement(sql);
			
			pr.setInt(1, id);
			
			int result = pr.executeUpdate();
			
			System.out.println("ID 값이 " + id + "인 " + result + "개 행이 삭제되었습니다. ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();
		
	}

}
