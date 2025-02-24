<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
    if(${flag}){
		alert("성공(with MVC)");
	}else{
		alert("실패(with MVC)");
	}
	location.href="brd.do";
</script>