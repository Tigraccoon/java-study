package ch17;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LoginExam2 extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwd;
	private JTextField id;
	private JButton btnLogin;
	private JLabel lblResult;
	private Map<String,String> map;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginExam2 frame = new LoginExam2();
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
	public LoginExam2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		map = new HashMap<>();
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(12, 10, 86, 34);
		contentPane.add(lblId);
		
		JLabel lblPwd = new JLabel("PWD");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setBounds(12, 70, 86, 34);
		contentPane.add(lblPwd);
		
		id = new JTextField();
		id.setForeground(Color.BLACK);
		id.setFont(new Font("굴림", Font.PLAIN, 15));
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBounds(110, 10, 312, 34);
		contentPane.add(id);
		id.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setForeground(Color.BLACK);
		pwd.setFont(new Font("굴림", Font.PLAIN, 15));
		pwd.setHorizontalAlignment(SwingConstants.CENTER);
		pwd.setBounds(110, 70, 312, 34);
		contentPane.add(pwd);
		
		map.put("lee@naver.com", "1234");
		map.put("kim@nate.com", "2345");
		map.put("park@daum.net", "3456");
		map.put("kang@gmail.com", "4567");
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ids = id.getText();
				String pwds = String.valueOf(pwd.getPassword());
				String strid = map.get(ids);
				if (strid != null && strid.equals(pwds)) {
					lblResult.setText(ids+"님 환영합니다.");
					lblResult.setForeground(Color.BLUE);
				} else {
					lblResult.setText("아이디 또는 비밀번호를 확인하세요.");
					lblResult.setForeground(Color.RED);
				}
				
			}
		});
		btnLogin.setBounds(12, 128, 410, 34);
		contentPane.add(btnLogin);
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("굴림", Font.PLAIN, 15));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(12, 172, 410, 63);
		contentPane.add(lblResult);
	}

}
