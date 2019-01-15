package ch17;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyColorAction implements ActionListener{
	//Component : 화면 구성요소(버튼, 스크롤바 등등)
	//Container : 컴포넌트의 묶음
	
	@SuppressWarnings("unused")
	private JFrame f;
	private Color c;
	private Container con;
	
	public MyColorAction() {}
	public MyColorAction(JFrame f,Color c) {
		this.f=f;
		this.c=c;
		con = f.getContentPane();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		con.setBackground(c);	//배경 색상 변경
		
		
	}
	
	
}
