package ch17;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginExam extends JFrame {

	private JPanel contentPane;
	private JLabel lblResult;
	private JTextField userid;
	
	private Map<String,String> map;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginExam frame = new LoginExam();
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
	public LoginExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(49, 55, 57, 15);
		contentPane.add(lblid);
		
		JLabel lblpwd = new JLabel("PW");
		lblpwd.setBounds(49, 103, 57, 15);
		contentPane.add(lblpwd);
		
		userid = new JTextField();
		userid.setHorizontalAlignment(SwingConstants.CENTER);
		userid.setBounds(118, 52, 256, 21);
		contentPane.add(userid);
		userid.setColumns(10);
		
		//멥에 데이터 추가
		map = new HashMap<>();
		map.put("kim", "1234");
		map.put("park", "2222");
		map.put("hong", "3333");
		
		JButton bthLogin = new JButton("Login");
		bthLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userid.getText();
				String pw = String.valueOf(pwd.getPassword());
				String strId = map.get(id);
				if(strId != null && strId.equals(pw)) {
					lblResult.setForeground(Color.BLUE);
					lblResult.setText(id+" 님 환영합니다.");
				} else {
					lblResult.setForeground(Color.RED);
					lblResult.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
				}
			}
		});
		bthLogin.setBounds(49, 157, 325, 23);
		contentPane.add(bthLogin);
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("굴림", Font.PLAIN, 15));
		lblResult.setForeground(Color.WHITE);
		lblResult.setHorizontalTextPosition(SwingConstants.CENTER);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(49, 194, 325, 58);
		contentPane.add(lblResult);
		
		pwd = new JPasswordField();
		pwd.setHorizontalAlignment(SwingConstants.CENTER);
		pwd.setBounds(118, 100, 256, 21);
		contentPane.add(pwd);
	}
}
