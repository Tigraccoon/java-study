package ch19;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FileExam extends JFrame {

	private JPanel contentPane;
	private JTextField tfFileName;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileExam frame = new FileExam();
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
	public FileExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("File Name : ");
		lblNewLabel.setBounds(12, 10, 70, 15);
		contentPane.add(lblNewLabel);
		
		tfFileName = new JTextField();
		tfFileName.setBounds(94, 7, 219, 21);
		contentPane.add(tfFileName);
		tfFileName.setColumns(10);
		
		JButton button1 = new JButton("Enter");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//File : 파일의 정보(파일 이름, 생성 일자, 파일의 크기...)를 가져올 수 있는 클래스
				File file = new File(tfFileName.getText());
				if(!file.exists()) {	//파일이 존재하지 않으면?
					try {
						file.createNewFile();	//빈파일 생성
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				String str = "파일 이름 : "+file.getName()+"\n"+"파일 크기 : "+file.length()+"\n"+"상위 폴더 : "+file.getPath();
				ta.setText(str);
			}
		});
		button1.setBounds(325, 6, 97, 23);
		contentPane.add(button1);
		
		ta = new JTextArea();
		ta.setBounds(12, 35, 410, 217);
		contentPane.add(ta);
	}
}
