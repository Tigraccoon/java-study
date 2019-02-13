package project2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UserList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LoginDAO ldao;
	private LoginDTO ldto = new LoginDTO();
	@SuppressWarnings("rawtypes")
	private Vector cols;
	private DefaultTableModel model;
	private JTextField tfId;
	private JTextField tfPwd;
	private JTextField tfName;
	private JTextField tfHp;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfAmount;
	private JTextField tfPoint;
	private JTextField tfDate;
	private JTextField tfSearch;


	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UserList() {

		ldao = new LoginDAO();
		//제목열 구성
		//'admin','admin','관리자','000-0000-0000','서울','admin@admin.com',9999999,99999999,NOW()
		cols = new Vector();
		cols.add("ID");
		cols.add("Password");
		cols.add("Name");
		cols.add("H.P");
		cols.add("Address");
		cols.add("E-mail");
		cols.add("Amount");
		cols.add("Point");
		cols.add("Date");


		setTitle("Java Shop User List");
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

		tfPoint = new JTextField();
		tfPoint.setColumns(10);
		tfPoint.setBounds(348, 44, 140, 21);
		panel.add(tfPoint);

		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(348, 69, 140, 21);
		panel.add(tfDate);

		JLabel label_6 = new JLabel("회원 관리");
		label_6.setFont(new Font("굴림", Font.BOLD, 14));
		label_6.setBounds(357, 3, 85, 15);
		panel.add(label_6);

		JButton button = new JButton("삭제");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//삭제
				String id = tfId.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(UserList.this, "정말 삭제하시겠습니까?", "Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION) {
					result = ldao.deleteUser(id);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(UserList.this, "삭제되었습니다.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(UserList.this, "삭제에 실패하였습니다.", "Delete Failed", JOptionPane.ERROR_MESSAGE);
				}
				table.setModel(model);
				clear();
				refreshTable();
			}
		});
		button.setBounds(525, 100, 97, 23);
		panel.add(button);

		JButton button_1 = new JButton("수정");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = ldao.updateUser(ldto);
				if (result == 1) {
					JOptionPane.showMessageDialog(UserList.this, "수정되었습니다.", "Updated", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(UserList.this, "업데이트에 실패하였습니다.", "Update Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				table.setModel(model);
				clear();
				refreshTable();
				
			}
		});
		button_1.setBounds(525, 50, 97, 23);
		panel.add(button_1);

		JButton button_2 = new JButton("추가");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = ldao.insertUser(ldto);
				if (result == 1) {	//잘 들어왔으면?
					JOptionPane.showMessageDialog(UserList.this, "저장되었습니다.", "Saved", JOptionPane.PLAIN_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(UserList.this, "저장에 실패하였습니다.", "Save Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				table.setModel(model);
				clear();
				refreshTable();
			}
		});
		button_2.setBounds(525, 75, 97, 23);
		panel.add(button_2);

		JButton button_3 = new JButton("Search");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		button_3.setBounds(653, 21, 97, 23);
		panel.add(button_3);

		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(546, 22, 95, 21);
		panel.add(tfSearch);

		JLabel lblNewLabel = new JLabel("이름으로 검색");
		lblNewLabel.setBounds(597, 3, 97, 15);
		panel.add(lblNewLabel);

		JButton btnClear = new JButton("초기화");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//초기화
				
			}
		});
		btnClear.setBounds(391, 100, 97, 23);
		panel.add(btnClear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(12, 76, 770, 236);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				
				tfId.setText(String.valueOf(table.getValueAt(idx, 0)));
				tfPwd.setText(String.valueOf(table.getValueAt(idx, 1)));
				tfName.setText(String.valueOf(table.getValueAt(idx, 2)));
				tfHp.setText(String.valueOf(table.getValueAt(idx, 3)));
				tfAddress.setText(String.valueOf(table.getValueAt(idx, 4)));
				tfEmail.setText(String.valueOf(table.getValueAt(idx, 5)));
				tfAmount.setText(String.valueOf(table.getValueAt(idx, 6)));
				tfPoint.setText(String.valueOf(table.getValueAt(idx, 7)));
				tfDate.setText(String.valueOf(table.getValueAt(idx, 8)));
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		refreshTable();
	}

	public void refreshTable() {
		model = new DefaultTableModel(ldao.userList(),cols) {
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
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(5).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(7).setPreferredWidth(10);
		table.getColumnModel().getColumn(7).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(8).setPreferredWidth(10);
		table.getColumnModel().getColumn(8).setCellRenderer(celAlignCenter);
	}
	
	public void clear() {
		tfId.setText("");
		tfPwd.setText("");
		tfName.setText("");
		tfHp.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfAmount.setText("");
		tfPoint.setText("");
		tfDate.setText("");
	}
	
	public void search() {
		String name = tfSearch.getText();
		model = new DefaultTableModel(ldao.searchUser(name),cols){
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
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(5).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(7).setPreferredWidth(10);
		table.getColumnModel().getColumn(7).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(8).setPreferredWidth(10);
		table.getColumnModel().getColumn(8).setCellRenderer(celAlignCenter);
	}
	
	public void input() {
		String id = tfId.getText();
		String pwd = tfPwd.getText();
		String name = tfName.getText();
		String hp = tfHp.getText();
		String address = tfAddress.getText();
		String email = tfEmail.getText();
		int amount = Integer.parseInt(tfAmount.getText());
		int point = Integer.parseInt(tfPoint.getText());
		Date date = Date.valueOf(tfDate.getText());
		
		ldto = new LoginDTO(id, pwd, name, hp, address, email, amount, point, date);
	}
	
}
