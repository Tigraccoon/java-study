package ch19;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Directory extends JFrame {

	private JPanel contentPane;
	private JTextField tfDirectory;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Directory frame = new Directory();
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
	public Directory() {
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
		
		JLabel lblNewLabel = new JLabel("Directroy : ");
		panel.add(lblNewLabel);
		
		tfDirectory = new JTextField();
		panel.add(tfDirectory);
		tfDirectory.setColumns(15);
		
		JButton button1 = new JButton("Enter");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directory = tfDirectory.getText();
				File file = new File(directory);
				String[] list = file.list();	//디렉토리의 파일 목록을 배열로 저장
				ta.setText("");
				for(int i=0;i<list.length;i++) {
					//new file(디렉토리, 파일 이름)
					File f = new File(directory, list[i]);
					//isDirectory : 디렉토리면 true
					String str = f.isDirectory() ? "디렉토리" : "파일";
					ta.append(str+" : " + list[i] + "\n");
					
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
