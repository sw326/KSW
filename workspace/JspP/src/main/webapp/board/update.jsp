<%@ page contentType="text/html;charset=utf-8" 
	import="mvc.domain.Board"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

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
  <h2>Simple Board with Model2 with JSTL+EL</h2>
  &nbsp;&nbsp;&nbsp;
  <a href="list.jsp">글목록</a>
  <hr width="600" size="2" noshade />

<c:set var="board" value="${board}"/>
  
  <form name="f" method="post" action="brd.do?m=update" enctype="multipart/form-data">
    <input type="hidden" name="seq" value="${board.seq}" />
    <input type="hidden" name="writer" value="${board.writer}" />
    <table border="1" width="600" align="center" cellpadding="3" cellspacing="1">
      <tr>
        <td width="30%" align="center">글쓴이</td>
        <td align="center"><input type="text" name="aa" size="60" value="${board.writer}" disabled></td>
      </tr>
      <tr>
        <td width="30%" align="center">이메일</td>
        <td align="center"><input type="text" name="email" size="60" value="${board.email}"></td>
      </tr>
      <tr>
        <td width="30%" align="center">글제목</td>
        <td align="center"><input type="text" name="subject" size="60" value="${board.subject}"></td>
      </tr>
      <tr>
        <td width="30%" align="center">글내용</td>
        <td align="center"><textarea name="content" rows="5" cols="53">${board.content}</textarea></td>
      </tr>
      <tr>
        <td width="30%" align="center">첨부파일</td>
        <td align="center">
        	<input type="file" name="fname" size="60" value="${board.fname}">
        	<span>${board.fname}</span>
        </td>
        <input type="hidden" name="fname" value="${board.fname}">
        <input type="hidden" name="ofname" value="${board.ofname}">
        <input type="hidden" name="fsize" value="${board.fsize}">
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="수정">
        </td>
      </tr>
    </table>
  </form>
  <hr width="600" size="2" noshade />
  <b>
    <a href="brd.do?m=update&seq=${board.seq}">수정</a>
    |
    <a href="brd.do?m=delete&seq=${board.seq}">삭제</a>
    |
    <a href="brd.do">목록</a>
  </b>
  <hr width="600" size="2" noshade />
</center>