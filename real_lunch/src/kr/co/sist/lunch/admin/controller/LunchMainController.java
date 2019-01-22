package kr.co.sist.lunch.admin.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.FlagVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

public class LunchMainController extends WindowAdapter 
	implements ActionListener, MouseListener, Runnable{

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;

	public static final int DBL_CLICK=2;
	
	private String orderNum;
	private String lunchName;
	private int selectedRow;
	
	private Thread threadOrdering;
	/////////////////////// 요청사항추가////////////////////////////////////////////
	private Map<String,FlagVO> map;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv=lmv;
		la_dao=LunchAdminDAO.getInstance();
		//도시락 목록을 설정한다.
		setLunch();
		orderNum="";
		map=new HashMap<String,FlagVO>();
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
			//JTable에 조회한 정보를 출력.
			
			LunchVO lv=null;
			String imgPath="C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";
			
			Object[] rowData=null;
			for(int i= 0 ; i < listLunch.size() ; i++) {
				lv=listLunch.get(i);
				//DTM에 데이터를 추가하기 위한 일차원배열(Vector)을 생성하고 데이터를 추가
				rowData=new Object[5];
				rowData[0]=new Integer( i+1 );
				rowData[1]=lv.getLunchCode();
				rowData[2]=new ImageIcon(imgPath+ lv.getImg() );
				rowData[3]=lv.getLunchName();
				rowData[4]=new Integer(lv.getPrice());
				
				//DTM에 추가
				dtmLunch.addRow( rowData );
				
			}//end for
			
			if(listLunch.isEmpty()) {// 입력된 도시락이 없을 때
				JOptionPane.showMessageDialog(lmv, "입력된 제품이 없습니다.");
			}//end if
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중 문제 발생...");
			e.printStackTrace();
		}//end catch
		
	}//setLunch
	
	@Override
	public void windowClosing(WindowEvent we) {
		lmv.dispose();
	}//windowClosing
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0); //JVM의 모든 인스턴스 종료
	}//windowClosed
	
	private void searchOrder() {
		try {
			List<OrderVO> list= la_dao.selectOrderList();
			DefaultTableModel dtm=lmv.getDtmOrder();
			dtm.setRowCount(0);// 초기화
			
			Vector<Object> vec=null;
			OrderVO ovo=null;
			
			String orderNum="";
			for(int i= 0 ; i< list.size() ; i++) {
				ovo=list.get(i);
				vec=new Vector<Object>();
				
				vec.add(new Integer(i+1));
				vec.add(ovo.getOrderNum());
				vec.add(ovo.getLunchCode());
				vec.add(ovo.getLunchName());
				vec.add(ovo.getOrderName());
				vec.add(ovo.getQuan());
				vec.add(ovo.getPrice());
				vec.add(ovo.getOrderDate());
				vec.add(ovo.getPhone());
				vec.add(ovo.getIpAddress());
				vec.add(ovo.getStatus());	
				/////////////////////// 요청사항추가////////////////////////////////////////////
				if(ovo.getRequest()!=null) {
					orderNum=ovo.getOrderNum();
					map.put(orderNum, new FlagVO(ovo.getRequest(),
								map.get(orderNum)==null?	false:map.get(orderNum).isReadFlag()));
				}//end if
				//추가 
				dtm.addRow( vec );
				
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//searchOrder
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource()==lmv.getJtb()) {
			if( lmv.getJtb().getSelectedIndex() == 1) {//두번째 탭(주문)에서 이벤트 발생
				//  실시간으로 DB를 조회하여 주문현황을 계속 갱신
				if(threadOrdering == null) {
					threadOrdering=new Thread( this );
					threadOrdering.start();
				}//end if
				//현재까지의 주문사항을 조회
//				searchOrder();
			}//end if
		}//end if
		
		if(me.getSource()==lmv.getJtOrder() &&
						me.getButton()==MouseEvent.BUTTON3) {
			JTable jt=lmv.getJtOrder();
			//마우스 포인터가 클릭되면 테이블에서 클릭한 행을 가져오는 일
			 int r = jt.rowAtPoint(me.getPoint());
		        if (r >= 0 && r < jt.getRowCount()) {
		        	jt.setRowSelectionInterval(r, r);// 시작행과 끝행 사이의 행을 선택 하는일
		        } else {
		        	jt.clearSelection();
		        }//end else 
		        //선택한 행을 넣는다. 
		        selectedRow=r;
				/////////////////////// 요청사항추가////////////////////////////////////////////
		       boolean flag= map.containsKey(jt.getValueAt(r, 1)) && !map.get(jt.getValueAt(r, 1)).isReadFlag();
		        if( !flag ) {
					JPopupMenu jp= lmv.getJpOrderMenu();
					jp.setLocation(me.getXOnScreen(), me.getYOnScreen());
					jp.setVisible(true);
					
					orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);
					lunchName=(String)jt.getValueAt(jt.getSelectedRow(), 3)+ " "+
									(String)jt.getValueAt(jt.getSelectedRow(), 4);
		        }else {
		        	msgCenter(lmv, "요청사항이 있는 주문 입니다.");
		        }//end else 
		}else {
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false);
		}//end if
		
		switch( me. getClickCount() ) {
		case  DBL_CLICK :
			if( me.getSource() == lmv.getJtOrder()) {////////////////////////////////////////추가
				JTable jt=lmv.getJtOrder();
				String flag=(String)jt.getValueAt( jt.getSelectedRow(), 1);
				if(map.containsKey(flag)) {
					FlagVO val=map.get(flag);
					msgCenter(lmv, val.getRequest());
					val.setReadFlag(true);
				}//end if
			}//end if
			
			if( me.getSource() == lmv.getJtLunch()) { //도시락테이블에서 더블클릭이 되면
				//도시락 코드로 DB Table을 검색하여 상세정보를 전달한다.
				JTable jt=lmv.getJtLunch();
				try {
					LunchDetailVO ldvo=
								la_dao.selectDetailLunch((String)jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView( lmv, ldvo ,this);
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(lmv, "DB에서 문제가 발생했습니다.");
					se.printStackTrace();
				}//end catch
			}//end if
						
		}//end 
		
	}//mouseClicked
	
	private void msgCenter(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message );
	}//msgCenter


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == lmv.getJbtAddLunch()) { //도시락 추가 버튼
			new LunchAddView(lmv,this);
		}//end if
		
		if(ae.getSource() == lmv.getJcbMonth()) {//월별 마지막 일자 변경
			setDay();
		}//end if
		
		if(ae.getSource() == lmv.getJbtCalcOrder()) {//정산 버튼 클릭
			searchCalc();
		}//end if
		
		if(ae.getSource()==lmv.getJmOrderRemove()) {
			//제작상태가 'N'인 상태에서만 동작
			JTable jt=lmv.getJtOrder();
			if( ((String)jt.getValueAt(selectedRow,10)).equals("N") ) {
				switch(JOptionPane.showConfirmDialog(lmv, "[ "+orderNum+" "+
						lunchName+" ] 주문정보를 삭제하시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					
					try {
						if(la_dao.deleteOrder(orderNum)) {//DBTable에서 해당 레코드 삭제
							msgCenter(lmv, orderNum+" 주문이 삭제 되었습니다.");
							//주문 테이블 갱신
							searchOrder();
						}else {
							msgCenter(lmv, orderNum+" 주문이 삭제 되지 않습니다.");
						}//end else
					} catch (SQLException e) {
						msgCenter(lmv, "DB 에서 문제발생.");
						e.printStackTrace();
					}//end catch
						
				}//end switch
				
			}else {
				msgCenter(lmv,"제작된 도시락은 삭제할 수 없습니다.");
			}//end else
			
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false); //popup메뉴 숨김
			
			
		}//end if
		
		if(ae.getSource()==lmv.getJmOrderStatus()) {
			//제작상태가 'N'인 상태에서만 동작
			JTable jt=lmv.getJtOrder();
			if( ((String)jt.getValueAt(selectedRow,10)).equals("N") ) {
				
				switch(JOptionPane.showConfirmDialog(lmv, "[ "+orderNum+lunchName
								+" ]주문이 완료었습니까?")) {
				case JOptionPane.OK_OPTION:
					try {
						//DB Table의 해당 레코드 변경 
						if(la_dao.updateStatus( orderNum)) {// 상태변환 성공
							jt.setValueAt("Y", selectedRow, 10); //J테이블의 값만 변경 
							
							JOptionPane.showMessageDialog(lmv, "도시락 제작이 완료되었습니다.!!");
							
						}else {//상태변환 실패
							JOptionPane.showMessageDialog(lmv, "도시락 제작상태 변환이 실패!!!");
						}//end else
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(lmv, "DB에서 문제 발생");
						e.printStackTrace();
					}//end catch					
				}//end switch
			}else {
				JOptionPane.showMessageDialog(lmv, "제작이 완료된 도시락 입니다.");
			}//end else
			
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false); //popup메뉴 숨김
			
		}//end if
		
	}//actionPerformed
	
	/**
	 * 년,월,일 정보를 가져와서 정산
	 */
	private void searchCalc() {
		int selYear=((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth=((Integer)lmv.getJcbMonth().getSelectedItem()).intValue();
		int selDay=((Integer)lmv.getJcbDay().getSelectedItem()).intValue();
		
		StringBuilder searchDate=new StringBuilder();
		searchDate.append(selYear).append("-").append(selMonth).append("-")
		.append(selDay);
		
		try {
			//선택한 일자의 조회결과를 받아서 JTable 출력
			List<CalcVO> list=la_dao.selectCalc( searchDate.toString() );
			// JTable에 데이터를 추가하는 코드 작성해보세요.
			DefaultTableModel dtm=lmv.getDtmCalc();
			if( !list.isEmpty()) {
				dtm.setRowCount(0);
			}//end if
			
			Object[] rowData=null;
			CalcVO cv=null;
			
			for( int i= 0 ; i < list.size() ; i++) {
				cv=list.get(i);
				rowData=new Object[4];
				rowData[0]=new Integer(i+1);
				rowData[1]=cv.getLunchName()+"("+cv.getLunchCode()+")";
				rowData[2]=new Integer(cv.getTotal());
				rowData[3]=new Integer(cv.getPrice());
				dtm.addRow(rowData);
			}//end for
			
			// 데이터가 없는 날에는 " 판매된 도시락이 없습니다" 출력
			if(list.isEmpty()) {
				JOptionPane.showMessageDialog(lmv,
						searchDate.toString() +"일 에는 판매된 도시락이 없습니다.");
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//searchCalc
	
	/**
	 * 월이 선택되면 해당년의 해당월의 마지막날을 설정
	 */
	private void setDay() {
		int selYear=((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth=((Integer)lmv.getJcbMonth().getSelectedItem()).intValue();
		
		//마지막날 얻기
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth-1);
		
		int lastDay=cal.getActualMaximum(Calendar.DATE);

		lmv.getCbmDay().removeAllElements();//모델을 초기화하고
		for( int day=1; day<lastDay+1 ; day++) {
			lmv.getCbmDay().addElement(day);//마지막 날을 설정한다. 
		}//end for
		
//		lmv.getCbmDay().setSelectedItem(new Integer(nowDay));//오늘을 선택한다.
		
	}//setDay

	@Override
	public void run() {
		//30초마다 한번씩 조회 수행
		try {
			while(true) {
				searchOrder();
				Thread.sleep(1000*30);
			}//end while
		} catch (InterruptedException e) {
			msgCenter(lmv, "주문 조회 중 문제가 발생했습니다.");
			e.printStackTrace();
		}//end catch
	}//run
	////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) {	}

}//class
