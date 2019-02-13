package project2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField pfPwd;


	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Sign in to JavaShop!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 187);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID : ");
		lblNewLabel.setBounds(12, 10, 69, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password : ");
		lblNewLabel_1.setBounds(12, 35, 69, 15);
		contentPane.add(lblNewLabel_1);

		tfId = new JTextField();
		tfId.setBounds(93, 7, 139, 21);
		contentPane.add(tfId);
		tfId.setColumns(10);

		pfPwd = new JPasswordField();
		pfPwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Signin();
				}
			}
		});
		pfPwd.setBounds(93, 32, 139, 21);
		contentPane.add(pfPwd);

		JButton btnSignin = new JButton("Sign IN");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signin();
			}
		});
		btnSignin.setBounds(12, 60, 220, 23);
		contentPane.add(btnSignin);

		JButton btnSignup = new JButton("Sign UP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUP sup = new SignUP();
				sup.setVisible(true);
				sup.setLocation(150, 150);
			}
		});
		btnSignup.setBounds(12, 126, 220, 23);
		contentPane.add(btnSignup);

		JButton btnidorpwd = new JButton("Forgot ID or Password?");
		btnidorpwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindIDPWD fip = new FindIDPWD();
				fip.setVisible(true);
				fip.setLocation(150, 150);

			}
		});
		btnidorpwd.setBounds(12, 93, 220, 23);
		contentPane.add(btnidorpwd);
	}
	
	public void Signin() {
		int result = 0;
		String id = tfId.getText();
		String pwd = String.valueOf(pfPwd.getPassword());
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		result = dao.login(id, pwd);
		
		if (result == 1) {
			if (id.equals("admin")) {
				//							관리자 페이지 출력
				dto = dao.viewUser(dto.getId());

				ProductAdminPage pap = new ProductAdminPage(id);
				pap.setVisible(true);
				pap.setLocation(300, 300);

				System.out.println("관리자");
				dispose();
			} else {
				//							유져 페이지 출력
				dto = dao.viewUser(dto.getId());

				ProductUserPage pup = new ProductUserPage(id);
				pup.setVisible(true);
				pup.setLocation(300, 300);

				System.out.println("유져");
				dispose();
			}
		} else {
			JOptionPane.showMessageDialog(Login.this, "Check your id or password", "Wrong!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
