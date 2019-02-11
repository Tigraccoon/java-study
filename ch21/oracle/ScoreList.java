package ch21.oracle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ScoreList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private ScoreDAO dao;
	@SuppressWarnings("rawtypes")
	private Vector cols;
	
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ScoreList() {
		setTitle("ScoreList");
		dao = new ScoreDAO();	//DAO 인스턴스 생성
		//제목열 구성
		cols = new Vector();
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");
		
				
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreSave frm = new ScoreSave(ScoreList.this);
				frm.setVisible(true);
				frm.setLocation(200,200);
				
			}
		});
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JTable에서 선택한 행의 인덱스 값
				int idx = table.getSelectedRow();	//0번째 행 부터 시작
				System.out.println(idx);
				if(idx == -1) {	//선택한 행이 없으면?
					JOptionPane.showMessageDialog(ScoreList.this, "편집할 자료를 선택하세요!", "Select Data!", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {	//선택한 행이 있으면?
					//기본 키만 보내는 방식
					String student_no = String.valueOf(table.getValueAt(idx, 0));
					ScoreEdit frm = new ScoreEdit(ScoreList.this,student_no);
					frm.setVisible(true);
					frm.setLocation(200,200);
							
				}
				
			}
		});
		panel.add(btnEdit);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		refreshTable();
	}//scoreList
	
	public void refreshTable() {
		//JTable에 바인딩할 데이터 모델 생성
		//new DefaultTableModel(rows, cols);
		DefaultTableModel model = new DefaultTableModel(dao.listScore(),cols);
		//테이블에 데이터를 채움
		table.setModel(model);
		
	}

}
