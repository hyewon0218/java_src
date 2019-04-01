<%@page import="org.json.simple.JSONObject"%>
<%@page import="ajax0401.WebMemberService"%>
<%@page import="ajax0401.WebMemberDAO"%>
<%@page import="json0328.JsonService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String id=request.getParameter("id");
	WebMemberService wm_service=new WebMemberService();
	JSONObject json=wm_service.searchId(id);
	out.println(json.toJSONString());
 
 %>