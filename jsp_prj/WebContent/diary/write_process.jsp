<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.ShaUtil"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="d_vo"  class="kr.co.sist.diary.vo.DiaryVO"  scope="page"/>
<jsp:setProperty property="*" name="d_vo"/>
<jsp:setProperty property="ip" value="<%=request.getRemoteAddr() %>" name="d_vo"/>
<script type="text/javascript">
$(function(){
<%
d_vo.setPass(ShaUtil.shaEncoding(d_vo.getPass()));

Boolean flag=(Boolean)session.getAttribute("writeFlag");
if(flag!=null && !flag) {//값이있고 true
	
DiaryDAO d_dao=DiaryDAO.getInstance();
try{
	d_dao.insertEvent(d_vo);
	session.setAttribute("writeFlag", true);
	%>
	alert("이벤트가 정상적으로 등록되었습니다.");
	<%
}catch(SQLException se) {
	%>
	alert("이벤트가 정상적으로 등록되지 않았습니다.");
	<%
	se.printStackTrace();	
}//end catch
}//end if
%>
});//load
</script>