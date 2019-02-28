package day0228;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UseWebParameterValues extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//접속자에게 전해줄 형식 접속자웹므라우저실행 mime-type (jsp에서도..)
		PrintWriter out=response.getWriter();
		
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
	      //HTML Form Control 의 값 받기
	      //이름이 유일<input type="text">
	      String name=request.getParameter("name");
	      	
	      //이름이 중복 <input type="checkbox">
	      String[] hobby=request.getParameterValues("hobby");
	      
	      out.print("<strong>");
	      out.print(name);
	      out.print("</strong>님께서 입력하신 취미는 아래와 같습니다.<br/>");
	      
	      out.println("\t<ul>");
	      try {//체크박스가 선택된 것이 없다면 hobby 배열에는 null이 할당되므로
	    	  //length 키워드를 사용하게 되면 NullPointerException이 발생하게 된다.
	      for(int i=0; i<hobby.length; i++) {
	    	  out.println("\t\\<li>");
	    	  out.println(hobby[i]);
	    	  out.println("</li>");
	      }//end for
	      }catch(NullPointerException npe) {
	    	  out.println("<li>취미없음</li>");
	      }//end catch
	      out.println("\t</ul>");
	      out.println("\t<a href='day0228/test_param_value.html'>뒤로</a>");
	      
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
		
	}//doPost

}//class
