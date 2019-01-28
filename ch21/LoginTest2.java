package ch21;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LoginTest2 extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTest2 frame = new LoginTest2();
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
	public LoginTest2() {
		setResizable(false);
		setTitle("Login?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 280);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID : ");
		lblId.setBounds(12, 10, 57, 15);
		contentPane.add(lblId);

		userid = new JTextField();
		userid.setBounds(119, 7, 116, 21);
		contentPane.add(userid);
		userid.setColumns(10);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(12, 35, 75, 15);
		contentPane.add(lblPassword);

		pwd = new JPasswordField();
		pwd.setBounds(119, 32, 116, 21);
		contentPane.add(pwd);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strid = userid.getText();
				String strpwd = String.valueOf(pwd.getPassword());
				Connection conn = null;
				PreparedStatement ppsm = null;
				ResultSet rs = null;
				
				try {
					FileInputStream fio = new FileInputStream("D:\\SQL\\MySQL\\db.prop");
					Properties prop = new Properties();
					prop.load(fio);
					
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String pwd = prop.getProperty("pwd");
					
					conn = DriverManager.getConnection(url, id, pwd);
					String sql = "SELECT * FROM member WHERE userid = ? AND pwd = ?";
					ppsm = conn.prepareStatement(sql);
					ppsm.setString(1, strid);
					ppsm.setString(2, strpwd);
					
					rs = ppsm.executeQuery();
					if (rs.next()) {
						lblResult.setText("Welcome!!  " + rs.getString("name"));
					} else {
						lblResult.setText("WRONG ID or PASSWORD");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if(rs!=null)
							rs.close();
					} catch (Exception e3) {
						e3.printStackTrace();
					}
					try {
						if(ppsm!=null)
							ppsm.close();
					} catch (Exception e3) {
						e3.printStackTrace();
					}
					try {
						if(conn!=null)
							conn.close();
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
				
				
			}
		});


		btnLogin.setBounds(12, 75, 223, 23);
		contentPane.add(btnLogin);

		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(12, 119, 223, 105);
		contentPane.add(lblResult);
	}
}