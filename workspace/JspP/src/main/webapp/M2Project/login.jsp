<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
  <head>
    <title>login.jsp</title>
	<style type="text/css">
	   table{text-align: center} 
	</style>
	<script language="javascript">
		function check() {
    if(f.id.value == "") {
        alert("아이디를 입력하셔야 합니다.");
        f.id.focus();
        return false;
    }
    if(f.pwd.value == "") {
        alert("비밀번호를 입력하셔야 합니다.");
        f.pwd.focus();
        return false;
    }

    // URLSearchParams 사용하여 데이터 전송
    const formData = new URLSearchParams();
    formData.append('method', 'loggedIn');
    formData.append('id', f.id.value);
    formData.append('pwd', f.pwd.value);

    fetch("${pageContext.request.contextPath}/M2Project/login.do", {
        method: "POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: formData.toString(),
        credentials: 'include'
    })
    .then(response => response.text())
    .then(data => {
        console.log("서버 응답:", data);
        if(data.includes("LOGGED_IN")) {
            opener.document.location.reload(true);
            window.close();
        } else {
            alert("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
    })
    .catch(error => {
        console.error("에러:", error);
    });

    return false;
}
	   function rewrite() {
	      f.id.focus();
	   }
	</script>
  </head>
  <body onload="f.id.focus();">
     <form name="f" onsubmit="return false;">
	    <input type="hidden" name="method" value="loggedIn">
	    <table align="center" cellpadding="3" cellspacing="1" 
		                          border="1" bordercolor="Maroon">
           <tr>
		     <td colspan="2" align="center">
			   <font size="4"><B>로그인</B></font>
			 </td>
		   </tr>
		   <tr>
		     <td>아이디</td>
			 <td><input type="text" name="id" size="20"></td>
		   </tr>
		   <tr>
		     <td>비밀번호</td>
			 <td><input type="password" name="pwd" size="20"></td>
		   </tr>
		   <tr>
		     <td colspan="2" align="center" onclick="check()"> 
			    <input type="submit" value="로그인">
				<input type="reset" value="다시입력" onclick="rewrite()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="닫기" onclick="self.close()">
			 </td>
		   </tr>
		</table>
	 </form>
  </body>
</html> 

