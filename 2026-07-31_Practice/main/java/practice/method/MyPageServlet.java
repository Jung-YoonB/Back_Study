package practice.method;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/myPage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세셩 생성
		HttpSession session = request.getSession();
		
		// 세션에서 값 조회하여 저장
		String nickname = (String)session.getAttribute("nickname");
		String tel = (String)session.getAttribute("tel");
		
		// 결과 출력
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().printf("<h2>마이페이지 - 닉네임: [%s], 연락처: [%s]</h2>", nickname, tel);
	}

}
