package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class ComboExam extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboExam frame = new ComboExam();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ComboExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 563);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JComboBox cboDan = new JComboBox();
		cboDan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(cboDan.getSelectedIndex());
				if(e.getStateChange() == ItemEvent.SELECTED) {
					ta.setText("");	//화면 클리어
					int dan = cboDan.getSelectedIndex()+1;	//단수를 맞추기 위해 +1
					for(int i=1;i<=9;i++) {
						if (dan == 10) {
							for(int j=1;j<=9;j++) {
								ta.append(String.format("%2d * %2d = %2d\n", i,j,i*j));
							}
						}else {
							ta.append(String.format("%2d * %2d = %2d\n", dan,i,dan*i));
						}
						ta.append("\n");
					}
				}

			}
		});
		//모델 : 데이터, M(Model) V(View) C(Controller)패턴
		cboDan.setModel(new DefaultComboBoxModel(new String[] {"구구단 선택", "2단", "3단", "4단", "5단", "6단", "7단", "8단", "9단", "전체"}));
		contentPane.add(cboDan, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		ta.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(ta);
	}

}
