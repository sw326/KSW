<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Fileupload Form</title>
		<style>
			a{text-decoration:none}
		</style>
	</head>
	<body style="text-align:center">

		<h1>Fileupload Form</h1>
		<form action="file.do?m=upload"  method="post" enctype="multipart/form-data">
					이름: <input name="name"><br/>
				파일: <input type='file' name='file'><br/>
			<input type='submit' value="전송">
		</form> 
		
	</body>
</html>