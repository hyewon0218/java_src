<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="include 연습"
    %>



	<!--끼워지는 jsp에서는 코드가 들어가는 태그의 자식 태그로 들어가기 때문에 <html>가지지 않고  
	포함되는 태그로만 구성한다. -->
	<%! public String toDay() {
		String toDay="";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd EEEE HH:mm:ss");
			toDay=sdf.format(new Date());
		return toDay;
		
		}//toDay
		%>
	<%	 
		//끼워지는 모든 JSP에서의 공통코드를 정의 
		int age=30;
		String addr="서울시 강남구";
	%>
	<div>
	<strong>끼워지는 JSP</strong>
	나이 : <%=age %><br/>
	주소 : <%=addr %><br/>
	<%-- 
	외부 JSP에서 제공하는 변수는 외부JSP에서 존재할 수도 있고
	존재하지 않을 수도 잇다. 따라서 내부 JSP에서 외부 JSP의 변수를
	사용하는 코드는 에러는 유발하는 원인이 될 수도 있기 때문에
	가급적이면 외부 JSP의 변수를 사용하지 않는다.
	<strong>외부 JSP 변수 : <%=name %></strong> --%>
	</div>