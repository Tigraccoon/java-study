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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ProductAdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfSearch;
	private JTable table;
	private JLabel lblname;
	private JButton btnSetting;
	private JLabel lblamount;
	private JLabel lblpoint;
	private JLabel lbldate;
	private LoginDAO ldao;
	private LoginDTO ldto = new LoginDTO();
	@SuppressWarnings("rawtypes")
	private Vector cols;
	private ProductDAO pdao;
	private ProductDTO pdto = new ProductDTO();
	private DefaultTableModel model;
	private JTextField tfPcode;
	private JTextField tfPname;
	private JTextField tfPrice;
	private JTextField tfPamount;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductAdminPage frame = new ProductAdminPage();
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
	public ProductAdminPage() {}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ProductAdminPage(String id) {

		pdao = new ProductDAO();
		ldao = new LoginDAO();
		ldto = ldao.viewUser(id);
		//제목열 구성
		cols = new Vector();
		cols.add("상품코드");
		cols.add("상품명");
		cols.add("가격($)");
		cols.add("잔고수량");

		setTitle("Java Shop Administrator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblJavaShop = new JLabel("Java Shop");
		lblJavaShop.setBackground(Color.WHITE);
		lblJavaShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblJavaShop.setFont(new Font("Consolas", Font.PLAIN, 58));
		lblJavaShop.setForeground(Color.BLACK);
		lblJavaShop.setBounds(12, 10, 770, 56);
		contentPane.add(lblJavaShop);

		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		tfSearch.setBounds(12, 76, 95, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(112, 75, 79, 23);
		contentPane.add(btnSearch);

		JPanel panel = new JPanel();
		panel.setBounds(12, 107, 179, 296);
		contentPane.add(panel);
		panel.setLayout(null);

		lblname = new JLabel(String.valueOf(ldto.getName()));
		lblname.setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		lblname.setBounds(18, 10, 111, 26);
		panel.add(lblname);

		JLabel lblam = new JLabel("구매액 : ");
		lblam.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		lblam.setHorizontalAlignment(SwingConstants.CENTER);
		lblam.setBounds(0, 46, 55, 26);
		panel.add(lblam);

		JLabel lblNewLabel_2 = new JLabel("님");
		lblNewLabel_2.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(125, 10, 26, 26);
		panel.add(lblNewLabel_2);

		lblamount = new JLabel(String.valueOf(ldto.getAmount()));
		lblamount.setHorizontalAlignment(SwingConstants.CENTER);
		lblamount.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		lblamount.setBounds(60, 46, 107, 26);
		panel.add(lblamount);

		JLabel label = new JLabel("$");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		label.setBounds(160, 46, 19, 26);
		panel.add(label);

		JLabel lblpointaa = new JLabel("포인트 : ");
		lblpointaa.setHorizontalAlignment(SwingConstants.CENTER);
		lblpointaa.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		lblpointaa.setBounds(0, 82, 55, 26);
		panel.add(lblpointaa);

		lblpoint = new JLabel(String.valueOf(ldto.getPoint()));
		lblpoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblpoint.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		lblpoint.setBounds(60, 82, 107, 26);
		panel.add(lblpoint);

		JLabel label_1 = new JLabel("가입일 : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		label_1.setBounds(0, 118, 55, 26);
		panel.add(label_1);

		lbldate = new JLabel(String.valueOf(ldto.getDate()));
		lbldate.setHorizontalAlignment(SwingConstants.CENTER);
		lbldate.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		lbldate.setBounds(60, 118, 107, 26);
		panel.add(lbldate);

		btnSetting = new JButton("회원 관리");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserList ul = new UserList();
				ul.setVisible(true);
				ul.setLocation(300, 300);
			}
		});
		btnSetting.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		btnSetting.setBounds(12, 166, 155, 33);
		panel.add(btnSetting);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 76, 579, 327);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				
				tfPcode.setText(String.valueOf(table.getValueAt(idx, 0)));
				tfPname.setText(String.valueOf(table.getValueAt(idx, 1)));
				tfPrice.setText(String.valueOf(table.getValueAt(idx, 2)));
				tfPamount.setText(String.valueOf(table.getValueAt(idx, 3)));
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("상품 코드 : ");
		label_2.setBounds(12, 413, 64, 15);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("상품명 : ");
		lblNewLabel.setBounds(248, 413, 64, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("가격 : ");
		lblNewLabel_1.setBounds(12, 447, 59, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("수량 : ");
		lblNewLabel_3.setBounds(248, 447, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		tfPcode = new JTextField();
		tfPcode.setEditable(false);
		tfPcode.setBounds(78, 410, 158, 21);
		contentPane.add(tfPcode);
		tfPcode.setColumns(10);
		
		tfPname = new JTextField();
		tfPname.setBounds(300, 410, 264, 21);
		contentPane.add(tfPname);
		tfPname.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(78, 444, 158, 21);
		contentPane.add(tfPrice);
		
		tfPamount = new JTextField();
		tfPamount.setColumns(10);
		tfPamount.setBounds(300, 444, 106, 21);
		contentPane.add(tfPamount);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				int result = pdao.updateProduct(pdto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ProductAdminPage.this, "수정되었습니다.", "Updated", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(ProductAdminPage.this, "업데이트에 실패하였습니다.", "Update Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				table.setModel(model);
				clear();
				refreshTable();
			}
		});
		btnUpdate.setBounds(467, 443, 97, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pcode = Integer.parseInt(tfPcode.getText());
				int result = 0;
				int response = JOptionPane.showConfirmDialog(ProductAdminPage.this, "정말 삭제하시겠습니까?", "Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION) {
					result = pdao.deleteProduct(pcode);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(ProductAdminPage.this, "삭제되었습니다.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ProductAdminPage.this, "삭제에 실패하였습니다.", "Delete Failed", JOptionPane.ERROR_MESSAGE);
				}
				table.setModel(model);
				clear();
				refreshTable();
				
			}
		});
		btnDelete.setBounds(685, 443, 97, 23);
		contentPane.add(btnDelete);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = pdao.insertProduct(pdto);
				if (result == 1) {	//잘 들어왔으면?
					JOptionPane.showMessageDialog(ProductAdminPage.this, "저장되었습니다.", "Saved", JOptionPane.PLAIN_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(ProductAdminPage.this, "저장에 실패하였습니다.", "Save Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				table.setModel(model);
				clear();
				refreshTable();
			}
		});
		btnAdd.setBounds(576, 443, 97, 23);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel_4 = new JLabel("상품 관리");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(455, 413, 315, 15);
		contentPane.add(lblNewLabel_4);
		
		JButton btnClear = new JButton("초기화");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(685, 413, 97, 23);
		contentPane.add(btnClear);
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
	
	public void search() {
		String pname = tfSearch.getText();
		model = new DefaultTableModel(pdao.searchProduct(pname), cols) {
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
	
	public void input() {
		String pname = tfPname.getText();
		int price = Integer.parseInt(tfPrice.getText());
		int pamount = Integer.parseInt(tfPamount.getText());
		pdto = new ProductDTO(pname, price, pamount);
		
	}
	
	public void update() {
		int pcode = Integer.parseInt(tfPcode.getText());
		String pname = tfPname.getText();
		int price = Integer.parseInt(tfPrice.getText());
		int pamount = Integer.parseInt(tfPamount.getText());
		pdto = new ProductDTO(pcode,pname, price, pamount);
		
	}
	
	public void clear() {
		tfPcode.setText("");
		tfPname.setText("");
		tfPrice.setText("");
		tfPamount.setText("");
	}
	
}
