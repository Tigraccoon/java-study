package project2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ProductAdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLabel lblname;
	private JButton btnSetting;
	private JLabel lblamount;
	private JLabel lblpoint;
	private JLabel lbldate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductAdminPage frame = new ProductAdminPage();
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
	public ProductAdminPage() {
		setTitle("JavaShop Administrator page");
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
		
		textField = new JTextField();
		textField.setBounds(12, 76, 101, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(118, 75, 73, 23);
		contentPane.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 107, 179, 296);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblname = new JLabel("");
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
		
		lblamount = new JLabel("");
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
		
		lblpoint = new JLabel("");
		lblpoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblpoint.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		lblpoint.setBounds(60, 82, 107, 26);
		panel.add(lblpoint);
		
		JLabel label_1 = new JLabel("가입일 : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		label_1.setBounds(0, 118, 55, 26);
		panel.add(label_1);
		
		lbldate = new JLabel("");
		lbldate.setHorizontalAlignment(SwingConstants.CENTER);
		lbldate.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		lbldate.setBounds(60, 118, 107, 26);
		panel.add(lbldate);
		
		btnSetting = new JButton("회원정보 수정");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSetting.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		btnSetting.setBounds(12, 177, 155, 33);
		panel.add(btnSetting);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 76, 579, 327);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("구입 문의 : 1599-9999");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("경기천년제목 Light", Font.PLAIN, 38));
		lblNewLabel.setBounds(12, 413, 770, 49);
		contentPane.add(lblNewLabel);
	}
}
