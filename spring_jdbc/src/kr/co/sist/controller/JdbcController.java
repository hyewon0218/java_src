package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;

import kr.co.sist.service.JdbcService;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
@Controller
public class JdbcController {
	@Autowired
	private JdbcService js;
	
	@RequestMapping(value="/index.do", method= {GET,POST})
	public String main() {
		return "index";
	}//end main
	
	@RequestMapping(value="/add_form.do", method=GET)
	public String memberUploadForm() {
		return "member/add_form";
	}
	@RequestMapping(value="/addmember_process.do",method=POST)
	public String uploadProcess(HttpServletRequest request) {
		
		String moveURL="redirect:err/err.html";
		
		try {
			if(js.fileUploadProcess(request)) {
				moveURL="member/upload_success";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return moveURL;
	}
}//class
