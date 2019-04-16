<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="세션 값을 사용하는 페이지"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc/common/css/main_v20190130.css">
<style type="text/css">
#wrap{ margin:0px auto; width: 800px; height:860px;}
#header{ width: 800px; height:140px;background: #FFFFFF url(http://localhost:8080/spring_mvc/common/images/header_bg.png); 
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
		
	});//ready
</script>
</head>
<body>
<div id="wrap">
   <div id="header">
         <div id="headerTitle"> SIST Class4</div>
          <div style="padding-top: 100px;">
         <c:import url="/common/jsp/main_menu.jsp"/>
         </div>
         </div>
   <div id="container">
		<strong>세션 사용</strong><br/>
		<strong>${sessionScope.flag }</strong><br/>
		<strong>이름 : </strong>${sessionScope.ses_name}<br/>
		<strong>주소 : </strong>${sessionScope.ses_addr}<br/>
 </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>