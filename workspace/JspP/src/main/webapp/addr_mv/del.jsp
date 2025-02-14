<%@ page contentType="text/html;charset=utf-8" %>
<jsp:useBean id="addrDAO" class="addr.mv.model.AddrDAO" scope="application"/>
<%
	String strSeq = request.getParameter("seq");
	long seq = Long.parseLong(strSeq);

	boolean flag = addrDAO.delete(seq);
	
	//response.sendRedirect("list.jsp");
%>
<script>
	if(<%=flag%>){
		alert("삭제성공(with DBCP)");
	}else{
		alert("삭제실패(with DBCP)");
	}
	location.href="list.jsp";
</script>