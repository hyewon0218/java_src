package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ChainController {
	@RequestMapping(value="/chain/chain_a.do",method=GET)
	public String chainA(Model model) {
		
		String[] lunch= {"버거킹","KFC","맥날","롯데리아"};
		model.addAttribute("lunch",lunch);
		return "forward:/chain/chain_b.do";
		//return에 forward나 redirect가 붙어있으면 ViewResolver를 거치지 않고 
		//정의된 URL을 직접 호출하게 된다. 
	}
	@RequestMapping(value="/chain/chain_b.do",method=GET)
	public String chainB() {//직접호출될 수도 있고 , A를 거쳐서 호출될 수도 있다. 
		return "chain/chain_b_result";
	}
}
