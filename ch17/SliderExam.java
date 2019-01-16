package ch17;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;

@SuppressWarnings("serial")
public class SliderExam extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	//추가
	private int red,green,blue;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SliderExam frame = new SliderExam();
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
	public SliderExam() {
		panel = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider sliderR = new JSlider();
		sliderR.setPaintLabels(true);
		sliderR.setMajorTickSpacing(50);
		sliderR.setMinorTickSpacing(10);
		sliderR.setPaintTicks(true);
		sliderR.setBackground(Color.LIGHT_GRAY);
		sliderR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				red = sliderR.getValue();
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderR.setValue(0);
		sliderR.setMaximum(255);
		sliderR.setBounds(81, 10, 341, 50);
		contentPane.add(sliderR);
		
		JSlider sliderG = new JSlider();
		sliderG.setPaintLabels(true);
		sliderG.setMajorTickSpacing(50);
		sliderG.setMinorTickSpacing(10);
		sliderG.setPaintTicks(true);
		sliderG.setBackground(Color.LIGHT_GRAY);
		sliderG.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				green = sliderG.getValue();
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderG.setValue(0);
		sliderG.setMaximum(255);
		sliderG.setBounds(81, 70, 341, 50);
		contentPane.add(sliderG);
		
		JSlider sliderB = new JSlider();
		sliderB.setPaintLabels(true);
		sliderB.setMajorTickSpacing(50);
		sliderB.setMinorTickSpacing(10);
		sliderB.setPaintTicks(true);
		sliderB.setBackground(Color.LIGHT_GRAY);
		sliderB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				blue = sliderB.getValue();
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderB.setValue(0);
		sliderB.setMaximum(255);
		sliderB.setBounds(81, 130, 341, 50);
		contentPane.add(sliderB);
		
		JLabel lblNewLabel = new JLabel("Red");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 10, 57, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Green");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_1.setBounds(12, 70, 57, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Blue");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_2.setBounds(12, 130, 57, 35);
		contentPane.add(lblNewLabel_2);
		
		panel.setBounds(12, 190, 410, 174);
		contentPane.add(panel);
	}
}
