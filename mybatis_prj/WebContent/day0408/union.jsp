<%@page import="kr.co.sist.exam.domain.Union"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  <%
  	MyBatisService1 mbs1=new MyBatisService1();
 	List<Union> list=mbs1.union();
 	pageContext.setAttribute("list",list);
  
  %>
  <table border="1">
  	<tr>
  		<th width="60">사원번호</th>
  		<th width="120">사원명</th>
  		<th width="120">직무</th>
  		<th width="80">연봉</th>
  		<th width="150">입사일</th>
  		<th width="60">부서번호</th>
  		<th width="60">퇴사여부</th>
  	</tr>
  	<c:if test="${empty list }">
  	<tr>
  	<td colspan="7" align="center">사원존재않</td>
  	</tr>
  	</c:if>
  	<c:forEach var="emp" items="${list }">
  	<tr>
  		<td><c:out value="${emp.empno }"></c:out></td>
  		<td><c:out value="${emp.ename }"></c:out></td>
  		<td><c:out value="${emp.job }"></c:out></td>
  		<td><c:out value="${emp.sal }"></c:out></td>
  		<td><c:out value="${emp.hiredate }"></c:out></td>
  		<td><c:out value="${emp.deptno}"></c:out></td>
  		<td><c:out value="${emp.retired eq 'N'?'재직자':'퇴사자'}"></c:out></td>
  	</tr>
  	</c:forEach>
 </table>