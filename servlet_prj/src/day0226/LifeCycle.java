package day0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//1. HttpServlet상속
public class LifeCycle extends HttpServlet {
	//생명주기 method
	public void init() {
		System.out.println("==========>init method 최초 접속자에 의해 1번 호출(생성자역할)");
	}//init
	
	public void destroy() {
		System.out.println("==========>Web Container가 종료될 때 객체가 사라지면서 1번 호출");
	}//destroy

	//2. 응답방식에 대한 처리 method  Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//3. 응답방식설정 (MIME-TYPE 설정)
		response.setContentType("text/html;charset=UTF-8");
		//4. 출력스트림얻기
		PrintWriter out=response.getWriter();
		//5. 응답 내용 생성
		out.println("<strong>방문자정보</strong><br/>");
		out.println("<strong>접속자 ip : </strong>");
		out.println(request.getRemoteAddr());
		out.println("에서 접속하셨습니다.");
		
		System.out.println("---------> service, doGet, doPost 모든 접속자에게 호출. 여러번 호출 : "+request.getRemoteAddr());
		
	}//doGet

}//class
