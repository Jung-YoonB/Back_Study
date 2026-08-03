<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.kh.model.MemberDTO" %>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%-- 
	* EL (Expression Language)
		: request.getAttribute(...) 와 같은 자바 코드를
		  ${표현식} 과 같은 간결한 문장으로 대체해 줌
--%>
<%
	request.setAttribute("name", "홍길동");
	request.setAttribute("age", 20);
	
	MemberDTO m = new MemberDTO("홍길동", 20);
	request.setAttribute("member", m);
	
	List<String> list = new ArrayList<>();
	list.add("test");
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 문법</title>
</head>
<body>
	<h1>EL 문법</h1>
	
	<h3>기존 JSP 문법 vs EL 문법</h3>
	<p>
		표현식 &lt;%=request.getAttribute("name") %&gt; (name) : <%= request.getAttribute("name") %>
	</p>
	<p>
		EL \${ name } (name) : ${ name }
	</p>
	
	<h3>EL 탐색 범위</h3>
	<h4>
		pageScope -> requestScope -> sessionScope -> applicationScope
	</h4>
	<p>
		${ name } : 범위 지정 없이 특정 값을 검색 시, 순차적으로 찾아서 출력
	</p>
	<p>
		${ sessionScope.name } : 특정 스코프를 명시적으로 지정, 해당 스코프에서만 찾아서 출력
	</p>
	
	<h3>객체에서 필드 값에 접근 (getter)</h3>
	<%-- 
		${변수명.필드명} 작성 시 해당 객체의 get필드명() 처럼 getter를 내부적으로 호출 함
		즉, 필드가 private 이어도 EL로 접근 가능
	--%>
	<p>이름 : ${ member.name }</p>
	<p>나이 : ${ member.age }</p>
	
	<h3>EL 연산자</h3>
	<p>산술 연산 : 1 + 2 = ${ 1 + 2 }</p>
	<p>
		비교연산 : 삼항 연산자 -> 조건식 ? 참일 때 값 : 거짓일 때 값 
		<br>
		=> ${ age >= 20 ? "성인" : "미성년자" }
	</p>
	<p>
		empty 연산 (리스트에 값이 비어있는지 확인) : ${ empty list }
		<%-- 
			해당 리스트가 비어있거나 null 인 경우 true 반환
			리스트에 값이 한개 이상 있으면 false 반환
		 --%>
	</p> 
	
	<a href="/jsp">첫 페이지로 이동...</a>
</body>
</html>