<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajax test</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(function(){
				//$("#searchOk01").on("click", function(){
				$("#seq").on("keyup", function(){
					$.ajax({
						url : "ajax.do?m=search01",
			            type : "get",
			            data : {seq : $("#seq").val()},
			            //datatype: 'json',
			            success : function (data) {
			                //console.log(data);
			                
			                //let jsObj = JSON.parse(data);  //JSON -> jsObj (jquery 낮은버젼일때)
			                //let json = JSON.stringify(jsObj) //jsObj -> JSON 
			                
			                let html = "";
			                html += "<form id='ajax'>";
			                html += "번호: <input name='seq' value='"+data.seq+"'>";
			                html += "이름: <input name='name' value='"+data.name+"'>";
			                html += "주소: <input name='addr' value='"+data.addr+"'>";
			                html += "날짜: <input name='rdate' value='"+data.rdate+"'>";
			                html += "</form>";
			                	
			              	$("#name").val("");
			                $("#container").html(html);	
			            },
			            error : function (data) {
			                //alert("존재하지않는 SEQ");
			            }
					});
				});
				
				
				//$("#searchOk02").on("click", function(){
				$("#name").on("keyup", function(){
					$.ajax({
						url : "ajax.do?m=search02",
			            type : "post",
			            data : {na : $("#name").val()},
			            //datatype: 'json',
			            success : function (data) {
			                console.log(data);
			            	//console.table(data);
							
			            	let html = "";
			            	html += "<center>";
			            	html += "<table border='1' width='50%'>";
			            	html += "<tr>";
			            	html += "<th>번호</th>";
			            	html += "<th>이름</th>";
			            	html += "<th>주소</th>";
			            	html += "<th>날짜</th>";
			            	html += "</tr>";
			            	if(data.length == 0){
			            		html += "<tr>";
			            		html += "<td colspan='4' align='center'>검색 결과 없음</td>";
			            		html += "</tr>";
			            	}else{
			            		for(const address of data){
			            			html += "<tr>";
			            			html += "<td align='center'>"+address.seq+"</td>";
			            			html += "<td align='center'>"+address.name+"</td>";
			            			html += "<td align='center'>"+address.addr+"</td>";
			            			html += "<td align='center'>"+address.rdate+"</td>";
			            			html += "</tr>";
			            		}
			            	}
			            	html += "</table>";
			            	html += "</center>";
			            	
			            	$("#seq").val("");
			                $("#container").html(html);	
			            }
					});
				});
			});
		</script>
	</head>
	<body style="text-align:center">
		<h2>비동기통신</h2>
		
		번호: <input name="seq" id="seq">
		<input type="button" value="번호검색" id="searchOk01">
		<br/>
		
		이름: <input name="name" id="name">
		<input type="button" value="이름검색" id="searchOk02">
		<br/><br/>
		
		<div id="container"></div>
		<br/><br/>
		
		<a href="../">인덱스</a><br/><br/>
	</body>
</html>