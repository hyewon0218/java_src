<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<div id="wrap">
   <div id="header">
         <div id="headerTitle"> SIST Class4</div>
         </div>
   <div id="container">
   <%
   		File uploadFolder=new File("C:/dev/workspace/jsp_prj/WebContent/upload");
   		File[] listFile=uploadFolder.listFiles();
   %>
   <a href="upload_form.jsp">업로드</a><br/>
   <table border="1">
  	<tr>
   		 <th width="60">번호</th>
    	 <th width="350">파일명</th>
    	 <th width="150">업로드 일시</th>
    	 <th width="120">크기(byte)</th>
  	</tr>
  	<%
  		if(listFile.length!=0) {
  			File temp=null;
  			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm");
  			for(int i=0; i<listFile.length; i++) {
  			temp=listFile[i];
  	%>
  	<tr>
  		<td><%=i+1 %></td>
  		<td><a href="download.jsp?file_name=<%=temp.getName() %>"><%=temp.getName()%></a></td>
  		<td><%=sdf.format(new Date(temp.lastModified())) %></td>
  		<td><%=temp.length() %>byte</td>
  	</tr>
	<%
			}//end for
  		}else {
  			out.println("<tr><td colspan='4' align='center'>업로드된 파일이 존재하지 않습니다.</td><tr>");
  		}//end else
  	 %>
</table>

   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>