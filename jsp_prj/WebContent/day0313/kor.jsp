<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   <%
   		//HTML Form Control에서 입력된 값
   		String name=request.getParameter("name");
   		String age=request.getParameter("age");
   		String addr=request.getParameter("addr");
   		//<jsp:param으로 생성된 값
   		String lang=request.getParameter("lang");
   		String date=request.getParameter("date");
   %>
   <strong>안녕하세요? 한국어 페이지입니다.</strong>
   <strong>입력하신 값은 아래와 같습니다.</strong>
   <ul>
   		<li>이름 : <strong><%=name %></strong></li>
   		<li>나이 : <strong><%=age %></strong></li>
   		<li>주소 : <strong><%=addr %></strong></li>
   		<li>사용언어 : <strong><%=lang%></strong></li>
   		<li>접속시간 : <strong><%=date%></strong></li>
   		<li>지역선택 
   			<select>
   				<% 
   				String[] loc=(String[])request.getAttribute("loc");
   				for(int i=0; i<loc.length; i++) {
   				%>
   					<option value="<%=loc%>"><%=loc[i]%></option>
   				<%				
	   				}
   			 %>
   			</select>
   		</li>
   </ul>
   <a href="forward_a.jsp">입력폼으로 이동</a>
   
   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>