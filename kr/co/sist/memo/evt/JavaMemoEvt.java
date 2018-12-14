package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.Help;
import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {
	
	private JavaMemo jm;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm=jm;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//miNew, miOpen, miSave, miNewSave
		//miEnd, miFormat, miHelp
		//새글 메뉴아이템에서 이벤트가 발생했을 때 
		if(ae.getSource()==jm.getMiNew()) {
			newMemo();
		}
		//열기 메뉴아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiOpen()) {
			openMemo();
		}
		//저장 메뉴 아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiSave()) {
			saveMemo();
		}
		//다른이름으로 저장 메뉴 아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiNewSave()) {
			newSaveMemo();
		}
		//종료 메뉴 아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiEnd()) {
			jm.dispose();
		}
		//서식 메뉴아이템에서 아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiFormat()) {
			formatDialog();
		}
		//도움말 메뉴아이템에서 아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiHelp()) {
			helpDialog();
		}
		
		
	}//actionPerformed
	/**
	 * 새글 : TextArea 초기화한다.
	 */
	public void newMemo() {
		jm.getTaNote().getText();//가져온다음에
		jm.getTaNote().setText("");//초기화
		
		
		jm.setTitle("메모장 - 새글");
	}

	/**
	 * txt파일 열기 
	 */
	public void openMemo() {
		FileDialog fdOpen=new FileDialog(jm, "문서열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String filePath= fdOpen.getDirectory();
		String fileName=fdOpen.getFile();
		
		if(filePath !=null) {//선택한 파일이 존재
			//파일의 경로와 이름을 Frame의 TitleBar에 설정
			jm.setTitle("메모장 - 열기 "+filePath+fileName);
		}
	}
	/**
	 * 작성한 메모를 저장 - 기존의 파일명을 그대로 저장하는 파일명에 반영
	 */
	public void saveMemo() {
		newSaveMemo();
	}
	/**
	 * 파일명을 입력받아 새이름으로 저장
	 */
	public void newSaveMemo() {
		FileDialog fdSave=new FileDialog(jm, "문서저장", FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String filePath= fdSave.getDirectory();
		String fileName=fdSave.getFile();
		
		if(filePath !=null) {//선택한 파일이 존재
			//파일의 경로와 이름을 Frame의 TitleBar에 설정
			jm.setTitle("메모장- 저장 "+filePath+fileName);
		}
	}
	
	/**
	 * 글꼴을 설정하는 다이얼로그를 실행하는 일
	 */
	public void formatDialog() {
		new MemoFormat(jm);
	}
	
	/**
	 * 메모장 정보를 제공하는 다이얼로그를 실행
	 */
	public void helpDialog() {
		new Help(jm);
	}
	
	
	
}//class
