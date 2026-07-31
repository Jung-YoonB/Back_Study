package practice.method;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirectTest")
public class RedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/practice/result");
		
		// 메소드 이용 => 권장 사항! (선행 패스 경로가 바뀌어도 동작 할 수 있도록)
//		response.sendRedirect((request.getContextPath() + "/result"));
	}


}
