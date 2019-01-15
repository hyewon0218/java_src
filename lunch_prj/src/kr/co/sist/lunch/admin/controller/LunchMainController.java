package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JComboBox;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchMainView;

public class LunchMainController extends WindowAdapter implements ActionListener, MouseListener{

	private LunchMainView lmv;
	private LunchAdminDAO lm_dao;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv=lmv;
		lm_dao=LunchAdminDAO.getInstance();
		
	}//LunchMainController

	@Override
	public void windowClosing(WindowEvent we) {
		lmv.dispose();
	}//windowClosing
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}//mouseClicked
	
	@Override
	public void actionPerformed(ActionEvent ae) {
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
