<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script language="javascript">
       function f_login()
       {
           baby_login = window.open(
           "${pageContext.request.contextPath}/M2Project/login.do", "login_name", 
                "width=400, height=200, top=100, left=100");
       }
    </script>
</head>
<body>
	<center>
		<strong>Eclipse Project01</strong>
		<br><br>
		 <a href="rb-list.do?method=list">답변형 게시판</a>
		 <br><br>
		 <br>
<c:choose>
	<c:when test="${empty sessionScope.loggedIn}">
		<% System.out.println("No session found"); %>
		<a href="javascript:f_login()">로그인</a><br>
	</c:when>
	<c:otherwise>
		<% System.out.println("Session exists: " + session.getAttribute("loggedIn")); %>
		<a href="${pageContext.request.contextPath}/M2Project/logout.do">로그아웃</a> 
		<br><br>
		<font color="blue">${sessionScope.loggedIn.id}</font>님 어솨~!
	</c:otherwise>
</c:choose>

       <br><br>
	</center>
	
</body>
</html>