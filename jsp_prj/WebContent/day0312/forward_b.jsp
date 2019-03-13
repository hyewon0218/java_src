<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    info="업무처리페이지에서 처리한 결과를 받아 화면을 구성하는 일"
    %>
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
		//이전페이지에서 처리된 결과 받기.
		String[] member=(String[])request.getAttribute("group2");
		if(member==null) {
			response.sendRedirect("forward_a.jsp");
			return;
		}//end if
		%>
		<table border="1">
		<tr>
			<th width="100">이름</th>
		</tr>
		<%for(int i=0; i<member.length; i++) { %>
		<tr>
			<td><%=member[i] %></td>
		</tr>
		<%} %>
		</table>
		<a href="forward_a.jsp?name=jungyun&age=30">parameter 요청</a>
		<br/>
		<!--forward로 이동한 페이지에서 이전페이지의 Parameter를 사용할 수 있다.  -->
		파라메터 이름 : <%=request.getParameter("name") %> <br/>
		파라메터 나이 : <%=request.getParameter("age") %> 
   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>