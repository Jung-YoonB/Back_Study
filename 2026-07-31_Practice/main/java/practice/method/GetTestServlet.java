package practice.method;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getTest")
public class GetTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값 안 깨지게 추출 전 인코딩
		// POST 에서는 body 를 어떻게 읽을 지 알려줘야 해서 필수, get은 작동 X
		// 오히려 get 의 값이 추출 시 오류를 일으켜 null 로 반환 될 수 있음
//		request.setCharacterEncoding("UTF-8");
		
		// 데이터 추출 (파라미터 얻어오기)
		String keyword = request.getParameter("keyword");
		
		// 추출 완료 표시
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("데이터 추출 완료<br>");
		
		// 추출 한 데이터 표시
		response.getWriter().printf("<h2>검색 결과: [%s]</h2>", keyword);
	
	}


}
