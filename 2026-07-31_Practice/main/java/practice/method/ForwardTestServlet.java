package practice.method;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forwardTest")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체에 데이터 저장
		request.setAttribute("msg", "ForwardTestServlet.java 에서 저장한 메시지 데이터");
		
		// * forward => 다른 자원(html, jsp)으로 응답 처리
		// result 페이지로 포워딩
		request.getRequestDispatcher("/forwardResult.jsp").forward(request, response);
	}

}
