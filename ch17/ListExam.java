package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//1. JPanel을 North영역에 배치
//2. JPanel JTextField, JButton2개
//3. JList(list)를 Center영역에 배치
//4. JList선택후 소스에서 코딩
//5. list를 local to field로 전환
//6. 디자인모드에서 [추가]버튼을 더블클릭 =>소스전환 후 코딩
//7. 디자인모드에서 tf 선택=> 마우스우클릭 Add event handler
//==> action ==> actionPerfomed 후 소스에서 코딩
//8. 디자인모드에서 삭제버튼 더블클릭 => 소스전환 후 코딩


@SuppressWarnings("serial")
public class ListExam extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	private DefaultListModel<Object> model;
	private JList<Object> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListExam frame = new ListExam();
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
	public ListExam() {
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
		
		tf = new JTextField();
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(tf.getText());
//				list.setModel(model);
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(tf);
		tf.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setText("문자열") 문자열 내용변경
				//getText() 입력된 내용 꺼내기
				model.addElement(tf.getText());	//리스트에 추가
				System.out.println(model);
				list.setModel(model);			//리스트 갱신
				System.out.println(model);
				tf.setText("");					//텍스트필드 초기화
				tf.requestFocus();				//입력 포커스 설정
			}
		});
		btnAdd.setForeground(Color.BLACK);
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Del");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				model.removeElement(tf.getText());
//				list.setModel(model);
//				tf.setText("");
//				tf.requestFocus();
				int selectedIndex=list.getSelectedIndex();//List의 index값을 가져옴
				if(selectedIndex != -1) {//선택된 값이 없으면 -1
					System.out.println(selectedIndex);
					model.remove(selectedIndex);//List 값 삭제
				}
			}
		});
		panel.add(btnDelete);
		
		model = new DefaultListModel<>();	//데이터 모델 생성
		model.addElement("서울");
		model.addElement("인천");
		model.addElement("부산");
		model.addElement("대전");
		model.addElement("춘천");
		
		
		list = new JList<Object>(model);
//		list.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent e) {
//				tf.setText(String.valueOf(list.getSelectedValue()));
//			}
//		});
		contentPane.add(list, BorderLayout.CENTER);
	}

}
