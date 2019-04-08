<%@page import="kr.co.sist.exam.domain.EmpJoin"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String mgr=request.getParameter("mgr");
	if(mgr !=null) {
		MyBatisService1 mbs1=new MyBatisService1();
		List<EmpJoin> list=mbs1.join(Integer.parseInt(mgr));
		pageContext.setAttribute("empList", list);
	}//end if

%>
<div>
<c:set var="mgr" value="7566,7698,7788,7839,7902"/>
<c:forTokens var="mgr" items="${mgr }" delims=",">
	[<a href="main.jsp?page=day0408/join&mgr=${mgr }"><c:out value="${mgr }"></c:out></a>]
</c:forTokens>
</div>

<div>
<table border="1">
<tr>
	<th width="60">사원번호</th>
	<th  width="100">사원명</th>
	<th  width="80">연봉</th>
	<th  width="150">입사일</th>
	<th  width="60">부서번호</th>
	<th  width="100">부서명</th>
	<th  width="80">위치</th>
</tr>
<c:if test="${empty empList }">
<tr>
	<td colspan="7" align="center">
		${param.mgr }매니저가 관리하는 사원은 존재하지 않습니다.
	</td>
</tr>
</c:if>
<c:forEach var="emp" items="${empList }">
	<tr>
		<td><c:out value="${emp.empno }"></c:out></td>
		<td><c:out value="${emp.ename }"></c:out></td>
		<td><c:out value="${emp.sal}"></c:out></td>
		<td><c:out value="${emp.hiredate}"></c:out></td>
		<td><c:out value="${emp.deptno}"></c:out></td>
		<td><c:out value="${emp.dname }"></c:out></td>
		<td><c:out value="${emp.loc }"></c:out></td>
	</tr>
</c:forEach>
</table>
</div>
























