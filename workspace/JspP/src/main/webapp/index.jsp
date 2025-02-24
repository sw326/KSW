<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>JspP Context Index</title>
	<style>
		body{text-align: center}
		a{text-decoration:none}
	</style>
	</head>
	<body>
		<h2>JspP Context Index</h2>
		<br/>
		<a href="addr_mv/list.jsp">주소록(Model1)</a><br/>
		<a href="board_mv/list.jsp">게시판(Model1)</a><br/>
		<a href="address/addr.do">주소록(Model2)</a><br/>
		<a href="board/brd.do">게시판(Model2)</a><br/>
		<a href="file/file.do?m=form">파일 업로드 폼</a><br/>
		<a href="file/file.do?m=form_mt">멀티파일 업로드 폼</a><br/>
		<a href="file/file.do?m=list">파일 리스트</a>(회원 서비스)<br/>
		<a href="jquery/jq1.html">jq1</a><br/>
		<a href="jquery/jq2.html">jq2</a><br/>
		<a href="ajax/ajax.do">ajax</a><br/>
		<a href="ajax/ajax.do?m=auto_form">자동완성</a>(회원 서비스)<br/>
		<c:choose>
			<c:when test="${empty loginOkUser}">
				<a href="login/login.do?m=form">로그인</a>
			</c:when>
			<c:otherwise>
				<font style="color:green">${loginOkUser.name}</font>님 환영합니다 ^^
				<br/>
				<a href="login/login.do?m=logout">로그아웃</a>
			</c:otherwise>
		</c:choose>

		<br><br>
		<a href="M2Project/main.do">M2Project</a>
		
		
		<!-- <a id="auth" href="login/login.do?m=form">로그인</a><br/>
				
		<script>
			let loginOkUser = sessionStorage.getItem("loginOkUser");
			
			if(loginOkUser){
				document.getElementById("auth").textContent = "로그아웃";
				sessionStorage.removeItem("loggedIn");
		        document.getElementById("auth").href = "login/login.do?m=logout";
			}
		</script> -->
	</body>
</html>