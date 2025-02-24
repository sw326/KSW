<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="static login.mvc.model.LoginConst.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<script>
	/*let isLoggedIn = "${isLoggedIn}";
	if(isLoggedIn === "true"){
		sessionStorage.setItem("loggedIn", "true");
	}else{
		sessionStorage.setItem("loggedIn", "false");
	}*/


	if(${result} == <%=NO_ID%>){
		alert("그런 이메일의 회원이 없습니다.");
		location.href = "login.do?m=form";
	}else if (${result}==<%=NO_PWD%>){
		alert("비밀번호가 맞지 않아요.");
		location.href = "login.do?m=form";
	}else{
		alert("로그인 성공.");
		location.href = "../";
	}
</script>