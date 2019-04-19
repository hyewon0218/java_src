package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.Diary;
import kr.co.sist.domain.DiaryDetail;
import kr.co.sist.domain.DiaryReply;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

/**
 * ���۹�ȣ�� ����ȣ ������ �Խù��� ��ȸ�ϱ� ���� ��� �۾� ���� 
 * @author SIST
 */
public class DiaryService {
	private MyBatisDAO mb_dao;
	
	public DiaryService() {
		mb_dao=MyBatisDAO.getInstance();
	}
	
	/**
	 * �� �Խù��� �� ���
	 * @return
	 */
	public int totalCount() {
		int cnt=0;
		cnt=mb_dao.seletTotalCount();
		
		return cnt;
	}
	

	
	/**
	 * ���������� ������ �Խù��� ��
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		
		return pageScale;
	}//pageScale
	
	/**
	 * ��� �Խù��� �����ֱ� ���� ������ �� 
	 * @param totalCount
	 * @return
	 */
	public int totalPage(int totalCount) {
		int totalPage=totalCount/pageScale();
   		
   		if(totalCount%pageScale()!=0) {
   			totalPage++;
   		}
		return totalPage;
	}
	
	/**
	 * ������ �ε��� ����Ʈ���� ��ȸ�� ���� ��ȣ 
	 * @param currentPage
	 * @return
	 */
	public int startNum(int currentPage) {
   		int startNum=1;
   				startNum=currentPage*pageScale()-pageScale()+1;
		return startNum;
	}
	/**
	 * ������ �ε�������Ʈ���� ��ȸ�� �� ��ȣ
	 * @param startNum
	 * @return
	 */
	public int endNum(int startNum) {
		int endNum=startNum+pageScale()-1;
		return endNum;
	}//endNum
	
	public List<Diary> searchDiaryList(DiaryVO dv) {
		List<Diary> list=null;
		list=mb_dao.selectList(dv);
		
		//  ���� ������ 24�ڱ����� �����ش�.
		Diary dl_vo=null;
		String subject="";
		for(int i=0; i <list.size(); i++) {
			dl_vo=list.get(i);
			subject=dl_vo.getSubject();
			if(subject.length()>25) {
				subject=subject.substring(0, 24)+"...";
				dl_vo.setSubject(subject);
			}
		}
		
		return list;
	}//searchDiaryList

	// ���� �Խ����� ������ �ε��� ����
	/**
	 * �ε��� ����Ʈ [<< ].... [1][2][3]....[ >> ]
	 * @param current_page
	 * @param total_page
	 * @param list_url
	 * @return
	 */
	public String indexList(int current_page, int total_page, String list_url) {
	int pagenumber; // ȭ�鿡 ������ ������ �ε��� ��
	int startpage; // ȭ�鿡 ������ ���������� ��ȣ
	int endpage; // ȭ�鿡 ������ ������������ ��ȣ
	int curpage; // �̵��ϰ��� �ϴ� ������ ��ȣ

	String strList=""; // ���ϵ� ������ �ε��� ����Ʈ

	pagenumber = 10; // �� ȭ���� ������ �ε��� �� 

	// ���� ��������ȣ ���ϱ�
	startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

	// ������ ��������ȣ ���ϱ�
	endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

	// �� ������ ���� ���� ������������ ��ȣ���� ������� 

	// �� ������ ���� ������������ ��ȣ�� ��


	if (total_page <= endpage){
		endpage = total_page;
	}//end if

	// ù��° ������ �ε��� ȭ���� �ƴѰ��
	if ( current_page > pagenumber) {
		curpage = startpage - 1; // ���������� ��ȣ���� 1 ���� �������� �̵�
		strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+">&lt;&lt; </a> ]";
	}else{
		strList = strList + "[<<]";
	}

	strList = strList + " ... ";

	// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
	curpage = startpage;

	while (curpage <= endpage){
		if (curpage == current_page) {
			strList = strList + "["+current_page+"]";
		} else {
			strList = strList +"[ <a href="+list_url+"?currentPage="+curpage+">"+curpage+" </a> ]";
		}//end else

		curpage++;
	}//end while

	strList = strList + " ... ";

	// �ڿ� �������� �� �ִ°��
	if ( total_page > endpage) {
		curpage = endpage + 1; 
		strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+"> &gt;&gt; </a> ]";
	}else{
		strList = strList + "[>>]";
	}//end else

	return strList;
	}//indexList
	
	public DiaryDetail searchBbs(int num) {
		DiaryDetail dd=mb_dao.selectDiaryDetail(num);
		return dd;
		
	}//searchBbs
	
	public List<DiaryReply> searchReplyDiaryList(int num) {
		List<DiaryReply> list=null;
		list=mb_dao.selecReplytList(num);
		
		return list;
	}//searchDiaryList
	
	public JSONObject writeReply(ReplyVO r_vo) {
		JSONObject json=new JSONObject();
		int cnt=mb_dao.insertReply(r_vo);
		
		json.put("result", cnt==1);
		
		return json;
	}
}