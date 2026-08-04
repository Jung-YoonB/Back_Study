<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.kh.mvc.model.MemberDTO" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원 목록 </h1>
	
	<a href="/mvc/member/insert.html">회원 등록</a>
	
	<table border="1">
	<thead>
		<tr>
			<th>회원 번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
		</tr>
	</thead>
	<tbody>
		<%-- 조회 결과는 request 영역에 memberList 이름으로 저장되어 있음! --%>
		<% 
			List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("memberList");
			for(MemberDTO m : list) {
		%>
		<tr>
		<td><%= m.getId() %></td>
		<td><%= m.getName() %></td>
		<td><%= m.getEmail() %></td>
		<td><%= m.getAge() %></td>
		</tr>
		<%	
			}
		%>
	</tbody>
	</table>
	
	<%-- #260803 JSTL 적용  --%>
	<h2>#260803 JSTL 적용 해보기</h2>
	<br>
	<table border="1">
	<thead>
		<tr>
			<th>회원 번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
		</tr>
	</thead>
	<tbody>
		<%-- 
			<c:set var="memberList" value="<%= list %>" scope="request" /> 
			-> MemberListServlet 에서 이미 memberList를 정의해서 저장하고 있으므로 
				다시 request 영역에 저장 할 필요 없음!
		--%>
		<c:forEach var="m" items="${ memberList }">
			<%-- 이미 MemberListServlet에서 저장한 memberList 를 불러오기 --%>
			<tr>
				<td>${ m.id }</td>
				<td>${ m.name }</td>
				<td>${ m.email }</td>
				<td>${ m.age }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>
