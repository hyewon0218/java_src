<%@page import="kr.co.sist.util.ShaUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dr_vo" class="kr.co.sist.diary.vo.DiaryRemoveVO" scope="page"/>
<!-- setter필요 -->
<jsp:setProperty property="*" name="dr_vo"/>
<%
	dr_vo.setPass(ShaUtil.shaEncoding(dr_vo.getPass()));
%>
<div id="readFrm">
<% 
	DiaryDAO d_dao=DiaryDAO.getInstance();
	String img="", msg="";
	
	try {
		int cnt=d_dao.deleteEvent(dr_vo);
		if (cnt==0) {//삭제된 행이 없음 : 비번틀림,글번호조작
			img="pass_fail.png";
			msg="비밀번호를 확인해주세요.";
		}else {//성공시	
			img="success_update.png";
			msg="이벤트를 삭제하였습니다..";
		}//end if
	}catch(SQLException se) {
		se.printStackTrace();
			img="construction.jpg";
			msg="죄송합니다. 장애처리에 최선을 다하고있습니다.";
	}
%>
<img alt="" src="images/<%=img %>"><br/>
<%=msg %><br/>
<a href="#void" id="btnCloseFrm">닫기</a>
</div>
