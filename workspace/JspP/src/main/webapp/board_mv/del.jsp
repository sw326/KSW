<%@ page contentType="text/html;charset=utf-8"%>
<jsp:useBean id="boardDAO" class="board.mv.model.BoardDAO" scope="application"/>

<%
	long seq = Long.parseLong(request.getParameter("seq"));
    boolean flag = boardDAO.delete(seq);
%>
<script>
	if(<%=flag%>){
	    alert("삭제성공(with JSP)");
	}else{
		alert("삭제실패(with JSP)");
	}
    location.href="list.jsp";
</script>

