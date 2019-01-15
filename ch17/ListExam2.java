package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ListExam2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCountryName;
	private JTextField tf;
	private JList<Object> list;
	private JScrollPane scrollPane;
	private DefaultListModel<Object> model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListExam2 frame = new ListExam2();
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
	public ListExam2() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		model = new DefaultListModel<>();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtCountryName = new JTextField();
		txtCountryName.setFont(new Font("굴림", Font.PLAIN, 15));
		txtCountryName.setForeground(Color.WHITE);
		txtCountryName.setBackground(Color.GRAY);
		txtCountryName.setEnabled(false);
		txtCountryName.setEditable(false);
		txtCountryName.setText("country name : ");
		panel.add(txtCountryName);
		txtCountryName.setColumns(10);
		
		tf = new JTextField();
		tf.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(tf);
		tf.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(tf.getText());
				list.setModel(model);
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(btnAdd);
		
		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				if(selectedIndex != -1) {
					model.remove(selectedIndex);
				}
			}
		});
		panel.add(btnDel);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		model.addElement("한국");
		model.addElement("미국");
		model.addElement("영국");
		model.addElement("일본");
		model.addElement("중국");
		model.addElement("인도");
		model.addElement("대만");
		model.addElement("싱가폴");
		model.addElement("프랑스");
		model.addElement("멕시코");
		model.addElement("독일");
		model.addElement("이집트");
		model.addElement("UAE");
		model.addElement("파키스탄");
		
		
		list = new JList<Object>(model);
		list.setBackground(Color.LIGHT_GRAY);
		list.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(list);
	}

}
