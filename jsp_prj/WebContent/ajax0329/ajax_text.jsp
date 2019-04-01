<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css">
<style type="text/css">
#wrap{ margin:0px auto; width: 800px; height:860px;}
#header{ width: 800px; height:140px;background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png); 
            position:relative;}
#headerTitle{ font-family: HY견고딕,고딕; font-size: 35px; font-weight: bold; text-align: center; 
               position: absolute; top:40px; left:290px}
#container{ width: 800px; min-height:600px; }
#footer{ width: 800px; height:120px;}
#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function (){
		$("#btn").click(function (){
			var name=$("#name").val()
			//chrome은 URL을 자동처리 (가->%AA%BB%CC)하지만 
			//IE는 처리하지 않는다.) javascipt encoding함수 -> encodeURI
			var queryString="name="+encodeURI(name);
			$.ajax({url:"text_result.jsp",
					type: "GET",
					data: queryString ,
					dataType:"TEXT",
					error:function (xhr){
						//XMLHttpRequest->xhr 사용하면 error의 이유를 확인가능.
						//200- 서버가 정상실행 되어 응답성공하였으나 응답의 형태가 
						//처리가능한 데이터가 아닐 때 {"이름":값,}
						alert("에러코드"+xhr.status+",에러메세지 : "+xhr.statusText);
					},
					success:function(text_data){
						//서버에서 응답된 데이터를 받아 처리한다.
						
						var output="<strong>"+name+"</strong>조장의조원<ul>";
						var data=text_data.split(",");
						for(var i=0; i< data.length; i++) {
							output+="<li>"+data[i]+(data[i]=="김건하"?"CEO":"")+"</li>";
						}
						output+="</ul>";
						$("#memberDiv").html(output);
					}
			});//ajax
		});//ready
	});//ready
</script>
</head>
<body>
<div id="wrap">
   <div id="header">
         <div id="headerTitle"> SIST Class4</div>
          <div style="padding-top: 100px;">
         <c:import url="../common/jsp/main_menu.jsp"/>
         </div>
         </div>
   <div id="container">
		<div>
			조장 : <input type="text" id="name"  class="inputBox" ><br/><!--name="name" 없어도됨  -->
			<input type="button" value="입력" class="btn" id="btn">
		</div>
	 <div id="memberDiv">
	 </div>
 </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>