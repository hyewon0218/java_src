package kr.co.sist.memo.evt;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.Help;
import kr.co.sist.memo.view.JavaMemo;

public class HelpEvt extends WindowAdapter implements ActionListener {

 private Help h;
 
 public HelpEvt(Help h) {
	 this.h=h;

}
@Override
	public void windowClosing(WindowEvent e) {
	h.dispose();
}
 
@Override
public void actionPerformed(ActionEvent e) {

	
	h.dispose();
}
// 	public void createDialog() {
// 		h=new Dialog(this, "메모장정보", true);
// 	}
}
