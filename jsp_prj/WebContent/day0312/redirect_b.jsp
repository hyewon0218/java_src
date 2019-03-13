<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    info="redirect의 연습"%>
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
#container{ width: 800px; height:600px; }
#footer{ width: 800px; height:120px;}
#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }
</style>
</head>
<body>
<div id="wrap">
   <div id="header">
         <div id="headerTitle"> SIST Class4</div>
         </div>
   <div id="container">
   비정상적요청이있을때보여질페이지<br/>
   <a href="redirect_a.jsp?name=jungyun&age=20">요청</a>
   <div>
   <!--forward와는 다르게 이동한 페이지에서 파라메터값을 사용할 수 없다. 
   	    비정상적인 요청이 있을 때 제공될 페이지이므로 이전 페이지의 값들을 
   	    사용할 필요가 없다.
    -->
   	파라메터 이름: <%=request.getParameter("name") %><br/>
   	파라메터 나이: <%=request.getParameter("age") %><br/>
   </div>
   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>