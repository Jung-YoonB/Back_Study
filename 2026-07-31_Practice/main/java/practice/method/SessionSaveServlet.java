package practice.method;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessionSave")
public class SessionSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 가져와서 일단 값 저장
		String nickname = request.getParameter("nickname");
		String tel = request.getParameter("tel");
		
		// 세셩 생성
		HttpSession session = request.getSession();
		
		// 세션에 가져온 값 저장
		session.setAttribute("nickname", nickname);
		session.setAttribute("tel", tel);
		
		// 응답 출력
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h2>세션 정보 저장 완료</h2>");
	}

}
