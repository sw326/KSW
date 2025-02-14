<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta charset="utf-8">
<style>
	table, th, td {
	   border: 1px solid black;
	   border-collapse: collapse;
	}
	th, td {
	   padding: 5px;
	}
	a { text-decoration:none }
</style>
<body onload="document.f.name.focus()">
<center>
   <h1>
		Address Input(Model1)
   </h1>
   <a href='../'>홈</a>
   &nbsp;&nbsp;&nbsp;
   <a href='list.jsp'>리스트</a>
   <form name="f" action="insert.jsp" method="post">
       <table border="1" width="300" height="200">
	      <tr>
		     <td width="30%" colspan="2" align="center"><h2>입력폼</h2></td> 
		  </tr>
		  <tr>
		     <th width="30%">이름</th> 
			 <td><input name="name" align="center" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <th width="30%">주소</th> 
			 <td><input name="addr" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			     <input type="submit" value="전송"/>
				 <input type="reset" value="취소"/>
			 </td> 
		  </tr>
	   </table>
   </form>
</center>
</body>