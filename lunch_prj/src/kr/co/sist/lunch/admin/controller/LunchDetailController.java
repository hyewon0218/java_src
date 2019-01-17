package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;

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
		uploadImg="";//null로비교하지않기위해 
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
	
	/**
	 * 도시락 코드, 도시락명, 이미지, 가격, 특장점을 입력받아 코드에 해당하는 도시락의 정보를 변경.
	 * @return
	 */
	private void modifyLunch() {
		boolean flag=false;
		//유효성 검증 : 도시락명, 가격, 특장점이 ""가 아닐 때, 가격은 숫자인지,
		//이미지가 변경되었다면 이미지가 s_가 붙은 이미지인가 존재하는 이미지인지
		JTextField tfName=ldv.getJtfLunchName();
		JTextField tfPrice=ldv.getJtfLunchPrice();
		JTextArea taSpec=ldv.getJtaLunchSpec();
		
		if(tfName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락명을 입력해주세요.");
			tfName.setText("");
			tfName.requestFocus();
			return;
		}//end if
		if(tfPrice.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락 가격을 입력해주세요.");
			tfPrice.setText("");
			tfPrice.requestFocus();
			return;
		}//end if
		if(taSpec.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락 특장점을 입력해주세요.");
			taSpec.setText("");
			taSpec.requestFocus();
			return;
		}//end if
		
		int price=0;
		try {
			price=Integer.parseInt(tfPrice.getText().trim());
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(ldv, "도시락 가격은 숫자만 입력 가능");
			return;
		}//end catch
		
		//선택한 이미지와 동일한 이름의 이미지가 s_를 가지지 않은 경우 이미지 작업이 되어있지 않은 경우.
		//uploadImg를 사용
		if(!uploadImg.equals("")) {//이미지 변경을 수행한 경우
			File tempFile=new File(uploadImg);//큰 이미지
			File smallFile=new File(tempFile.getParent()+"/s_"+tempFile.getName());//작은 이미지?????????
			if(!smallFile.exists()) {
				JOptionPane.showMessageDialog(ldv, "선택하신 파일은 작은 이미지가 존재하지 않습니다.");
				uploadImg="";//초기화
			return;
			}//end if
		}//end if
		
		StringBuilder updateMsg=new  StringBuilder();
		updateMsg.append("수정정보 \n").append("도시락 명 : ").append(tfName.getText()).append("\n")
		.append("가격 : ").append(tfPrice.getText()).append("\n").append("특장점 : ").append(taSpec.getText())
		.append("\n").append("위의 정보로 도시락의 정보가 변경됩니다. 변경하시겠습니까? ");
		
		switch (JOptionPane.showConfirmDialog(ldv, updateMsg.toString())) {
		case JOptionPane.OK_OPTION:
			//변경된 값으로 VO를 생성하고 
			File file=new File(uploadImg);
			LunchUpdateVO luvo
				=new LunchUpdateVO(ldv.getJtfLunchCode().getText(), tfName.getText().trim(), file.getName(), taSpec.getText(), price);
			try {
				if(la_dao.updateLunch(luvo)) {//DB Table에서 update를 수행 
					JOptionPane.showMessageDialog(ldv, "도시락 정보가 변경되었습니다.");
					if(!uploadImg.equals("")) {//변경한 이미지가 존재하는 경우
						try {
							//이전 이미지를 삭제한 후
							File original=new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+origicalImg);
							File small=new File(original.getParent()+"/s_"+original.getName());
							original.delete();
							small.delete();
							
							
							uploadImg(file);//변경한 이미지를 지정한 폴더에 업로드한다.
						} catch (IOException e) {
							e.printStackTrace();
						}//end catch
					}//end if
					lmc.setLunch();//부모창의 도시락 리스트를 변경한다.
					}else {
						JOptionPane.showMessageDialog(ldv, "도시락 정보가 변경되지 않았습니다.");
					}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(ldv, "DB에서 문제 발생");
				e.printStackTrace();
			}//end else
					
			break;
		}//end switch
		
	}//modifyLunch
	
	private void uploadImg(File file) throws IOException {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
		//큰 이미지 업로드
		fis=new FileInputStream(file);
		byte[] readData=new byte[512];
		
		int len=0;
		String uploadPath="C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";
		fos=new FileOutputStream(uploadPath+file.getName());
		
		while((len=fis.read(readData))!=-1) {//큰이미지 올리기
			fos.write(readData,0,len);
			fos.flush();
		}
		fis.close();
		fos.close();
		
		//작은 이미지 업로드
		fis=new FileInputStream(file.getParent()+"/s_"+file.getName());
		
		len=0;
		fos=new FileOutputStream(uploadPath+"s_"+file.getName());
		
		while((len=fis.read(readData))!=-1) {//큰이미지 올리기
			fos.write(readData,0,len);
			fos.flush();
		}
	
		}finally {
			if(fos!=null) {fos.close();}
			if(fis!=null) {fis.close();}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ldv.getJbUpdate()) {//수정
			modifyLunch();
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








