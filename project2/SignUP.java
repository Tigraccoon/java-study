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

@SuppressWarnings("serial")
public class SignUP extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JPasswordField pfPwd;
	private JTextField tfName;
	private JTextField tfHp;
	private JTextField tfAddress;
	private JTextField tfEmail;

	/**
	 * Create the frame.
	 */
	public SignUP() {
		setTitle("Join our MEMBER!!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 221);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("User ID : ");
		lblId.setBounds(12, 10, 57, 15);
		contentPane.add(lblId);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(12, 35, 69, 15);
		contentPane.add(lblPassword);

		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(12, 60, 57, 15);
		contentPane.add(lblName);

		JLabel lblPhoneNumber = new JLabel("Phone Number : ");
		lblPhoneNumber.setBounds(12, 85, 97, 15);
		contentPane.add(lblPhoneNumber);

		JLabel lblHomeAddress = new JLabel("Home Address");
		lblHomeAddress.setBounds(12, 110, 97, 15);
		contentPane.add(lblHomeAddress);

		JLabel lblEmail = new JLabel("E-mail : ");
		lblEmail.setBounds(12, 135, 57, 15);
		contentPane.add(lblEmail);

		tfID = new JTextField();
		tfID.setBounds(127, 7, 116, 21);
		contentPane.add(tfID);
		tfID.setColumns(10);

		pfPwd = new JPasswordField();
		pfPwd.setBounds(127, 32, 116, 21);
		contentPane.add(pfPwd);

		tfName = new JTextField();
		tfName.setBounds(127, 57, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfHp = new JTextField();
		tfHp.setBounds(127, 82, 116, 21);
		contentPane.add(tfHp);
		tfHp.setColumns(10);

		tfAddress = new JTextField();
		tfAddress.setBounds(127, 107, 247, 21);
		contentPane.add(tfAddress);
		tfAddress.setColumns(10);

		tfEmail = new JTextField();
		tfEmail.setBounds(127, 132, 247, 21);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);

		JButton btnCreateAnAccount = new JButton("Create an Account!");
		btnCreateAnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tfID.getText();
				String pwd = String.valueOf(pfPwd.getPassword());
				String name = tfName.getText();
				String hp = tfHp.getText();
				String address = tfAddress.getText();
				String email = tfEmail.getText();
				
				LoginDTO dto = new LoginDTO(id, pwd, name, hp, address, email);
				LoginDAO dao = new LoginDAO();
				int result = dao.insertUser(dto);
				if (result == 1) {	
					JOptionPane.showMessageDialog(SignUP.this, "Enjoy your Shopping! ", "Succeeded", JOptionPane.PLAIN_MESSAGE);
					dispose();
				}
			}
		});
		btnCreateAnAccount.setBounds(127, 160, 143, 23);
		contentPane.add(btnCreateAnAccount);
	}
}

