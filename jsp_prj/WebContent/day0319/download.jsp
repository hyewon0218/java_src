<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 응답방식 설정
	response.setContentType("application/octet-stream");
	//2.응답헤더설정
	String data=request.getParameter("file_name");
	if(data==null ||"".equals(data)) {
		response.sendRedirect("file_list.jsp");
		return;
	}
	
	response.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(data,"UTF-8"));
	//3. file stream을 사용하여 읽어들일 파일과 연결
	File file=new File("C:/dev/workspace/jsp_prj/WebContent/upload/"+data);
	
	FileInputStream fis=null;
	OutputStream os=null;
	
	if(file.exists()) {//파일이 존재하는지
		try{	
		fis=new FileInputStream(file);
		byte[] readFileArr=new byte[(int)file.length()];//파일의 내용을 저장하기 위한 배열
		int idx=0;
		int read=0;
		while((read=fis.read())!=-1) {//읽어들인 내용이 있을 때까지
			readFileArr[idx]=(byte)read;
			idx++;
		}
		//출력스트림 초기화
		out.clear();
		out=pageContext.pushBody();
		
		os=response.getOutputStream();
		os.write(readFileArr);
		os.flush();
		}finally{
			if(fis!=null) {fis.close();}
			if(os!=null) {os.close();}
		}//
	}//end if
%>