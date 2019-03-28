<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
 	String name ="김정윤";
	int age=30;
	
	JSONObject json=new JSONObject();// { }
	json.put("name", name);
	json.put("age", age);
	out.println(json.toJSONString());
%>

<%-- <%-- {"name":"<%=name %>","age":<%=age %> } --%> 