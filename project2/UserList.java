package project2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class UserList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LoginDAO ldao;
	private LoginDTO ldto = new LoginDTO();
	@SuppressWarnings("rawtypes")
	private Vector cols;
	private ProductDAO pdao;
	private DefaultTableModel model;
	private JTextField tfId;
	private JTextField tfPwd;
	private JTextField tfName;
	private JTextField tfHp;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfAmount;
	private JTextField tfPoing;
	private JTextField tfDate;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserList frame = new UserList();
					frame.setVisible(false);
					Login log = new Login();
					log.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UserList() {

		pdao = new ProductDAO();
		ldao = new LoginDAO();
		//제목열 구성
		cols = new Vector();
		cols.add("상품코드");
		cols.add("상품명");
		cols.add("가격($)");
		cols.add("잔고수량");

		setTitle("Java Shop Administrator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblJavaShop = new JLabel("Java Shop User List");
		lblJavaShop.setBackground(Color.WHITE);
		lblJavaShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblJavaShop.setFont(new Font("Consolas", Font.PLAIN, 58));
		lblJavaShop.setForeground(Color.BLACK);
		lblJavaShop.setBounds(12, 10, 770, 56);
		contentPane.add(lblJavaShop);

		JPanel panel = new JPanel();
		panel.setBounds(12, 318, 770, 144);
		contentPane.add(panel);
		panel.setLayout(null);
						
						JLabel label = new JLabel("User ID : ");
						label.setBounds(12, 3, 57, 15);
						panel.add(label);
						
						JLabel label_1 = new JLabel("Password : ");
						label_1.setBounds(12, 25, 69, 15);
						panel.add(label_1);
						
						JLabel label_2 = new JLabel("Name : ");
						label_2.setBounds(12, 50, 57, 15);
						panel.add(label_2);
						
						JLabel label_3 = new JLabel("Phone Number : ");
						label_3.setBounds(12, 75, 97, 15);
						panel.add(label_3);
						
						JLabel label_4 = new JLabel("Home Address");
						label_4.setBounds(12, 100, 97, 15);
						panel.add(label_4);
						
						JLabel label_5 = new JLabel("E-mail : ");
						label_5.setBounds(12, 125, 57, 15);
						panel.add(label_5);
						
						tfId = new JTextField();
						tfId.setBounds(119, 0, 140, 21);
						panel.add(tfId);
						tfId.setColumns(10);
						
						tfPwd = new JTextField();
						tfPwd.setColumns(10);
						tfPwd.setBounds(119, 22, 140, 21);
						panel.add(tfPwd);
						
						tfName = new JTextField();
						tfName.setColumns(10);
						tfName.setBounds(119, 47, 140, 21);
						panel.add(tfName);
						
						tfHp = new JTextField();
						tfHp.setColumns(10);
						tfHp.setBounds(119, 72, 140, 21);
						panel.add(tfHp);
						
						tfAddress = new JTextField();
						tfAddress.setColumns(10);
						tfAddress.setBounds(119, 97, 231, 21);
						panel.add(tfAddress);
						
						tfEmail = new JTextField();
						tfEmail.setColumns(10);
						tfEmail.setBounds(119, 119, 231, 21);
						panel.add(tfEmail);
						
						JLabel lblAmount = new JLabel("Amount : ");
						lblAmount.setBounds(291, 25, 57, 15);
						panel.add(lblAmount);
						
						JLabel lblPoint = new JLabel("Point : ");
						lblPoint.setBounds(291, 47, 57, 15);
						panel.add(lblPoint);
						
						JLabel lblDate = new JLabel("Date : ");
						lblDate.setBounds(291, 72, 57, 15);
						panel.add(lblDate);
						
						tfAmount = new JTextField();
						tfAmount.setColumns(10);
						tfAmount.setBounds(348, 22, 140, 21);
						panel.add(tfAmount);
						
						tfPoing = new JTextField();
						tfPoing.setColumns(10);
						tfPoing.setBounds(348, 44, 140, 21);
						panel.add(tfPoing);
						
						tfDate = new JTextField();
						tfDate.setColumns(10);
						tfDate.setBounds(348, 69, 140, 21);
						panel.add(tfDate);
						
						JLabel label_6 = new JLabel("회원 관리");
						label_6.setFont(new Font("굴림", Font.BOLD, 14));
						label_6.setBounds(357, 3, 85, 15);
						panel.add(label_6);
						
						JButton button = new JButton("삭제");
						button.setBounds(653, 100, 97, 23);
						panel.add(button);
						
						JButton button_1 = new JButton("수정");
						button_1.setBounds(391, 100, 97, 23);
						panel.add(button_1);
						
						JButton button_2 = new JButton("추가");
						button_2.setBounds(525, 100, 97, 23);
						panel.add(button_2);
						
						JButton button_3 = new JButton("Search");
						button_3.setBounds(653, 21, 97, 23);
						panel.add(button_3);
						
						textField_3 = new JTextField();
						textField_3.setColumns(10);
						textField_3.setBounds(546, 22, 95, 21);
						panel.add(textField_3);
						
						JLabel lblNewLabel = new JLabel("이름으로 검색");
						lblNewLabel.setBounds(597, 3, 97, 15);
						panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 76, 770, 236);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scrollPane.setViewportView(table);
		refreshTable();
	}
	
	public void refreshTable() {
		model = new DefaultTableModel(pdao.productList(),cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table.setModel(model);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);
	}
}
