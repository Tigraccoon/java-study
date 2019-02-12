package project2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FindIDPWD extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;

	/**
	 * Create the frame.
	 */
	public FindIDPWD() {
		setTitle("Let's Find Out!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 412, 150);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputYourEmail = new JLabel("Enter your E-mail address and we will show your ID and Password");
		lblInputYourEmail.setBounds(12, 10, 389, 36);
		contentPane.add(lblInputYourEmail);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=0;
				String email = tfEmail.getText();
				LoginDAO dao = new LoginDAO();
				LoginDTO dto = new LoginDTO();
				System.out.println("1\t"+dto.toString());
				response = dao.findUser(email);
				System.out.println("3\t"+dto.toString());
				
				if (response == 1) {
					String id = dao.getId();
					String pwd = dao.getPwd();
					JOptionPane.showMessageDialog(FindIDPWD.this, "ID : "+id+"\r\n"+"Password : "+pwd, "Here you are~", 
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else if (response == 0){
					JOptionPane.showMessageDialog(FindIDPWD.this, "Check your E-Mail", ":-(", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnFind.setBounds(149, 89, 97, 23);
		contentPane.add(btnFind);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(12, 56, 382, 21);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
	}

}
