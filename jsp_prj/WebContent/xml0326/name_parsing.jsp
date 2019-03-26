<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="kr.co.sist.diary.vo.DiaryDetailVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
	public List<String> xmlParsing() throws IOException {
		List<String> list=new ArrayList<String>();
		//1. XML과 연결
		BufferedReader br=null;
		try {
			File file=new File("C:/dev/workspace/jsp_prj/WebContent/xml0326/names.xml");
			
			br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		//2. 줄단위로 읽어들이기
		String temp="";
		while((temp=br.readLine())!=null) {
			if(temp.contains("<name>")) {//줄단위로 읽어들인 내용에<name>가 있다면
				 list.add(temp.substring(temp.indexOf(">")+1, temp.lastIndexOf("<")));
			}
		}
		}finally{
			if (br!=null) {br.close();}
		}//end finally
		
		return list;
		}
	

%>    
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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
<div id="wrap">
   <div id="header">
         <div id="headerTitle"> SIST Class4</div>
          <div style="padding-top: 100px;">
         <c:import url="../common/jsp/main_menu.jsp"/>
         </div>
         </div>
   <div id="container">
		<table border="1">
			<tr>
				<td width="100">이름</td>
			</tr>
			<c:forEach var="name" items="<%=xmlParsing() %>">
				<tr>
					<td style="text-align: center">${name }</td>
				</tr>
			</c:forEach>
			
		</table>
 </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>