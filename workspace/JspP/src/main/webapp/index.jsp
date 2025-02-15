<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<a href="file/file.do?m=list">파일 리스트</a><br/>
	</body>
</html>