package day0228;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ForwardA extends HttpServlet {
	//데이터처리코드에 집중(화면디자인x)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//처리된 데이터
		String[] nameArr= {"노진경","박영민","김정윤","최지우","김희철","박소영","이지수"};
		
		List<String> list=new ArrayList<String>();
		list.add("PC방 관리 프로그램");
		list.add("영화관 예매 프로그램");
		list.add("개발자 구인구직 프로그램");
		
		
		//1.처리된 데이터를 이동한 페이지로 보내기 위해 요청 객체에 속성으로 설정한다.
		request.setAttribute("member", nameArr);
		request.setAttribute("project_list", list);
		//2. 이동할 페이지 설정
		RequestDispatcher rd=request.getRequestDispatcher("forward_b");
		//3. 이동
		rd.forward(request, response);//forward호출된순간부터브라우저에출력안됨(view에대한코드x)
		
	}//doGet

}//class





















