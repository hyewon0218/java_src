package day0227;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.util.HangulConv;

/**
 * HTML Form Control 값 받기
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseWebParameter extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v20190130.css\"/>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
	      out.write("#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
	      out.write("\t\t\tposition: relative; }\r\n");
	      out.write("#headerTitle{ font-family: HY견고딕, 고딕; font-size: 30px; font-weight: bold;text-align: center;\r\n");
	      out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
	      out.write("#container{  width:800px; height: 600px; }\r\n");
	      out.write("#footer{  width:800px; height: 120px; }\r\n");
	      out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
	      out.write("</style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<div\tid=\"wrap\">\r\n");
	      out.write("\t<div id=\"header\">\r\n");
	      out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"container\">\r\n");
	      
	      //parameter 값 받기 : Tomcat 8.0부터는 GET방식의 parameter는 한글이 깨지지 않는다.
	      String name=request.getParameter("name");//text
	      String age=request.getParameter("age");//password
	      String mailing=request.getParameter("mailing");//checkbox
	      String gender=request.getParameter("gender");//radio
	      String addr=request.getParameter("addr");//hidden
	      String email=request.getParameter("email");//select
	      String greeting=request.getParameter("greeting");//textarea
	      
	      out.println("\t<div>");
	      out.println("\t<h2>get방식으로 요청한 파라메터 값 처리</h2>");
	      out.println("\t<div>");
	      out.println("\t<ul>");

	      out.print("\t<li> 이름 : <strong>");
	    //out.print(HangulConv.toUTF(name)); Tomcat 8.x 이하일 때는 한글처리를 해야한다.
	      out.print(name); 
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 나이 : <strong>");
	      out.print(age);
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 메일링 여부 : <strong>");
	      out.print(mailing);//value속성이 없는 checkbox는 체크되면 on, 체크되지 않으면 null
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 성별 : <strong>");
	    //out.print(HangulConv.toUTF(gender));
	      out.print(gender);
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 주소 : <strong>");
	      //out.print(HangulConv.toUTF(addr));
	      out.print(addr);
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 이메일 : <strong>");
	      out.print(email);
	      out.print("</strong></li>");

	      out.print("\t<li> 가입인사 : <strong>");
	      //out.print(HangulConv.toUTF(greeting));
	      out.print(greeting);
	      out.print("</strong></li>");
	      
	      out.println("\t</ul>");
	      out.println("\t</div>");
	      out.println("\t<a href='day0227/test_param.html'>뒤로</a>");
	      out.println("\t</div>");
	      
	      out.write("\t\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"footer\">\r\n");
	      out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</div>\r\n");
	      out.write("\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post방식의 한글 처리(Tomcat 모든 버전에 동일하게 적용)
		request.setCharacterEncoding("UTF-8");

		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		
		System.out.println("post");
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v20190130.css\"/>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
	      out.write("#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
	      out.write("\t\t\tposition: relative; }\r\n");
	      out.write("#headerTitle{ font-family: HY견고딕, 고딕; font-size: 30px; font-weight: bold;text-align: center;\r\n");
	      out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
	      out.write("#container{  width:800px; height: 600px; }\r\n");
	      out.write("#footer{  width:800px; height: 120px; }\r\n");
	      out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
	      out.write("</style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<div\tid=\"wrap\">\r\n");
	      out.write("\t<div id=\"header\">\r\n");
	      out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"container\">\r\n");
	      
	      
	      //parameter 값 받기 : Tomcat 8.0부터는 GET방식의 parameter는 한글이 깨지지 않는다.
	      String name=request.getParameter("name");//text
	      String age=request.getParameter("age");//password
	      String mailing=request.getParameter("mailing");//checkbox
	      String gender=request.getParameter("gender");//radio
	      String addr=request.getParameter("addr");//hidden
	      String email=request.getParameter("email");//select
	      String greeting=request.getParameter("greeting");//textarea
	      
	      out.println("\t<div>");
	      out.println("\t<h2 style='color:#0000FF'>post방식으로 요청한 파라메터 값 처리</h2>");
	      out.println("\t<div>");
	      out.println("\t<ul>");

	      out.print("\t<li> 이름 : <strong>");
	      out.print(name);
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 나이 : <strong>");
	      out.print(age);
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 메일링 여부 : <strong>");
	      out.print(mailing);//value속성이 없는 checkbox는 체크되면 on, 체크되지 않으면 null
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 성별 : <strong>");
	      out.print(gender);
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 주소 : <strong>");
	      out.print(addr);
	      out.print("</strong></li>");
	      
	      out.print("\t<li> 이메일 : <strong>");
	      out.print(email);
	      out.print("</strong></li>");

	      out.print("\t<li> 가입인사 : <strong>");
	      out.print(greeting);
	      out.print("</strong></li>");
	      
	      out.println("\t</ul>");
	      out.println("\t</div>");
	      out.println("\t<a href='day0227/test_param.html'>뒤로</a>");
	      out.println("\t</div>");
	      
	      out.write("\t\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"footer\">\r\n");
	      out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</div>\r\n");
	      out.write("\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
	}//doPost

}//class
