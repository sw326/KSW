<%@ page contentType="text/html;charset=utf-8" 
	import="java.util.ArrayList, mvc.domain.Board"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
	<title> Chumji's Paging Board </title>
	<meta charset="utf-8">
	<style>
		a{text-decoration:none}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
	function loadPage(page) {
	    $.ajax({
	        url: 'brd.do',  // URL을 'list.do'에서 'brd.do'로 수정
	        type: 'GET',
	        data: { 
	            cp: page, 
	            ps: $('#psId').val() 
	        },
	        success: function(response) {
	            // 전체 페이지를 새로고침
	            document.open();
	            document.write(response);
	            document.close();
	        },
	        error: function(xhr, status, error) {
	            alert('Error loading data: ' + error);
	        }
	    });
	}

	function changePageSize(select) {
	    var pageSize = $(select).val();
	    window.location.href = 'brd.do?ps=' + pageSize;  // AJAX 대신 전체 페이지 새로고침
	}
    </script>
</head>
<body>
    <center>
        <h3>Chumji's Paging Board</h3>
        <a href='../'>인덱스</a>
        <a href='brd.do?m=input'>글쓰기</a>
        <hr>

        <div id="boardList">
            <table border='2' width='600' align='center'>
                <tr align='center' bgcolor='AliceBlue'>
                    <th>no</th>
                    <th>writer</th>
                    <th>e-mail</th>
                    <th>subject</th>
                    <th>date</th>
                </tr>

                <c:if test="${empty list}">
                    <tr>
                        <td align='center' colspan="5">데이터가 하나도 없음</td>
                    </tr>
                </c:if>

                <c:forEach items="${list}" var="board">
                    <tr align='center'>
                        <td>${board.seq}</td>
                        <td>${board.writer}</td>
                        <td>${board.email}</td>
                        <td>
                            <a href="brd.do?m=content&seq=${board.seq}">${board.subject}</a>
                        </td>
                        <td>${board.rdate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <hr>
        <font color='gray' size='3'>
            (총페이지수 : ${totalPages})
            <c:forEach var="i" begin="1" end="${totalPages}">
    			<a href="javascript:void(0);" onclick="loadPage(${i});">
        			<c:if test="${i == curPage}">
          				<strong>${i}</strong>
       				</c:if>
			        <c:if test="${i != curPage}">
			            ${i}
			        </c:if>
			    </a>&nbsp;
			</c:forEach>
            ( TOTAL : ${totalRecords} )
        </font>

        <br>
        페이지 크기:
        <select id="psId" name="ps" onchange="changePageSize(this)">
            <option value="3" <c:if test="${pageSize == 3}">selected</c:if>>3</option>
            <option value="5" <c:if test="${pageSize == 5}">selected</c:if>>5</option>
            <option value="10" <c:if test="${pageSize == 10}">selected</c:if>>10</option>
        </select>
    </center>
</body>
</html>