<%@page import="kr.co.sist.exam.domain.Zipcode"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="kr.co.sist.exam.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 	MyBatisService1 mbs=new MyBatisService1();
	
	String dong=request.getParameter("dong");
	
	if(dong !=null) {
		List<Zipcode> list=mbs.like(dong);
		pageContext.setAttribute("zipList", list);
	}
 	%> 
 	<form name="frm" action="main.jsp">
 	<input type="hidden" name="page" value="day0405/like">
 	<label>동</label>
 	 <input type="text" name="dong" class="inputBox">
 	 <input type="submit" value=" 조회" class="btn"><br/>
 	 예) 상도동, 역삼동
 	</form>
 	<div>
 	<c:if test="${not empty param.dong }">
 	 	<div>
 	 		${param.dong }의 조회
 	 	</div>
 		<table border="1">
 			<tr>
 				<td width="80">우편번호</td>
 				<td width="400">주소</td>
 			</tr>
 			<c:if test="${empty zipList }">
 			<tr>
 				<td colspan="7" align="center">
 					<strong>${param.dong }</strong>은 존재하지 않습니다.
 				</td>
 			</tr>
 			</c:if>
 			<c:forEach var="zip" items="${zipList }">
 				<tr>
 					<td><c:out value="${zip.zipcode }"/></td>
 					<td><c:out value="${zip.sido } ${zip.gugun } ${zip.dong } ${zip.bunji }"/></td>
 				</tr>
 			</c:forEach>
 			
 		</table>
 	</c:if>
 	</div>