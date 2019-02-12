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
public class SetUser extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField pfPwd;
	private JTextField tfName;
	private JTextField tfHp;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private LoginDAO dao = new LoginDAO();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetUser frame = new SetUser();
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
	public SetUser(LoginDTO dto) {
		setTitle("Your Profile");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 397, 247);
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
		tfEmail.setColumns(10);
		tfEmail.setBounds(127, 135, 247, 21);
		contentPane.add(tfEmail);
		
		
		JButton btnDone = new JButton("Update Profile");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result;
				String id = tfId.getText();
				String pwd = String.valueOf(pfPwd.getPassword());
				String name = tfName.getText();
				String hp = tfHp.getText();
				String address = tfAddress.getText();
				String email = tfEmail.getText();
				LoginDTO dto2 = new LoginDTO(id, pwd, name, hp, address, email);
				result = dao.updateUser(dto2);
				if (result == 1) {//수정 성공시
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
				int response = JOptionPane.showConfirmDialog(SetUser.this, "Are you sure you want to DELETE your Profile?", "Delete?", JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					result = dao.deleteUser(id);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(SetUser.this, "Profile Deleted!", "Deleted!", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				} 
			}
		});
		btnDeleteProfile.setBounds(272, 186, 107, 23);
		contentPane.add(btnDeleteProfile);
	}
}
