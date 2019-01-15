package ch17;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ButtonEventExam2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonEventExam2 frame = new ButtonEventExam2();
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
	public ButtonEventExam2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnYellow = new JButton("Yellow");
		btnYellow.setBackground(Color.LIGHT_GRAY);
		btnYellow.setFont(new Font("Consolas", Font.BOLD, 18));
		btnYellow.setForeground(Color.YELLOW);
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.yellow);
			}
		});
		
		JButton btnRed = new JButton("Red");
		btnRed.setBackground(Color.LIGHT_GRAY);
		btnRed.setFont(new Font("Consolas", Font.BOLD, 18));
		btnRed.setForeground(Color.RED);
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.red);
			}
		});
		
		JTextArea txtrButtons = new JTextArea();
		txtrButtons.setBackground(Color.WHITE);
		txtrButtons.setEditable(false);
		txtrButtons.setFont(new Font("Consolas", Font.BOLD, 18));
		txtrButtons.setForeground(Color.BLACK);
		txtrButtons.setText("Buttons : ");
		contentPane.add(txtrButtons);
		contentPane.add(btnRed);
		
		JButton btnGreen = new JButton("Green");
		btnGreen.setBackground(Color.LIGHT_GRAY);
		btnGreen.setForeground(Color.GREEN);
		btnGreen.setFont(new Font("Consolas", Font.BOLD, 18));
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.green);
			}
		});
		contentPane.add(btnGreen);
		
		JButton btnBlue = new JButton("Blue");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.BLUE);
			}
		});
		btnBlue.setBackground(Color.LIGHT_GRAY);
		btnBlue.setFont(new Font("Consolas", Font.BOLD, 18));
		btnBlue.setForeground(Color.BLUE);
		contentPane.add(btnBlue);
		
		JButton btnWhite = new JButton("White");
		btnWhite.setBackground(Color.LIGHT_GRAY);
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.WHITE);
			}
		});
		btnWhite.setFont(new Font("Consolas", Font.BOLD, 18));
		btnWhite.setForeground(Color.WHITE);
		contentPane.add(btnWhite);
		contentPane.add(btnYellow);
		
		JButton btnCyan = new JButton("Cyan");
		btnCyan.setBackground(Color.LIGHT_GRAY);
		btnCyan.setFont(new Font("Consolas", Font.BOLD, 18));
		btnCyan.setForeground(Color.CYAN);
		btnCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.cyan);
			}
		});
		contentPane.add(btnCyan);
		
		JButton btnPink = new JButton("Pink");
		contentPane.add(btnPink);
		btnPink.setBackground(Color.LIGHT_GRAY);
		btnPink.setFont(new Font("Consolas",Font.BOLD,18));
		btnPink.setForeground(Color.PINK);
		
		JButton btnOrange = new JButton("Orange");
		btnOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.ORANGE);
			}
		});
		btnOrange.setFont(new Font("Consolas", Font.BOLD, 18));
		btnOrange.setBackground(Color.LIGHT_GRAY);
		btnOrange.setForeground(Color.ORANGE);
		contentPane.add(btnOrange);
		
		JButton btnMagenta = new JButton("Magenta");
		btnMagenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.MAGENTA);
			}
		});
		btnMagenta.setBackground(Color.LIGHT_GRAY);
		btnMagenta.setFont(new Font("Consolas", Font.BOLD, 18));
		btnMagenta.setForeground(Color.MAGENTA);
		contentPane.add(btnMagenta);
		btnPink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.PINK);
			}
		});
	}

}
