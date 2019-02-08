package ch21;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ProductList extends JFrame {

	private ProductDAO dao;
	private ProductDTO dto;
	private Vector<String> col;
	private DefaultTableModel model;
	
	private JPanel contentPane;
	private JTextField tfPnum;
	private JTextField tfPlocal;
	private JTextField tfPname;
	private JTextField tfCompany;
	private JTextField tfAcc;
	private JTextField tfPrice;
	private JTextField tfTot;
	private JTextField tfSearch;
	private JTable table;
	private JButton btnDel;
	private JButton btnUpd;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList frame = new ProductList();
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
	public ProductList() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dao = new ProductDAO();
		col = new Vector<String>();
		col.add("제품 번호");
		col.add("지점");
		col.add("제품명");
		col.add("제조사");
		col.add("단가");
		col.add("수량");
		col.add("총액");
		
		list();
		
		JLabel label = new JLabel("제품 번호 : ");
		label.setBounds(12, 10, 71, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("지점 : ");
		lblNewLabel.setBounds(12, 35, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("제품명 : ");
		lblNewLabel_1.setBounds(12, 60, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("제조사 : ");
		lblNewLabel_2.setBounds(12, 85, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("단가 : ");
		lblNewLabel_3.setBounds(235, 10, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("수량 : ");
		label_1.setBounds(235, 35, 57, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("총액 : ");
		label_2.setBounds(235, 60, 57, 15);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_4 = new JLabel("제품명 검색 : ");
		lblNewLabel_4.setBounds(235, 85, 82, 15);
		contentPane.add(lblNewLabel_4);
		
		tfPnum = new JTextField();
		tfPnum.setBounds(81, 7, 142, 21);
		contentPane.add(tfPnum);
		tfPnum.setColumns(10);
		
		tfPlocal = new JTextField();
		tfPlocal.setBounds(81, 32, 142, 21);
		contentPane.add(tfPlocal);
		tfPlocal.setColumns(10);
		
		tfPname = new JTextField();
		tfPname.setBounds(81, 57, 142, 21);
		contentPane.add(tfPname);
		tfPname.setColumns(10);
		
		tfCompany = new JTextField();
		tfCompany.setBounds(81, 82, 142, 21);
		contentPane.add(tfCompany);
		tfCompany.setColumns(10);
		
		tfAcc = new JTextField();
		tfAcc.setBounds(329, 32, 154, 21);
		contentPane.add(tfAcc);
		tfAcc.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(329, 7, 154, 21);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfTot = new JTextField();
		tfTot.setEditable(false);
		tfTot.setBounds(329, 57, 154, 21);
		contentPane.add(tfTot);
		tfTot.setColumns(10);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		tfSearch.setBounds(329, 82, 154, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				//레코드에 저장
				int result = dao.insertProduct(dto);
				if (result == 1) {	//잘 들어왔으면?
					JOptionPane.showMessageDialog(ProductList.this, "저장되었습니다.", "Saved", JOptionPane.PLAIN_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(ProductList.this, "저장에 실패하였습니다.", "Save Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				list();
				table.setModel(model);
				clear();
				
			}
		});
		btnSave.setBounds(495, 6, 97, 21);
		contentPane.add(btnSave);
		
		btnDel = new JButton("삭제");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String product_no = tfPnum.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(ProductList.this, "정말 삭제하시겠습니까?", "Delete?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION) {
					result = dao.deleteProduct(product_no);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(ProductList.this, "삭제되었습니다.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ProductList.this, "삭제에 실패하였습니다.", "Delete Failed", JOptionPane.ERROR_MESSAGE);
				}
				list();
				table.setModel(model);
				clear();
			}
		});
		btnDel.setBounds(495, 56, 97, 21);
		contentPane.add(btnDel);
		
		btnUpd = new JButton("수정");
		btnUpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.updateProduct(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ProductList.this, "수정되었습니다.", "Updated", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(ProductList.this, "업데이트에 실패하였습니다.", "Update Failed", JOptionPane.ERROR_MESSAGE);
				}
				
				list();
				table.setModel(model);
				clear();
			}
		});
		btnUpd.setBounds(495, 31, 97, 21);
		contentPane.add(btnUpd);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(495, 81, 97, 21);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 113, 580, 399);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
//				tfPnum.setEditable(false);
				
				tfPnum.setText(String.valueOf(table.getValueAt(index, 0)));
				tfPlocal.setText(String.valueOf(table.getValueAt(index, 1)));
				tfPname.setText(String.valueOf(table.getValueAt(index, 2)));
				tfCompany.setText(String.valueOf(table.getValueAt(index, 3)));
				tfPrice.setText(String.valueOf(table.getValueAt(index, 4)));
				tfAcc.setText(String.valueOf(table.getValueAt(index, 5)));
				tfTot.setText(String.valueOf(table.getValueAt(index, 6)));
			}
		});
		scrollPane.setViewportView(table);
	}
	
	public void list() {
		model = new DefaultTableModel(dao.listProduct(),col){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}//list

	public void search() {
		String pname = tfSearch.getText();
		model = new DefaultTableModel(dao.searchProduct(pname), col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}
	
	public void input() {
		String product_no = tfPnum.getText();
		String plocal = tfPlocal.getText();
		String pname = tfPname.getText();
		String company = tfCompany.getText();
		int uprice = Integer.parseInt(tfPrice.getText());
		int acc = Integer.parseInt(tfAcc.getText());
		
		dto = new ProductDTO(product_no, plocal, pname, company, uprice, acc);
	}
	
	public void clear() {
		tfPnum.setText("");
		tfPlocal.setText("");
		tfPname.setText("");
		tfCompany.setText("");
		tfPrice.setText("");
		tfAcc.setText("");
		tfTot.setText("");
	}
}
