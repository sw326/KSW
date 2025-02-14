<%@ page contentType="text/html;charset=utf-8" import="java.sql.*, javax.sql.DataSource"%>
<jsp:useBean id="boardDAO" class="board.mv.model.BoardDAO" scope="application"/>
<jsp:useBean id="dto" class="board.mv.model.BoardDTO"/>

<jsp:setProperty name="dto" property="*"/>

<%
    boolean flag = boardDAO.insert(dto);
%>
<script>
	if(<%=flag%>){
    	alert("입력성공(with JSP)");
	}else{
		alert("입력실패(with JSP)");
	}
    location.href="list.jsp";
</script>

