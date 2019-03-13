<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="Web Parameter 처리"%>
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
   //post방식의 요청일 때 한글처리
     request.setCharacterEncoding("UTF-8");
   	 String method=request.getMethod(); 
   %>
   <strong><%=method%></strong>
   <%
   		//Parameter 받기(사용자가 HTML Form Control에 입력한 값 받기.)
   		//Tomcat 8.x 이상은 GET방식일때 한글 처리가 된다.
   		/////////////////////////////////////////parameter name이 유일한 경우=>String으로 처리//////////////////////////////////////////////////////////////
   		String name=request.getParameter("name");//text
   		String age=request.getParameter("age");//passward
   		String mailing=request.getParameter("mailing");//checkbox가 하나인 경우
   		String gender=request.getParameter("gender");//radio
   		String addr=request.getParameter("addr");//hidden
   		String email=request.getParameter("email");//select
   		String greeting=request.getParameter("greeting");//textarea
   		
   		/////////////////////////////////////////parameter name이 중복된 경우=>String[]로 처리//////////////////////////////////////////////////////////////
   		String[] hobby=request.getParameterValues("hobby");
   		
   %>
   <div id="paramOutput">
   		<ul>
   			<li>-----------HTML Form Control name속성이 가지는 이름 유일-----------</li>
   			<li>이름 : <%=name %></li>
   			<li>나이: <%=age%></li>
   			<li>메일수신여부: <%=mailing%></li>
   			<li>성별: <%=gender %></li>
   			<li>주소 : <%=addr %></li>
   			<li>이메일 : <%=email %></li>
   			<li>가입인사 :<textarea style="width: 300px; height: 100px;"><%=greeting %></textarea> </li>
   			<li>가입인사 : <%=greeting.replaceAll("\n", "<br/>") %></li>
   			<li>-----------HTML Form Control name속성이 가지는 이름 중복-----------</li>
   			<li>
   				<%
   				if(hobby!=null) {//취미가있다면 
   						for(int i=0;i< hobby.length; i++) {
						//출력 내장객체: out
							out.print(hobby[i]);
							out.println("");
   						}	
   				}else{
   					out.print("선택하신 취미가 없습니다.");
   				} %>
   			</li>
   		</ul>
   </div>
   
   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>