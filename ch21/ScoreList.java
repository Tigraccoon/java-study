package ch21;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ScoreList extends JFrame {
	
	private ScoreDAO dao;
	private ScoreDTO dto;
	private Vector<String> col;
	private DefaultTableModel model;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField tfSnum;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private JLabel lblNameForSerch;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreList frame = new ScoreList();
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
	public ScoreList() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 580);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 196, 370, 346);
		contentPane.add(scrollPane);
		
		//추가
		dao = new ScoreDAO();
		col = new Vector<String>();
		col.add("학번");
		col.add("이름");
		col.add("국어");
		col.add("영어");
		col.add("수학");
		col.add("총점");
		col.add("평균");
		
		//JTable에 데이터를 출력시키기 위한 테이블 모델 생성
		list();
		//JTable에 모델을 연결시킴
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//현재 클릭한 행의 인덱스 값
				int idx = table.getSelectedRow();
				//수정 모드에서는 학번 입력 제한하도록 텍스트 필드 입력 기능을 false로 바꿀 필요가 있따.
				tfSnum.setEditable(false);
				tfSnum.setText(table.getValueAt(idx, 0)+"");
//				0행 0열의 학번, getValueAt은 Object타입이므로 setText의 String타입이니 ""를 붙여 String변환 또는 String.ValueOf를사용해도 가능
				tfName.setText(table.getValueAt(idx, 1)+"");	//0행 1열 이름
				tfKor.setText(table.getValueAt(idx, 2)+"");		//0행 2열 국어
				tfEng.setText(table.getValueAt(idx, 3)+"");		//0행 3열 영어
				tfMat.setText(table.getValueAt(idx, 4)+"");		//0행 4열 수학
//				tfSerch.setText(table.getValueAt(idx, 5)+"");	//0행 5열 써치
				
			}
		});
		
		scrollPane.setViewportView(table);
		
		JLabel lblStudentNumber = new JLabel("Student Number : ");
		lblStudentNumber.setForeground(Color.BLACK);
		lblStudentNumber.setBounds(12, 10, 108, 15);
		contentPane.add(lblStudentNumber);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setForeground(Color.BLACK);
		lblName.setBounds(12, 35, 108, 15);
		contentPane.add(lblName);
		
		tfSnum = new JTextField();
		tfSnum.setBounds(132, 7, 250, 21);
		contentPane.add(tfSnum);
		tfSnum.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(132, 32, 250, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblKor = new JLabel("Kor : ");
		lblKor.setForeground(Color.BLACK);
		lblKor.setBounds(12, 60, 108, 15);
		contentPane.add(lblKor);
		
		tfKor = new JTextField();
		tfKor.setBounds(132, 57, 250, 21);
		contentPane.add(tfKor);
		tfKor.setColumns(10);
		
		JLabel lblEng = new JLabel("Eng : ");
		lblEng.setForeground(Color.BLACK);
		lblEng.setBounds(12, 85, 108, 15);
		contentPane.add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setBounds(132, 82, 250, 21);
		contentPane.add(tfEng);
		tfEng.setColumns(10);
		
		JLabel lblMat = new JLabel("Mat : ");
		lblMat.setForeground(Color.BLACK);
		lblMat.setBounds(12, 110, 108, 15);
		contentPane.add(lblMat);
		
		tfMat = new JTextField();
		tfMat.setBounds(132, 107, 250, 21);
		contentPane.add(tfMat);
		tfMat.setColumns(10);
		
		lblNameForSerch = new JLabel("Name for Search : ");
		lblNameForSerch.setForeground(Color.BLACK);
		lblNameForSerch.setBounds(12, 135, 108, 15);
		contentPane.add(lblNameForSerch);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
				
			}
		});
		tfSearch.setBounds(132, 132, 250, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//사용자가 입력한 값을 dto에 저장
				input();
				//레코드에 저장
				int result = dao.insertScore(dto);
				if (result == 1) {	//잘 들어왔으면?
					JOptionPane.showMessageDialog(ScoreList.this, "저장되었습니다.", "Saved", JOptionPane.PLAIN_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(ScoreList.this, "저장에 실패하였습니다.", "Save Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				list();
				table.setModel(model);
				clear();
				
			}
		});
		btnSave.setBounds(12, 160, 85, 26);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.updateScore(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "수정되었습니다.", "Updated", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(ScoreList.this, "업데이트에 실패하였습니다.", "Update Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				list();
				table.setModel(model);
				clear();
			}
		});
		btnUpdate.setBounds(200, 160, 85, 26);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_no = tfSnum.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(ScoreList.this, "정말 삭제하시겠습니까?", "Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION) {
					result = dao.deleteScore(student_no);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "삭제되었습니다.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ScoreList.this, "삭제에 실패하였습니다.", "Delete Failed", JOptionPane.ERROR_MESSAGE);
				}
				list();
				table.setModel(model);
				clear();
			}
		});
		btnDelete.setBounds(107, 160, 85, 26);
		contentPane.add(btnDelete);
		
		btnSearch = new JButton("Serch");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(297, 160, 85, 26);
		contentPane.add(btnSearch);
	}
	
	public void search() {
		String name = tfSearch.getText();
		model = new DefaultTableModel(dao.searchScore(name), col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
		
	}//search
	
	public void input() {
		String student_no = tfSnum.getText();
		String name = tfName.getText();
		int kor = Integer.parseInt(tfKor.getText());
		int eng = Integer.parseInt(tfEng.getText());
		int mat = Integer.parseInt(tfMat.getText());
		dto = new ScoreDTO(student_no, name, kor, eng, mat);
	}//input
	
	public void clear() {
		tfSnum.setText("");
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMat.setText("");
		tfSearch.setText("");
		tfSnum.requestFocus();
		//수정이 끝나면 학번 입력을 활성화
		tfSnum.setEditable(true);
	}//clear
	
	public void list() {
		model = new DefaultTableModel(dao.listScore(), col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}//list
	
	
	
}