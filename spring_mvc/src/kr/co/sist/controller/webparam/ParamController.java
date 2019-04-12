package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sis.vo.ParamVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
	//GET방식으로 요청을 처리할 때 URL만 넣어도 된다.
	//value="URL", method=RequestMethod.GET
	@RequestMapping("/request_form.do")
	public String requestForm() {
		return "param/request_form";
	}
	@RequestMapping(value="/use_request_process.do",method=GET)
	//httpservletrequest를 사용한 파라메터 처리 :권장x
	public String requestFormProcess(HttpServletRequest request) {
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String[] lang=request.getParameterValues("lang");
		
		System.out.println(name+" "+age+" "+Arrays.toString(lang));
		request.setAttribute("lang", lang);
		
		return "param/request_process";
	}//requestFormProcess
	
	//VO를 사용한 Parameter 처리
	@RequestMapping(value="/use_vo_process.do",method=GET)
	public String voProcess(ParamVO pv) {
		System.out.println("--------"+pv);
		return "param/vo_process";
	}
}
