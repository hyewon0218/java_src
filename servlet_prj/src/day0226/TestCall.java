package day0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//1. HttpServlet 상속
public class TestCall extends HttpServlet {
	//2. 요청방식을 처리할 수 있는 method Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3. 응다방식 설정
		response.setContentType("text/html;charset=UTF-8");
		//4. 출력스트림 얻기
		PrintWriter out=response.getWriter();
		//출력내용 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>GET 방식의 요청처리</title>");
		out.println("<style type='text/css'>");
		out.println("span {font-weight:bold; font-size:20px; color:#0000FF}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<span>GET방식의 요청처리</span><br/>");
		out.println("<a href='day0226/call_servlet.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3. 응다방식 설정
		response.setContentType("text/html;charset=UTF-8");
		//4. 출력스트림 얻기
		PrintWriter out=response.getWriter();
		//출력내용 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Post 방식의 요청처리</title>");
		out.println("<style type='text/css'>");
		out.println("span {font-weight:bold; font-size:15px; color:#FF0000}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<span>Post방식의 요청처리</span><br/>");
		out.println("<a href='javascript:history.back();'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
		
	}//doPost

}
