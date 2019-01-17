package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class MenuExam extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuExam frame = new MenuExam();
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
	public MenuExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem miNewFile = new JMenuItem("New File");
		miNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MenuExam.this, "새 파일");
			}
		});
		menuFile.add(miNewFile);
		
		JMenuItem miOpen = new JMenuItem("Open");
		menuFile.add(miOpen);
		
		JMenuItem miSave = new JMenuItem("Save");
		menuFile.add(miSave);
		
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MenuExam.this, "종료?");
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(MenuExam.this, "프로그램 종료");
					System.exit(0);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		menuFile.add(miExit);
		
		JMenu menuColor = new JMenu("Color");
		menuBar.add(menuColor);
		
		JMenuItem miRed = new JMenuItem("Red");
		miRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.RED);
			}
		});
		miRed.setForeground(Color.WHITE);
		miRed.setBackground(Color.RED);
		menuColor.add(miRed);
		
		JMenuItem miGreen = new JMenuItem("Green");
		miGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.GREEN);
			}
		});
		miGreen.setForeground(Color.WHITE);
		miGreen.setBackground(Color.GREEN);
		menuColor.add(miGreen);
		
		JMenuItem miBlue = new JMenuItem("Blue");
		miBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.BLUE);
			}
		});
		miBlue.setForeground(Color.WHITE);
		miBlue.setBackground(Color.BLUE);
		menuColor.add(miBlue);
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
