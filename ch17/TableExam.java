package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class TableExam extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableExam frame = new TableExam();
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
	public TableExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		//표(table)의 제목열(header)
		String[] title = {"번호","이름","입사일자"};
		//표의 데이터(rows)
		String[][] data = 	{{"1","kim","2019-01-01"},
							{"2","park","2017-02-01"},
							{"3","hong","2018-03-01"}
							};
		//new JTable(rows,header)
		table = new JTable(data, title);
		scrollPane.setViewportView(table);
	}

}
