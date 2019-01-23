package ch20;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class GuguClient extends JFrame {

	private JPanel contentPane;
	private JTextArea taResult;
	@SuppressWarnings("rawtypes")
	private JComboBox cboDan;
	//변수 추가
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuguClient frame = new GuguClient();
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
	public GuguClient() {
		try {
			socket = new Socket("192.168.0.233",9999);
			//데이터 입출력을 위한 스트림 생성
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 170, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputDan = new JLabel("Select DAN : ");
		lblInputDan.setBounds(12, 10, 82, 15);
		contentPane.add(lblInputDan);
		
		cboDan = new JComboBox();
		cboDan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int dan = Integer.parseInt(cboDan.getSelectedItem().toString());
					try {
						dos.writeInt(dan);	//서버에 전송
						//서버에서 넘어온 값을 JTextArea에 출력
						taResult.setText(dis.readUTF());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
			}
		});
		cboDan.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9"}));
		cboDan.setBounds(92, 7, 51, 21);
		contentPane.add(cboDan);
		
		taResult = new JTextArea();
		taResult.setBounds(12, 35, 131, 217);
		contentPane.add(taResult);
	}
}
