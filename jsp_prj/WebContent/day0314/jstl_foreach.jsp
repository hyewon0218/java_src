<%@page import="day0313.TestVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="반복문 forEach의 사용"
    %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <select>
   <!--증가하는 값을 반복시킬 때  -->
  		<c:forEach var="i" begin="1" end="100" step="1">
   		<option value=${ i }><c:out value="${i }"/></option>
   		</c:forEach>
   </select>
   <div>
   	<%
   	//배열의 값을 출력
   		String[] movie={"시네마 천국","코어","7인의 사무라이","트루먼 쇼","인셉션"};
   		pageContext.setAttribute("movie", movie/*String[] movie의 movie  */);
   		%>
   	
   	<ul>
   		<c:forEach var="movie" items="${movie }" ><!--setAttribute("movie" 의 movie -->
   			<c:set var="i" value="${i+1 }"></c:set>
   			<li>${i}.${movie }</li><!--var의 movie  -->
   		</c:forEach>
   	</ul>	
   		<!--2019 03 15 추가  -->
   	<%
	//List의 값 출력
	/* List */
	List<String> list=new ArrayList<String>();
   	list.add("JAVA SE");
   	list.add("JAVA EE");
   	list.add("DBMS");
   	list.add("HTML");
   	pageContext.setAttribute("list", list);
   	%>
   	<ul>	
   	<c:forEach var="subject" items="${list }">
   	<li><c:out value="${subject }"></c:out></li>
   	
   	</c:forEach>
   	</ul>
   </div>
   <%
    //List가 generic으로 vo를 가진 경우 사용
    //forEach안에서 "변수명.getter명" 
    List<TestVO> voList=new ArrayList<TestVO>();
    voList.add(new TestVO("정윤",30));
    voList.add(new TestVO("희철",27));
    voList.add(new TestVO("재찬",28));
    voList.add(new TestVO("택성",27));
    
    pageContext.setAttribute("vl",voList);
   %>
   <table border="1">
   <thead>
	<tr>
		<th width="50">번호</th>
		<th width="100">이름</th>
		<th width="50">나이</th>
	</tr>   
	</thead>
   	<tbody>
  	 <c:forEach var="data" items="${vl }">
 	 <c:set var="cnt" value="${cnt+1 }"/>
  	 <tr>
   		<td><c:out value="${cnt }"/></td><!--c:out==>xss막기위해  -->
   		<td><c:out value="${data.firstName }"/></td><!--c:out==>xss막기위해  -->
   		<td><c:out value="${data.age }"/></td><!--c:out==>xss막기위해  -->
   	</tr>
    </c:forEach>
   </tbody>
   </table>
   
   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>













