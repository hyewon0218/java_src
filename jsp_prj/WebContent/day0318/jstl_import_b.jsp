<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="지시자의 충돌이 발생하지 않는다."
    %>
    공통디자인 정의 <br/>
    <%
    String week="오늘은 월요일!!!";
    pageContext.setAttribute("week", week);
    %>
	<strong>${week }</strong><!-- pageScope. 생략-->