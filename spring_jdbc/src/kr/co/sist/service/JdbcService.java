package kr.co.sist.service;

import java.io.File;
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
import kr.co.sist.domain.MemberImg;
import kr.co.sist.vo.MemberUpdateVO;
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
	
	public boolean updateMember(MemberUpdateVO muv) {
		boolean flag=false;
		
		try {
		flag=jdao.updateMember(muv)==1;
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		return flag;
	}
	
	public boolean removeMember(int num) {
		boolean flag=false;
		
		try {
			MemberImg mi=jdao.deleteMember(num);
			flag=mi.getCnt()==1; 
			if(flag) { //삭제된 레코드가 존재하면 
				//파일을 삭제
				if(!"default.png".equals(mi.getImg())) {
					File file=new File("C:/dev/workspace/spring_jdbc/WebContent/upload"+mi.getImg());
					file.delete();
				}
			}
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		return flag;
	}
	
}//class





















