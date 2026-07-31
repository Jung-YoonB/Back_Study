package practice.method;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postTest")
public class PostTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값 안 깨지게 추출 전 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값 추출 (파라미터 얻어오기)
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// 추출 완료 표시
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("데이터 추출 완료<br>");
		
		// 추출 한 데이터 표시
		response.getWriter().printf("<h2>로그인 입력 값: [%s / %s]</h2>", userId, userPw);
	}

}
