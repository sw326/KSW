<%@ page contentType="text/html;charset=utf-8" 
import="board.mv.model.BoardDTO, board.mv.model.BoardDAO"%>
<jsp:useBean id="boardDAO" class="board.mv.model.BoardDAO" scope="application"/>

<meta charset='utf-8'>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
  th,
  td {
    padding: 5px;
  }
  a {
    text-decoration: none;
  }
</style>
<center>
  <hr width="600" size="2" noshade />
  <h2>Simple Board with Model1</h2>
  &nbsp;&nbsp;&nbsp;
  <a href="list.jsp">글목록</a>
  <hr width="600" size="2" noshade />
  
<%
	long seq = Long.parseLong(request.getParameter("seq"));
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.getBoard(seq);
%>
  
  <form name="f" method="post" action="update.jsp">
    <input type="hidden" name="seq" value="<%=dto.getSeq()%>" />
    <input type="hidden" name="writer" value="<%=dto.getWriter()%>" />
    <table border="1" width="600" align="center" cellpadding="3" cellspacing="1">
      <tr>
        <td width="30%" align="center">글쓴이</td>
        <td align="center"><input type="text" name="aa" size="60" value="<%=dto.getWriter()%>" disabled></td>
      </tr>
      <tr>
        <td width="30%" align="center">이메일</td>
        <td align="center"><input type="text" name="email" size="60" value="<%=dto.getEmail()%>"></td>
      </tr>
      <tr>
        <td width="30%" align="center">글제목</td>
        <td align="center"><input type="text" name="subject" size="60" value="<%=dto.getSubject()%>"></td>
      </tr>
      <tr>
        <td width="30%" align="center">글내용</td>
        <td align="center"><textarea name="content" rows="5" cols="53"><%=dto.getContent()%></textarea></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="수정">
        </td>
      </tr>
    </table>
  </form>
<%
	if(request.getMethod().equals("POST")){
	boolean flag = boardDAO.update(dto);
%>
  <hr width="600" size="2" noshade />
  <b>
    <a href="update.jsp?seq=<%=dto.getSeq()%>">수정</a>
    | 
    <a href="del.jsp?seq=<%=dto.getSeq()%>">삭제</a>
    | 
    <a href="list.jsp">목록</a>
  </b>
  <hr width="600" size="2" noshade />
</center>

<script>
	if(<%=flag%>){
	    alert("수정성공(with JSP)");
	}else{
		alert("수정실패(with JSP)");
	}
	location.href="list.jsp";
</script>
<%
	}
%>