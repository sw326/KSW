<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
    if(${flag}){
		alert("성공(with MVC) with JSTL+EL");
	}else{
		alert("실패(with MVC) with JSTL+EL");
	}
	location.href="brd.do";
</script>