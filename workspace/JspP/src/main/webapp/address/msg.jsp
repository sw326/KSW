<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
    if(${flag}){
		alert("입력성공(with MVC) with JSTL+EL");
	}else{
		alert("입력실패(with MVC) with JSTL+EL");
	}
	location.href="addr.do";
</script>