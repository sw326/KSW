<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">

<html>
  <head>
    <title>reboard_list_partSel.jsp</title>
  </head>
  <body>
    <center>
      <hr width="600" color="Maroon" size="2" noshade>
      <font size="5" color="Navy">
        <b>SOO board</b>
      </font>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="rb-write.do?method=write">글쓰기</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href='main.do'>메인</a>

      <form name="f">
        <input type="hidden" name="method" value="list">
        <select name="ps" onChange="submit()">
          <option value="3">페이지 SIZE 선택</option>
          <option value=5>페이지 SIZE 5</option>
          <option value=10>페이지 SIZE 10</option>
          <option value=15>페이지 SIZE 15</option>
          <option value=20 selected>페이지 SIZE 20</option>
        </select>
      </form>

      <hr width="600" color="Maroon" size="2" noshade>

      <table align="center" cellspacing="1" cellpadding="3" width="600" border="1">
        <tr align="center">
          <td width="10%"><b>순번</b></td>
          <td width="40%"><b>제목</b></td>
          <td width="15%"><b>글쓴이</b></td>
          <td width="15%"><b>날짜</b></td>
          <td width="20%"><b>조회수</b></td>
        </tr>
        <c:if test="${empty list}">
          <tr>
            <td align='center' colspan="5">데이터가 하나도 없음</td>
          </tr>
        </c:if>
        <c:forEach items="${list}" var="reboard">
          <tr align="center">
            <td width="10%">${reboard.idx}</td>
            <td width="40%" align="left">
              <!-- 들여쓰기를 위한 공백 -->
              <c:forEach begin="1" end="${reboard.depth}">
                &nbsp;&nbsp;&nbsp;&nbsp;
              </c:forEach>
              
              <!-- 답글인 경우 화살표 표시 -->
              <c:if test="${reboard.depth > 0}">
                ↳
              </c:if>
              
              <a href="rb-content.do?method=content&idx=${reboard.idx}">
                ${reboard.subject}
              </a>
            </td>
            <td width="15%">${reboard.writer}</td>
            <td width="15%">${reboard.createdAt}</td>
            <td width="20%">${reboard.hit}</td>
          </tr>
        </c:forEach>
        <tr>
          <td colspan="3" align="center">
            |
            <a href="rb-list.do?method=list&cp=1&ps=20">
              <b>1</b>
            </a>
            |
            &nbsp;&nbsp;&nbsp;
            1page/1pages
          </td>
          <td colspan="2" align="center">
            총 게시물 수 : 16
          </td>
        </tr>
      </table>
      <hr width="600" color="Maroon" size="2" noshade>
    </center>
  </body>
</html>