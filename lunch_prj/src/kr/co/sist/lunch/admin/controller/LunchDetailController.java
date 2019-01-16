package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;

public class LunchDetailController extends WindowAdapter implements ActionListener{

	private LunchDetailView ldv;
	private LunchMainController lmc;
	private LunchAdminDAO la_dao;
	private String origicalImg;
	private String uploadImg;
	
	public LunchDetailController(LunchDetailView ldv,LunchMainController lmc, String originalImg) {
		this.ldv=ldv;
		this.lmc=lmc;
		la_dao=LunchAdminDAO.getInstance();
		this.origicalImg=originalImg;
	}//LunchDetailController
	
	@Override
	public void windowClosing(WindowEvent e) {
		ldv.dispose();
	}//windowClosing
	
	private void removeLunch(String code) {//도시락삭제
		
		try {
			if(la_dao.deleteLunch(code)) {//도시락 삭제
				lmc.setLunch();//도시락 리스트를 갱신한다.
				//파일을 삭제
				File file=new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+origicalImg);
				File rmFile=new File(file.getAbsolutePath());//큰파일
				File rmFile2=new File(file.getParent()+"/s_"+file.getName());//작은파일

				
				rmFile.delete();
				rmFile2.delete();
				
				JOptionPane.showMessageDialog(ldv, "도시락이 삭제되었습니다.");
			}else {
				JOptionPane.showMessageDialog(ldv, "도시락이 존재하지 않습니다.");
			}//end else	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ldv, "DB에서 문제 발생");
			e.printStackTrace();
		
		}//end catch
		
	}//removeLunch
	
	public void chgImg() {
		FileDialog fdOpen=new FileDialog(ldv, "도시락 이미지 선택" , FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path=fdOpen.getDirectory();
		String name=fdOpen.getFile();
		
		boolean flag=false;
		if(path!=null) {//????
			String[] extFlag= {"jpg","gif","jpeg","png","bmp"};
			for(String ext : extFlag) {
				if(name.toLowerCase().endsWith(ext)) {//업로드 가능 확장자
					flag=true;
				}//end if			
			}//end for
			if(flag) {
				uploadImg=path+name;
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
			}else {
//			if(uploadImg.equals("")) {
				JOptionPane.showMessageDialog(ldv, name+"은 이미지가 아닙니다.");			
			}
		}//end if
		
	}//chgImg
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//2019-01-16 작업 종료 !!! 내일은 도시락을 수정하는 부분부터 !!!!!
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean modifyLunch() {
		boolean flag=false;
		
		
		return flag;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ldv.getJbUpdate()) {//수정
			
		}
		if(ae.getSource()==ldv.getJbDelete()) {//삭제
			StringBuilder deleteMsg=new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(")
			.append(ldv.getJtfLunchCode().getText()).append(")을(를) 삭제하시겠습니까?");
			
			switch(JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())) {
			case JOptionPane.OK_OPTION:
//				System.out.println(ldv.getJlLunchImg().getIcon());
				removeLunch(ldv.getJtfLunchCode().getText());
			}//end swich
		}//end if(주의!)
		if(ae.getSource()==ldv.getJbEnd()) {//종료
			ldv.dispose();
		}//end if
		if(ae.getSource()==ldv.getJbImg()) {//이미지변경
			chgImg();
		}//end if
	}

}
