package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

//North에 JPanel, JPanel 내부에 JCheckBox
//South에 종료 Button추가
//Center에 JScrollPane
//TextArea를 JScrollPane의 Viewport 영역에 배치
//TextArea를 field변수 변환
//각 체크박스 선택해서 Add event handler => item => itemstateChanged
//if ~ else 코딩

@SuppressWarnings("serial")
public class CheckboxExam extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckboxExam frame = new CheckboxExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckboxExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JCheckBox ckJava = new JCheckBox("Java");
		ckJava.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//getStateChange() 체크박스의 체크상태를 가져옴
				System.out.println(e.getStateChange());//콘솔화면에 출력
				//append("문자열"); 문자추가
				//setText("문자열"); 문자변경. setText("");화면클리어
				//getText();문자값을 가져올때
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("Java를 신청했습니다.\n");
				} else {
					ta.append("Java를 취소했습니다.\n");
				}
			}
		});
		ckJava.setBackground(Color.LIGHT_GRAY);
		panel.add(ckJava);
		
		JCheckBox ckC = new JCheckBox("C");
		ckC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("C를 신청했습니다.\n");
				}else {
					ta.append("C를 취소했습니다.\n");
				}
			}
		});
		ckC.setBackground(Color.LIGHT_GRAY);
		panel.add(ckC);
		
		JCheckBox ckIoT = new JCheckBox("IoT");
		ckIoT.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("IoT를 신청했습니다.\n");
				}else {
					ta.append("IoT를 취소했습니다.\n");
				}
			}
		});
		ckIoT.setBackground(Color.LIGHT_GRAY);
		panel.add(ckIoT);
		
		JCheckBox ckDb = new JCheckBox("DB");
		ckDb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("DB를 신청했습니다.\n");
				}else {
					ta.append("DB를 취소했습니다.\n");
				}
			}
		});
		ckDb.setBackground(Color.LIGHT_GRAY);
		panel.add(ckDb);
		
		JCheckBox ckHtml = new JCheckBox("HTML");
		ckHtml.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("HTML를 신청했습니다.\n");
				}else {
					ta.append("HTML를 취소했습니다.\n");
				}
			}
		});
		ckHtml.setBackground(Color.LIGHT_GRAY);
		panel.add(ckHtml);
		
		JCheckBox ckJsp = new JCheckBox("JSP");
		ckJsp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("JSP를 신청했습니다.\n");
				}else {
					ta.append("JSP를 취소했습니다.\n");
				}
			}
		});
		ckJsp.setBackground(Color.LIGHT_GRAY);
		panel.add(ckJsp);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		ta = new JTextArea();
		ta.setLineWrap(true);
		scrollPane.setViewportView(ta);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(Color.BLACK);
		contentPane.add(btnExit, BorderLayout.SOUTH);
	}

}
