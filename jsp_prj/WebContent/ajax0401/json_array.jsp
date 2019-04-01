<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String[] nameArr={"김희철","김정윤","노진경","공선의"};
 	String[] addrArr={"서울시 동작구","서울시 역삼동","서울시 방화동","서울시 신정동"};
 	int[] ageArr={30,25,25,31};
 	
 	JSONArray json_arr=new JSONArray();
 	
 	JSONObject json_obj=null;
 	for(int i=0; i<nameArr.length; i++) {
 		json_obj=new JSONObject();
 		json_obj.put("name", nameArr[i]);
 		json_obj.put("addr", addrArr[i]);
 		json_obj.put("age", ageArr[i]);
 		json_arr.add(json_obj);
 		
 	}
 		out.println(json_arr.toJSONString());
 %>