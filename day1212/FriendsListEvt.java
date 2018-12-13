package day1212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Design class 와 Has a 관계로 설정된 이벤트 처리 클래스
 * 
 * @author SIST
 */
public class FriendsListEvt extends WindowAdapter implements ActionListener, ItemListener {

	// 이벤트를 처리하기 위해 사용되는 모든 컴포넌트는 has a 관계의
	// 객체를 사용하여 처리한다.
	private FriendsList fl;

	public FriendsListEvt(FriendsList fl) {
		this.fl = fl;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		fl.dispose();
	}

	@Override
	//List 이벤트 처리
	public void itemStateChanged(ItemEvent ie) {
		//친구 리스트에서 클릭되면 해당 아이템을 차단된 친구로 보낸다.
		if (ie.getSource()==fl.getListFriend()) {
			blockFriend();
		}
//			System.out.println("친구");
			
		//차단된 친구 리스트에서 클릭된 해당 아이템을 친구리스트로 보낸다. 
		if (ie.getSource()==fl.getListBlockFriend()) {
			unblockFriend();
		}
	}		
			

	@Override
	// Button 이벤트 처리
	public void actionPerformed(ActionEvent ae) {
		// >> : 모든 친구를 차단 목록으로 이동
		if(ae.getSource()==fl.getBtnAllBlock()) {
			allBlock();
		}
		// >> : 차단된 모든 친구를 차단 목록으로 이동
		if(ae.getSource()==fl.getBtnAllUnblock()) {
			allUnBlock();
		}
	}

	/**
	 * 친구 리스트에서 선택한 친구를 차단 리스트로 이동
	 */
	private void blockFriend() {
		List tempFriend = fl.getListFriend();
		// 선택한 친구를 얻어와서
		String name = tempFriend.getSelectedItem();
		// 차단으로 보낸다.
		fl.getListBlockFriend().add(name);
		// 선택한 친구를 삭제
		tempFriend.remove(name);
	}

	/**
	 * 차단한 친구리스트에서 선택한 친구를 친구리스트로 이동
	 */
	private void unblockFriend() {
		//차단된 친구리스트에서 선택한 이름을 받아와서 
		List tempList=fl.getListBlockFriend();
		int seletedIndex=tempList.getSelectedIndex();
		//친구 리스트에 추가하고 
		fl.getListFriend().add(tempList.getItem(seletedIndex));
		//차단된 친구리스트에서 삭제한다.
		tempList.remove(seletedIndex);
	}

	/**
	 * &gt;%gt; 모든 친구 차단
	 */
	private void allBlock() {
		//친구 리스트의 모든 아이템을 받아와서
		String[] arrFriend=fl.getListFriend().getItems();
		//차단 리스트로 보낸다.
		for(int i=0; i<arrFriend.length ; i++) {
			fl.getListBlockFriend().add(arrFriend[i]);
		}
		//친구리스트의 모든 아이템을 삭제
		fl.getListFriend().removeAll();
	}

	/**
	 * &lt;%gt; 버튼을 클릭하면 차단된 모든 친구가 친구리스트로 이동
	 */
	private void allUnBlock() {
		//차단된 모든 친구 목록을 받아와서
		String[] arrBlockList=fl.getListBlockFriend().getItems();
		//친구 목록에 추가하고
		for(String name : arrBlockList) {
			fl.getListFriend().add(name);
		}
		//차단된 모든 친구 목록을 삭제
		fl.getListBlockFriend().removeAll();
	}

}
