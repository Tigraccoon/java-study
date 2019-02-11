package ch21.oracle;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ScoreSave extends JFrame {

	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	
	private ScoreList frm;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ScoreSave frame = new ScoreSave();
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
	//ScoreList 프레임의 주소값을 받기 위해 매개변수 추가
	public ScoreSave(ScoreList frm) {
		this();	//ScoreSave의 화면을 보이기 위해 기본 생성자 호출
		this.frm = frm;
	}
	
	public ScoreSave() {
		
		setTitle("Save");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 223, 233);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("학번 : ");
		label.setBounds(12, 13, 57, 15);
		contentPane.add(label);
		
		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(79, 10, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(79, 38, 116, 21);
		contentPane.add(tfName);
		
		JLabel label_1 = new JLabel("이름 : ");
		label_1.setBounds(12, 41, 57, 15);
		contentPane.add(label_1);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(79, 69, 116, 21);
		contentPane.add(tfKor);
		
		JLabel label_2 = new JLabel("국어 : ");
		label_2.setBounds(12, 72, 57, 15);
		contentPane.add(label_2);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(79, 100, 116, 21);
		contentPane.add(tfEng);
		
		JLabel label_3 = new JLabel("영어 : ");
		label_3.setBounds(12, 103, 57, 15);
		contentPane.add(label_3);
		
		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(79, 131, 116, 21);
		contentPane.add(tfMat);
		
		JLabel label_4 = new JLabel("수학 : ");
		label_4.setBounds(12, 134, 57, 15);
		contentPane.add(label_4);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.parseInt(tfKor.getText());
				int eng = Integer.parseInt(tfEng.getText());
				int mat = Integer.parseInt(tfMat.getText());
				ScoreDTO dto = new ScoreDTO(student_no, name, kor, eng, mat);
				ScoreDAO dao = new ScoreDAO();
				int result = dao.insertScore(dto);
				if (result == 1) {	//insert가 성공적으로 반영되면?
					JOptionPane.showMessageDialog(ScoreSave.this, "저장되었습니다?", "Saved?", JOptionPane.PLAIN_MESSAGE);
					frm.refreshTable();
					dispose();
				}
			}
		});
		btnSave.setBounds(57, 162, 97, 23);
		contentPane.add(btnSave);
	}

}
