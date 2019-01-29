package ch21;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class AddressGUIManage extends JFrame {
	AddressDAO dao = new AddressDAO();
	private JPanel contentPane;
	private JTextField tfEmail;
	private JTextField tfAddress;
	private JTextField tfHp;
	private JTextField tfName;
	private JTextArea ta;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnList;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressGUIManage frame = new AddressGUIManage();
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
	public AddressGUIManage() {
		setTitle("Address");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmale = new JLabel("E-mail : ");
		lblEmale.setAutoscrolls(true);
		lblEmale.setBounds(12, 10, 74, 15);
		contentPane.add(lblEmale);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(12, 35, 74, 15);
		contentPane.add(lblAddress);
		
		JLabel lblHp = new JLabel("HP : ");
		lblHp.setBounds(12, 60, 74, 15);
		contentPane.add(lblHp);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(12, 85, 74, 15);
		contentPane.add(lblName);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(98, 7, 194, 21);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(98, 32, 194, 21);
		contentPane.add(tfAddress);
		tfAddress.setColumns(10);
		
		tfHp = new JTextField();
		tfHp.setBounds(98, 57, 194, 21);
		contentPane.add(tfHp);
		tfHp.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(98, 82, 194, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
				clear();
				list();
			}
		});
		btnAdd.setBounds(98, 113, 74, 23);
		contentPane.add(btnAdd);
		
		btnDel = new JButton("Delete Name");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				clear();
				list();
			}
		});
		btnDel.setBounds(185, 113, 107, 23);
		contentPane.add(btnDel);
		
		btnList = new JButton("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				list();
			}
		});
		btnList.setBounds(12, 113, 74, 23);
		contentPane.add(btnList);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 146, 280, 343);
		contentPane.add(scrollPane);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ta.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		ta.setLineWrap(true);
		ta.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta.setEditable(true);
		
	}
	
	public void clear() {
		ta.setText("");
		tfEmail.setText("");
		tfName.setText("");
		tfAddress.setText("");
		tfHp.setText("");
	}//clear
	
	public void list () {
		List<AddressDTO> list = dao.list();
		
		for(AddressDTO dto : list) {
			ta.append("----------------------------------\r\n");
			ta.append("Email : "+dto.getEmail()+"\r\n");
			ta.append("Name : "+dto.getName()+"\r\n");
			ta.append("Address : "+dto.getAddr()+"\r\n");
			ta.append("HP : "+dto.getHp()+"\r\n");
			
		}
		
	}//list
	
	
	public void add() {
		String email = tfEmail.getText();
		String name = tfName.getText();
		String addr = tfAddress.getText();
		String hp = tfHp.getText();
		
		AddressDTO dto = new AddressDTO(email, name, addr, hp);
		
		dao.insert(dto);
		
		JOptionPane.showMessageDialog(this, "등록되었습니다.", "Added", JOptionPane.PLAIN_MESSAGE);
		
	}//add
	
	public void delete() {
		String name = tfName.getText();
		int result = dao.delete(name);
		if (result == 1) {
			JOptionPane.showMessageDialog(this, "삭제되었습니다.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "이름을 확인하십시오.", "Delete Failed", JOptionPane.ERROR_MESSAGE);

		}
		
	}//delete
	
}
