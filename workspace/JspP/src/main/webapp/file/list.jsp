<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="../login/login_check_module.jsp"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>list.jsp</title>
		<style>
			a{text-decoration:none}
		    table{
		        width:50%
		    }
			table,th,td {
			  border : 1px solid black;
			  border-collapse: collapse;
			}
			th,td {
			  padding: 5px;
			}
		</style>
	</head>
	<body style="text-align:center">
	    <h1>FileUpload List</h1>
	    <a href="file.do?m=form">업로드 폼</a>
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="file.do?m=form_mt">업로드 폼(멀티)</a>
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="../">인덱스</a>
	    <br/><br/>
	    
	    <center>
	    <table>
	        <tr>
	           <th>이름</th>
	           <th>크기</th>
	           <th>삭제</th>
	        </tr>
			<c:if test="${empty files}">
	           <tr>
	              <td align="center" colspan="3">파일이 하나도 없음</td>
	           </tr>
			</c:if>
			<c:forEach items="${files}" var="file">
	           <tr>
	             <td align="center">
	               <a href="file.do?m=download&fname=${file.name}">${file.name}</a>
	             </td>
	             <td align="center">${file.length()}</td>
	             <td align="center">
	               <a href="file.do?m=del&fname=${file.name}">삭제</a>
	             </td>
	          </tr>
			</c:forEach>
	    </table>
	    </center>
	</body>
</html>