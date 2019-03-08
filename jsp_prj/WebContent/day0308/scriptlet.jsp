<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="scriptlet 연습"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css">
<style type="text/css">
#wrap{ margin:0px auto; width: 800px; height:860px;}
#header{ width: 800px; height:140px;background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png); 
            position:relative;}
#headerTitle{ font-family: HY견고딕,고딕; font-size: 35px; font-weight: bold; text-align: center; 
               position: absolute; top:40px; left:290px}
#container{ width: 800px; height:600px; }
#footer{ width: 800px; height:120px;}
#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }
td:HOVER{background-color: #}
</style>

<script type="text/javascript">
$(function() {
	$(".t").click(function () {
		alert($(this).children().val())
	});
});

var d=new Date();
var time="";
time+=d.getFullYear()+"-"d.getMonth()+"-"+d.getDate()+"-"+d.getHours()+"-"+d.getMinutes()+"-"+d.getSeconds();

$("#c_time").text(time);

</script>
</head>
<body>
<div id="wrap">
   <div id="header">
         <div id="headerTitle"> SIST Class4</div>
         </div>
   <div id="container">
		<%
			//scriptlet은 _jspService method내에 코드가 생성된다.
			int i=3;//지역변수 : 자동초기화가 되지 않는다.
		%>
		<%=i %>
		<% for(int j=1; j<7; j++) {  %>
			<h<%= j%>>오늘은 불금입니다.</h<%= j%>>
		<% }//end for  %>
		<%
			String[] names={"노진경","김정운","박영민","김희철","박소영","이지수"};
		%>
		<table border="1">
		<tr>
			<th width="100" >이름</th>
		</tr>
		<% for(int j=0; j<names.length; j++) { %>
		<tr>
			<td><%=names[j] %></td>
		</tr>
		<% }%>
		</table>
		
	
		<%
		int total=0;
		 for(int j=0; j<101; j++) { 
			total+=j;
		 }//end for 
		 %>
		 <div>
		 1에서부터 100까지 합은<%=total %>입니다.
		 </div>
		 
		<table border="1">
	
		<% for(int j=1; j<10; j++) { %>
		<tr>
			<td><%=3 %>x<%=j %>=<%=3*j %></td>
		</tr>
		<% }%>
		</table>
		
		<table border="1">
		<% for(int j=1; j<10; j++) { %>
		<tr>
		<% for(int k=2; k<10; k++) { %>
			<td width="40" align="center" onclick="alert('<%=k*j %>')"><%=k %>x<%=j %>
			<!-- <td width="40" align="center" class="t"> -->
			<%-- <input type="hidden" name="sum" value="<%=k*j %>"> --%>
			</td>
		
		<% }%>
		</tr>
		<% }%>
		</table>
   <!-- 년-월-일 요일 시:분을 서버의 시간으로 얻어와서 흘러가는 문자열로 보여주세요 
   	버튼을 클릭하면 해당 일자가 3초동안 서서히 사라지도록 만들어주세요....jquery
    -->
     <%
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm:ss");
     String date=sdf.format(new Date());
     %>
     <div>
     	서버의 시간 : <span id="s_time"><%=date %></span>
     	접속자시간 : <span id="c_time"></span>
     </div>
   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>





















