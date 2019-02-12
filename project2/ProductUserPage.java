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
public class ProductUserPage extends JFrame {

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
	private DefaultTableModel model;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductUserPage frame = new ProductUserPage();
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
	public ProductUserPage() {}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ProductUserPage(String id) {

		pdao = new ProductDAO();
		ldao = new LoginDAO();
		ldto = ldao.viewUser(id);
		//제목열 구성
		cols = new Vector();
		cols.add("상품코드");
		cols.add("상품명");
		cols.add("가격($)");
		cols.add("잔고수량");

		setTitle("Java Shop");
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

		btnSetting = new JButton("Profile Update");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetUser su = new SetUser(ldto);
				su.setVisible(true);
				su.setLocation(300, 300);
			}
		});
		btnSetting.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		btnSetting.setBounds(12, 166, 155, 33);
		panel.add(btnSetting);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 76, 579, 327);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Buy for TEL : 1599-9999");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("경기천년제목 Light", Font.PLAIN, 38));
		lblNewLabel.setBounds(12, 413, 770, 49);
		contentPane.add(lblNewLabel);
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
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
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
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
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
