package ch19;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FileRead extends JFrame {

	//엔코딩 타입이 틀리면 글자가 깨짐. 한글은 UTF-8방식으로 저장해야 잘 읽힘
	
	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileRead frame = new FileRead();
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
	public FileRead() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblFileName = new JLabel("File Name : ");
		panel.add(lblFileName);
		
		tf = new JTextField();
		panel.add(tf);
		tf.setColumns(15);
		
		JButton button1 = new JButton("Enter");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = tf.getText();
				String str = "";
				BufferedReader reader = null;
				//프로그램 -> 파일 (OutputStream)
				//파일 -> 프로그램 (InputStream)
				
				try {
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					//FileInputStream은 파일 내용을 읽어오는 Stream
					ta.setText("");
					while((str = reader.readLine()) != null) {
						ta.append(str+"\n");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if (reader != null) {
							reader.close();
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
				
			}
		});
		panel.add(button1);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
	}

}
