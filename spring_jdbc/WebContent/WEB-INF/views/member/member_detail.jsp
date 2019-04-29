<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_jdbc/common/css/main_v20190130.css">
<style type="text/css">
#wrap{ margin:0px auto; width: 800px; height:860px;}
#header{ width: 800px; height:140px;background: #FFFFFF url(http://localhost:8080/spring_jdbc/common/images/header_bg.png); 
            position:relative;}
#headerTitle{ font-family: HY견고딕,고딕; font-size: 35px; font-weight: bold; text-align: center; 
               position: absolute; top:40px; left:290px}
#container{ width: 800px; min-height:600px; }
#footer{ width: 800px; height:120px;}
#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function (){
		$("#btnUpdate").click(function() {
			if($("#btnUpdate").val()=="수정") {
			var updateView=
				"이름 : <input type='text' name='name' value='"+$("#name").text()+"'/><br/>"
				+"출신고 : <input type='text' name='highschool' value='"+$("#highschool").text()+"'/><br/>"
				+"위치 : <input type='text' name='loc' value='"+$("#loc").text()+"'/>";
				
				$("#btnUpdate").val("수정실행");
				
				$("#view").html(updateView);
				}else{
					//유효성 검증 코드 작성
				document.frm.action="update_member.do";
					$("#frm").submit();
				}
		});//click
		$("#btnDelete").click(function() {
			if(confirm("[ "+$("#name").text()+" ] 회원을 삭제하시겠습니까?")) {
				document.frm.action="delete_member.do";
				$("#frm").submit();//=document.frm.submit();
			}
		});
	});//ready
</script>
</head>
<body>
<div id="wrap">
   <div id="header">
         <div id="headerTitle"> SIST Class4</div>
          <div style="padding-top: 100px;">
         <c:import url="/common/jsp/main_menu.jsp"/>
         </div>
         </div>
   <div id="container">
   		<a href="add_form.do">정보추가</a>
		<a href="search_member.do">정보조회</a>
	<div>
		<c:choose>
		<c:when test="${empty memberData }">
			조회된 회원이 존재하지 않습니다.
		</c:when>
		<c:otherwise>
		<form id='frm' name='frm' action='update_member.do' method='post'>
		<input type="hidden" name="num" value="${param.num }">
		<div id="view">
			<ul>
				<li>이름 : <span id="name"><c:out value="${memberData.name }" /></span></li>
				<li>출신고 :<span id="highschool"><c:out value="${memberData.highschool}"/></span></li>
				<li>위치 :<span id="loc"> <c:out value="${memberData.loc}"/></span></li>
			</ul>
			</div>
			<div>
				<input type="button" value="수정" class="btn" id="btnUpdate">
				<input type="button" value="삭제" class="btn" id="btnDelete">
			</div>
			</form>
		</c:otherwise>
		
		</c:choose>
	</div>
 </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all reserved. class 4 </div>
   </div>
</div>

</body>
</html>























