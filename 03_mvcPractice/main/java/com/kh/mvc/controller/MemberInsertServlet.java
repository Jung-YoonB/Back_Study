package com.kh.mvc.controller;

import java.io.IOException;

import com.kh.mvc.model.MemberDAO;
import com.kh.mvc.model.MemberDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/insert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO dao = new MemberDAO();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// DAO 에게 데이터 추가 요청
		MemberDTO m = new MemberDTO(name, email, age);
		
		dao.insert(m);
		
		// 회원 목록 페이지로 재요청 => redirect
		response.sendRedirect(request.getContextPath()+"/member/list");
		
	}

}
