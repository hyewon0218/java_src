<%@page import="kr.co.sist.exam.domain.Car2"%>
<%@page import="kr.co.sist.exam.vo.DeptnoVO"%>
<%@page import="kr.co.sist.exam.domain.DynamicIf"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="kr.co.sist.exam.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 	String country=request.getParameter("country");
 	MyBatisService1 mbs=new MyBatisService1();
	List<Car2> countryList=mbs.work1(country);
	pageContext.setAttribute("countryList", countryList);
	
 	
 	if(country !=null) {
 		List<Car2> list=mbs.work1(country);
 		pageContext.setAttribute("carList", list);
 	}

 	%> 
 <form action="main.jsp" method="get">
 	<input type="hidden" name="page" value="day0409/work">
 	<label>제조국</label>
 	<select name="country">
 	<c:forEach var="country" items="${ countryList}">
 		<option value="${country }"><c:out value="${country }" escapeXml="false"/> </option>
 	</c:forEach>
 	</select>
 	<label>제조사</label>
 	<select name="maker">
 	<c:forEach var="maker" items="${ carList}">
 		<option value="${maker }"><c:out value="${maker }" escapeXml="false"/> </option>
 	</c:forEach>
 	</select>
 	<label>모델명</label>
 	<select name="model">
 	<c:forEach var="model" items="${ model}">
 		<option value="${model }"><c:out value="${model }" escapeXml="false"/> </option>
 	</c:forEach>
 	</select>
 		
 	 <input type="submit" value="사원 조회" class="btn"><br/>
 	</form>
 	<div>
 	<c:if test="${not empty param.car }">
 	 	<div>
 	 		<c:out value="${param.car eq 'car'?'국산':'수입' }"/>의 자동차 조회 결과
 	 	</div>
 		<table border="1">
 			<tr>
 				<td width="50">이미지</td>
 				<td width="300">옵셥</td>
 				<td width="100">연식</td>
 			</tr>
 			<c:if test="${empty carList }">
 			
 			</c:if>
 			<c:forEach var="car" items="${carList }">
 				<tr>
 					<td><img src="http://localhost:8080/mybatis_prj/day0409/images/${car.img }" style="width: 80px; height: 60px;"></td>
 					<td><c:out value="${car.carOption }"/></td>
 					<td><c:out value="${car.carYear }"/></td>
 				</tr>
 			</c:forEach>
 		</table>
 	</c:if>
 	</div>