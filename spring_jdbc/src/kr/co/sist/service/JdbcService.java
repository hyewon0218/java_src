package kr.co.sist.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.dao.JdbcDAO;
import kr.co.sist.domain.Member;
import kr.co.sist.domain.MemberDetail;
import kr.co.sist.vo.MemberVO;

@Component
public class JdbcService {
	@Autowired(required=false)
	private JdbcDAO jdao;
	
	public boolean fileUploadProcess(HttpServletRequest request) throws IOException {
		boolean flag=false;
		
		MultipartRequest mr=new MultipartRequest(request, "C:/dev/workspace/spring_jdbc/WebContent/upload",
																1024*1024*10, "UTF-8",new DefaultFileRenamePolicy());
		MemberVO mv=new MemberVO(mr.getParameter("name"), mr.getFilesystemName("upfile"), 
													mr.getParameter("loc"), mr.getParameter("highschool"));
		
		try {
		jdao.insertMemer(mv);
		request.setAttribute("inputData", mv);
		flag=true;
		}catch(DataAccessException das) {
			das.printStackTrace();
		}
		return flag;
	}//fileUploadProcess
	
	public List<Member> searchAllMember() {
		List<Member> list=null;
		
		try {
		list=jdao.selectAllMember();
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		return list;
	}//searchAllMember
	
	//번호에 따른 회원을 조회 
	public MemberDetail searchOneMember(int num) {
		MemberDetail md=null;
		try {
		md=jdao.selectOneMember(num);
		}catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		return md;
	}//searchOneMember
	
}//class





















