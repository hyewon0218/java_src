<%@page import="org.json.simple.JSONObject"%>
<%@page import="json0328.JsonService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String deptno=request.getParameter("deptno");
	if(deptno==null) {
		deptno="10";
	}//end if
	
	int intDeptno=Integer.parseInt(deptno);
	JsonService js=new JsonService();
	JSONObject json_obj=js.seacrchEmpData(intDeptno);
	out.println(json_obj.toJSONString());
%>