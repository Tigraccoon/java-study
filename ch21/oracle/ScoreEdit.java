package ch21.oracle;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings({"serial", "unused"})
public class ScoreEdit extends JFrame {

	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	
	private ScoreList parent;
	private ScoreDAO dao;
	private ScoreDTO dto;
	private String student_no;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ScoreEdit frame = new ScoreEdit();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
//	public ScoreEdit() {}
	public ScoreEdit(ScoreList parent, String student_no) {
		//ScoreList 프레임의 주소값을 저장
		this.parent = parent;
		this.student_no = student_no;

		System.out.println(parent);
		
		setTitle("Edit");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 215, 225);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학번 : ");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(81, 7, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(81, 35, 116, 21);
		contentPane.add(tfName);
		
		JLabel label = new JLabel("이름 : ");
		label.setBounds(12, 38, 57, 15);
		contentPane.add(label);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(81, 66, 116, 21);
		contentPane.add(tfKor);
		
		JLabel label_1 = new JLabel("국어 : ");
		label_1.setBounds(12, 69, 57, 15);
		contentPane.add(label_1);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(81, 97, 116, 21);
		contentPane.add(tfEng);
		
		JLabel label_2 = new JLabel("영어 : ");
		label_2.setBounds(12, 100, 57, 15);
		contentPane.add(label_2);
		
		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(81, 125, 116, 21);
		contentPane.add(tfMat);
		
		JLabel label_3 = new JLabel("수학 : ");
		label_3.setBounds(12, 128, 57, 15);
		contentPane.add(label_3);
		
		//dto값을 텍스트필드에 출력
		dao = new ScoreDAO();
		dto = dao.viewScore(student_no);
		tfStudentNo.setText(dto.getStudent_no());
		tfName.setText(dto.getName());
		tfKor.setText(String.valueOf(dto.getKor()));
		tfEng.setText(String.valueOf(dto.getEng()));
		tfMat.setText(String.valueOf(dto.getMat()));
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.parseInt(tfKor.getText());
				int eng = Integer.parseInt(tfEng.getText());
				int mat = Integer.parseInt(tfMat.getText());
				ScoreDTO dto = new ScoreDTO(student_no, name, kor, eng, mat);
				ScoreDAO dao = new ScoreDAO();
				int result = dao.updateScore(dto);
				if (result == 1) {//수정 성공시?
					JOptionPane.showMessageDialog(ScoreEdit.this, "수정되었습니다?", "Edited?", JOptionPane.PLAIN_MESSAGE);
					parent.refreshTable();
					dispose();
				}
			}
		});
		btnUpdate.setBounds(12, 156, 84, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_no = tfStudentNo.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(ScoreEdit.this, "삭제하실래요?", "Delete?", JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					result = dao.deleteScore(student_no);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreEdit.this, "삭제되었습니다?", "Deleted?", JOptionPane.INFORMATION_MESSAGE);
					parent.refreshTable();
					dispose();
				} 
			}
		});
		btnDelete.setBounds(113, 156, 84, 23);
		contentPane.add(btnDelete);
	}
}
