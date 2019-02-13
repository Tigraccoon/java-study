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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class SetUser extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField pfPwd;
	private JTextField tfName;
	private JTextField tfHp;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private LoginDAO dao = new LoginDAO();
	private JLabel lblPwdText;

	/**
	 * Create the frame.
	 */
	public SetUser(LoginDTO dto) {
		setTitle("Your Profile");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 397, 251);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("User ID : ");
		label.setBounds(12, 13, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Password : ");
		label_1.setBounds(12, 38, 69, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Name : ");
		label_2.setBounds(12, 63, 57, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Phone Number : ");
		label_3.setBounds(12, 88, 97, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Home Address");
		label_4.setBounds(12, 113, 97, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("E-mail : ");
		label_5.setBounds(12, 138, 57, 15);
		contentPane.add(label_5);
		
		tfId = new JTextField(dto.getId());
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(127, 10, 116, 21);
		contentPane.add(tfId);
		
		pfPwd = new JPasswordField(dto.getPwd());
		pfPwd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pwdText = String.valueOf(pfPwd.getPassword());
				if (pwdText.length() < 4) {
					lblPwdText.setForeground(Color.RED);
					lblPwdText.setText("Password < 4");
				} else {
					lblPwdText.setForeground(Color.blue);
					lblPwdText.setText("O");
				}
			}
		});
		pfPwd.setBounds(127, 35, 116, 21);
		contentPane.add(pfPwd);
		
		tfName = new JTextField(dto.getName());
		tfName.setColumns(10);
		tfName.setBounds(127, 60, 116, 21);
		contentPane.add(tfName);
		
		tfHp = new JTextField(dto.getHp());
		tfHp.setColumns(10);
		tfHp.setBounds(127, 85, 116, 21);
		contentPane.add(tfHp);
		
		tfAddress = new JTextField(dto.getAddress());
		tfAddress.setColumns(10);
		tfAddress.setBounds(127, 110, 247, 21);
		contentPane.add(tfAddress);
		
		tfEmail = new JTextField(dto.getEmail());
		tfEmail.setEditable(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(127, 135, 247, 21);
		contentPane.add(tfEmail);
		
		
		JButton btnDone = new JButton("Update Profile");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result;
				int stack=0;
				String id = tfId.getText();
				if(id.equals("")) stack++;
				String pwd = String.valueOf(pfPwd.getPassword());
				if(pwd.equals("")) stack++;
				String name = tfName.getText();
				if(name.equals("")) stack++;
				String hp = tfHp.getText();
				if(hp.equals("")) stack++;
				String address = tfAddress.getText();
				if(address.equals("")) stack++;
				String email = tfEmail.getText();
				if(email.equals(""))stack++;
				LoginDTO dto2 = new LoginDTO(id, pwd, name, hp, address, email);
				result = dao.updateUser(dto2);
				if (result == 1 && stack==0) {//수정 성공시
					JOptionPane.showMessageDialog(SetUser.this, "Update succeeded!", "Succeeded!", JOptionPane.PLAIN_MESSAGE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(SetUser.this, "Missing input", "failed...", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDone.setBounds(127, 166, 116, 23);
		contentPane.add(btnDone);
		
		JButton btnDeleteProfile = new JButton("Delete Profile");
		btnDeleteProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tfId.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(SetUser.this, "Are you sure you want to DELETE your Profile?", "Delete?", JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					result = dao.deleteUser(id);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(SetUser.this, "Profile Deleted!", "Deleted!", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				} 
			}
		});
		btnDeleteProfile.setBounds(238, 190, 136, 23);
		contentPane.add(btnDeleteProfile);
		
		lblPwdText = new JLabel("");
		lblPwdText.setBounds(255, 38, 119, 15);
		contentPane.add(lblPwdText);
	}
}
