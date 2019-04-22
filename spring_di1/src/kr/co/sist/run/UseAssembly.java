package kr.co.sist.run;

import java.util.List;

import kr.co.sist.assembly.Assembly;
import kr.co.sist.service.Service;
import kr.co.sist.vo.EmpVo;

/**
 * 조립자 클래스를 사용하여 서비스 객체를 얻고 서비스를 사용하는 일 
 * @author SIST
 *
 */
public class UseAssembly {

	public static void main(String[] args) {
		Assembly as=new Assembly();
		Service service=as.getBean();
		service.addEmp(new EmpVo(1234, "테스트"));
		System.out.println("----------------------------");
		List<EmpVo> list=service.searchEmp();
		for(EmpVo emp : list) {
			System.out.println(emp.getEmpno()+" / "+emp.getEname());
		}
	}

}
