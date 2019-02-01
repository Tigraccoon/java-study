package ch21;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
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

@SuppressWarnings("serial")
public class EmpList extends JFrame {
	
	private EmpDAO dao;
	private EmpDTO dto;
	private Vector<String> col;
	private DefaultTableModel model;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField tfEnum;
	private JTextField tfName;
	private JTextField tfHday;
	private JTextField tfSal;
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
					EmpList frame = new EmpList();
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
	public EmpList() {
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
		scrollPane.setBounds(12, 174, 370, 368);
		contentPane.add(scrollPane);
		
		//추가
		dao = new EmpDAO();
		col = new Vector<String>();
		col.add("사번");
		col.add("이름");
		col.add("입사일");
		col.add("급여");
		//리스트 호출
		list();
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//현재 클릭한 행의 인덱스 값
				int idx = table.getSelectedRow();
				//수정 모드에서는 학번 입력 제한하도록 텍스트 필드 입력 기능을 false로 바꿀 필요가 있따.
				tfEnum.setEditable(false);
				tfEnum.setText(table.getValueAt(idx, 0)+"");
//				0행 0열의 학번, getValueAt은 Object타입이므로 setText의 String타입이니 ""를 붙여 String변환 또는 String.ValueOf를사용해도 가능
				tfName.setText(table.getValueAt(idx, 1)+"");	//0행 1열 이름
				tfHday.setText(table.getValueAt(idx, 2)+"");		//0행 2열 국어
				tfSal.setText(table.getValueAt(idx, 3)+"");		//0행 3열 영어
				
			}
		});
		
		scrollPane.setViewportView(table);
		
		JLabel lblStudentNumber = new JLabel("Emp Number : ");
		lblStudentNumber.setForeground(Color.BLACK);
		lblStudentNumber.setBounds(12, 10, 108, 15);
		contentPane.add(lblStudentNumber);
		
		JLabel lblName = new JLabel("Emp Name : ");
		lblName.setForeground(Color.BLACK);
		lblName.setBounds(12, 35, 108, 15);
		contentPane.add(lblName);
		
		tfEnum = new JTextField();
		tfEnum.setBounds(132, 7, 250, 21);
		contentPane.add(tfEnum);
		tfEnum.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(132, 32, 250, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblKor = new JLabel("Hire Date : ");
		lblKor.setForeground(Color.BLACK);
		lblKor.setBounds(12, 60, 108, 15);
		contentPane.add(lblKor);
		
		tfHday = new JTextField();
		tfHday.setBounds(132, 57, 250, 21);
		contentPane.add(tfHday);
		tfHday.setColumns(10);
		
		JLabel lblEng = new JLabel("Salary : ");
		lblEng.setForeground(Color.BLACK);
		lblEng.setBounds(12, 85, 108, 15);
		contentPane.add(lblEng);
		
		tfSal = new JTextField();
		tfSal.setBounds(132, 82, 250, 21);
		contentPane.add(tfSal);
		tfSal.setColumns(10);
		
		lblNameForSerch = new JLabel("Name for Search : ");
		lblNameForSerch.setForeground(Color.BLACK);
		lblNameForSerch.setBounds(12, 113, 108, 15);
		contentPane.add(lblNameForSerch);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
				
			}
		});
		tfSearch.setBounds(132, 110, 250, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//사용자가 입력한 값을 dto에 저장
				input();
				//레코드에 저장
				int result = dao.insertEmp(dto);
				if (result == 1) {	//잘 들어왔으면?
					JOptionPane.showMessageDialog(EmpList.this, "저장되었습니다.", "Saved", JOptionPane.PLAIN_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(EmpList.this, "저장에 실패하였습니다.", "Save Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				list();
				table.setModel(model);
				clear();
				
			}
		});
		btnSave.setBounds(12, 138, 85, 26);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.updateEmp(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(EmpList.this, "수정되었습니다.", "Updated", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(EmpList.this, "업데이트에 실패하였습니다.", "Update Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				list();
				table.setModel(model);
				clear();
			}
		});
		btnUpdate.setBounds(200, 138, 85, 26);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int empno = Integer.parseInt(tfEnum.getText());
				int result = 0;
				int response = JOptionPane.showConfirmDialog(EmpList.this, "정말 삭제하시겠습니까?", "Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION) {
					result = dao.deleteEmp(empno);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(EmpList.this, "삭제되었습니다.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(EmpList.this, "삭제에 실패하였습니다.", "Delete Failed", JOptionPane.ERROR_MESSAGE);
				}
				list();
				table.setModel(model);
				clear();
			}
		});
		btnDelete.setBounds(107, 138, 85, 26);
		contentPane.add(btnDelete);
		
		btnSearch = new JButton("Serch");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(297, 138, 85, 26);
		contentPane.add(btnSearch);
	}
	
	public void search() {
		String ename = tfSearch.getText();
		model = new DefaultTableModel(dao.searchEmp(ename), col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
		
	}//search
	
	public void input() {
		int empno = Integer.parseInt(tfEnum.getText());
		String ename = tfName.getText();
		Date hiredate = Date.valueOf(tfHday.getText());
		int sel = Integer.parseInt(tfSal.getText());
		dto = new EmpDTO(empno, ename, hiredate, sel);
	}//input
	
	public void clear() {
		tfEnum.setText("");
		tfName.setText("");
		tfHday.setText("");
		tfSal.setText("");
		tfSearch.setText("");
		tfEnum.requestFocus();
		//수정이 끝나면 학번 입력을 활성화
		tfEnum.setEditable(true);
	}//clear
	
	public void list() {
		model = new DefaultTableModel(dao.listEmp(), col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}//list
	
	
	
}