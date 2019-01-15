package ch17;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class RadioExam extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioExam frame = new RadioExam();
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
	public RadioExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdoRed = new JRadioButton("Red");
		rdoRed.setBorderPainted(true);
		buttonGroup.add(rdoRed);
		rdoRed.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.RED);
			}
		});
		rdoRed.setFont(new Font("Consolas", Font.BOLD, 15));
		rdoRed.setForeground(Color.RED);
		rdoRed.setBackground(Color.LIGHT_GRAY);
		contentPane.add(rdoRed);
		
		JRadioButton rdoGreen = new JRadioButton("Green");
		rdoGreen.setBorderPainted(true);
		buttonGroup.add(rdoGreen);
		rdoGreen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.GREEN);
			}
		});
		rdoGreen.setFont(new Font("Consolas", Font.BOLD, 15));
		rdoGreen.setForeground(Color.GREEN);
		rdoGreen.setBackground(Color.LIGHT_GRAY);
		contentPane.add(rdoGreen);
		
		JRadioButton rdoBlue = new JRadioButton("Blue");
		rdoBlue.setBorderPainted(true);
		buttonGroup.add(rdoBlue);
		rdoBlue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.BLUE);
			}
		});
		rdoBlue.setFont(new Font("Consolas", Font.BOLD, 15));
		rdoBlue.setForeground(Color.BLUE);
		rdoBlue.setBackground(Color.LIGHT_GRAY);
		contentPane.add(rdoBlue);
		
		JRadioButton rdoCyan = new JRadioButton("Cyan");
		rdoCyan.setBorderPainted(true);
		buttonGroup.add(rdoCyan);
		rdoCyan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.CYAN);
			}
		});
		rdoCyan.setFont(new Font("Consolas", Font.BOLD, 15));
		rdoCyan.setForeground(Color.CYAN);
		rdoCyan.setBackground(Color.LIGHT_GRAY);
		contentPane.add(rdoCyan);
		
		JRadioButton rdoOrange = new JRadioButton("Orange");
		rdoOrange.setBorderPainted(true);
		rdoOrange.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.ORANGE);
			}
		});
		rdoOrange.setForeground(Color.ORANGE);
		rdoOrange.setFont(new Font("Consolas", Font.BOLD, 15));
		rdoOrange.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdoOrange);
		contentPane.add(rdoOrange);
		
		JRadioButton rdoPink = new JRadioButton("Pink");
		rdoPink.setBorderPainted(true);
		rdoPink.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.PINK);
			}
		});
		rdoPink.setForeground(Color.PINK);
		rdoPink.setFont(new Font("Consolas", Font.BOLD, 15));
		rdoPink.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdoPink);
		contentPane.add(rdoPink);
		
		JRadioButton rdoYellow = new JRadioButton("Yellow");
		rdoYellow.setBorderPainted(true);
		rdoYellow.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.YELLOW);
			}
		});
		rdoYellow.setForeground(Color.YELLOW);
		rdoYellow.setFont(new Font("Consolas", Font.BOLD, 15));
		rdoYellow.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdoYellow);
		contentPane.add(rdoYellow);
	}

}
