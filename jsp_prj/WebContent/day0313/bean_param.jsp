<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="Web Parameter를 사용하여 useBean action tag로 처리하는 방법"
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
   <!--HTML Form Control의 값 받기  -->
   <%request.setCharacterEncoding("UTF-8"); %>
   <!--1. bean 생성  -->
   <jsp:useBean id="bp_vo" class="day0313.BeanParamVO" scope="page"/>
   <!--1. setter method를 불러 값을 저장-->
   <jsp:setProperty property="*" name="bp_vo"/>
   <table>

  <tr>
    <td colspan="2">입력하신 정보는 아래와 같습니다.</td>
  </tr>
  <tr>
    <td >아이디</td>
    <td ><jsp:getProperty property="id" name="bp_vo"/></td>
  </tr>
  <tr>
    <td >이름</td>
    <td ><jsp:getProperty property="name" name="bp_vo"/></td>
  </tr>
  <tr>
    <td >생년월일</td>
    <td ><!-- 숫자로 변환되어 저장된 값 -->
    <jsp:getProperty property="b_year" name="bp_vo"/>-
    <jsp:getProperty property="b_month" name="bp_vo"/>-
    <jsp:getProperty property="b_day" name="bp_vo"/>
    (만 <%=2019-bp_vo.getB_year() %>세)
    </td>
  </tr>
  <tr>
    <td >관심언어</td>
    <%-- <td ><jsp:getProperty property="interestlang" name="bp_vo"/></td> --%>
    <td>
    <%
    	String[] lang=bp_vo.getInterestlang();
  		  if(lang !=null) {
    			for(int i=0; i<lang.length; i++) {
    		out.print(lang[i]);
    		out.print(" ");
    			}
   		 }else {
    			out.println("관심언어없음");
   		 }
    %>
    </td>
  </tr>
</table>

  <%--  <%=bp_vo %> --%>
   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>