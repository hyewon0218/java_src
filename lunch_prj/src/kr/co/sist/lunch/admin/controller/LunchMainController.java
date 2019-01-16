package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;

public class LunchMainController extends WindowAdapter implements ActionListener, MouseListener{

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	
	public static final int DBL_CLICK=2;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv=lmv;
		la_dao=LunchAdminDAO.getInstance();
		//도시락 목록을 설정한다.
		setLunch();
	}//LunchMainController
	
	/**
	 * JTable에 DB에서 조회한 도시락 정보를 보여준다. 
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch=lmv.getDtmLunch();
		dtmLunch.setRowCount(0);
		
		try {
			//DB에서 도시락 정보를 조회 
			List<LunchVO> listLunch=la_dao.selectLunch();
			//JTable에 조회한 정보 출력
			
			LunchVO lv=null;
			String imgPath="C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";//작은이미지로
			
			Object[] rowData=null;
			for(int i=0; i<listLunch.size(); i++) {
				lv=listLunch.get(i);
				//DTM에 데이터를 추가하기 위한 일차원 배열(Vector)를 생성하고 데이터를 추가
				rowData=new Object[5];
				rowData[0]=new Integer(i+1);//안해줘도 오토박싱됨
				rowData[1]=lv.getLunchCode();
				rowData[2]=new ImageIcon(imgPath+lv.getImg());
				rowData[3]=lv.getLunchName();
				rowData[4]=new Integer(lv.getPrice());
				
				//DTM에 추가
				dtmLunch.addRow(rowData);
			}//end for
			
			if(listLunch.isEmpty()) {//입력된 도시락이 없을 때 
				JOptionPane.showMessageDialog(lmv, "입력된 제품이 없습니다.");
			}//end if
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중 문제가 발생...");
			e.printStackTrace();
			
		}//end catch
		
	}//setLunch

	@Override
	public void windowClosing(WindowEvent we) {
		lmv.dispose();
	}//windowClosing
	
	@Override
	public void mouseClicked(MouseEvent me) {
		switch(me.getClickCount()) {
		case DBL_CLICK: ;//더블클릭 (2->상수로)
		 	if(me.getSource()==lmv.getJtLunch()) {//도시락테이블에서 더블클릭이 되면 
		 		//도시락 코드로 DB Table을 검색을 하여 상세정보를 전달한다.
		 		JTable jt=lmv.getJtLunch();
		 		try {
					LunchDetailVO ldvo=la_dao.selectDtailLunch((String)jt.getValueAt(jt.getSelectedRow(),1));
					new LunchDetailView(lmv, ldvo, this);
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(lmv, "DB에서 문제가 발생했습니다.");
					se.printStackTrace();
				}
		 	}//end if
		 	if(me.getSource()==lmv.getJtOrder()) {//주문테이블에서 더블클릭 
		 		
		 	}//end if
		}	//end
		
	}//mouseClicked
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == lmv.getJbtAddLunch()) {//도시락 추가 버튼
			new LunchAddView(lmv,this);
		}
		if(ae.getSource() == lmv.getJcbMonch()) {
			setDay();
		}
	}//actionPerformed
	
	/**
	 * 월이 선택되면 해당 년의 해당 월의 마지막 날을 설정 
	 */
	private void setDay() {
		int selYear=((Integer)lmv.getJcbYear().getSelectedItem()).intValue();//
		int selMonth=((Integer)lmv.getJcbMonch().getSelectedItem()).intValue();
		

		
		//마지막 날 얻기
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth-1);
		
		int lastDay=cal.getActualMaximum(Calendar.DATE);
		int nowDay=cal.get(Calendar.DAY_OF_MONTH);
		
		lmv.getCbmDay().removeAllElements();	//모델을 초기화하고
		for(int day=1; day < lastDay+1; day++ ) {
			lmv.getCbmDay().addElement(day);//마지막 날 설정
		}//end for
		lmv.getCbmDay().setSelectedItem(new Integer(nowDay));//오늘을 선택한다.
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
}
