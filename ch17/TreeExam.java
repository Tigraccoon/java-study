package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TreeExam extends JFrame {

	private JPanel contentPane;
	//코드추가
	private Object[] obj= {"프로그램","시스템","디자인"};
	@SuppressWarnings("rawtypes")
	private Vector<Vector> node1 = new Vector<Vector>() {
		@Override
		public String toString() {
			return "교과목";//"프로그램" 대신 "Lesson"으로 바꿔 리턴
		}
	};
	private Vector<String> node2 = new Vector<String>() {
		@Override
		public String toString() {
			return "프로그래밍 언어";
		}
	};
	private Vector<String> node3 = new Vector<String>() {
		@Override
		public String toString() {
			return "DBMS";
		}
	};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeExam frame = new TreeExam();
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
	public TreeExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		//디자이너로 하는 방법
//		JTree tree = new JTree();
//		tree.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("Lesson") {
//				{
//					DefaultMutableTreeNode node_1;
//					node_1 = new DefaultMutableTreeNode("Java");
//						node_1.add(new DefaultMutableTreeNode("C++"));
//						node_1.add(new DefaultMutableTreeNode("HTML"));
//						node_1.add(new DefaultMutableTreeNode("red"));
//						node_1.add(new DefaultMutableTreeNode("yellow"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("시스템");
//						node_1.add(new DefaultMutableTreeNode("basketball"));
//						node_1.add(new DefaultMutableTreeNode("soccer"));
//						node_1.add(new DefaultMutableTreeNode("football"));
//						node_1.add(new DefaultMutableTreeNode("hockey"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("디자인");
//						node_1.add(new DefaultMutableTreeNode("hot dogs"));
//						node_1.add(new DefaultMutableTreeNode("pizza"));
//						node_1.add(new DefaultMutableTreeNode("ravioli"));
//						node_1.add(new DefaultMutableTreeNode("bananas"));
//					add(node_1);
//				}
//			}
//		));
		node1.add(node2);//node1에 node2를 붙임
		node1.add(node3);//node1에 node3를 붙임
		node2.add("Java");//node2에 아이템 추가
		node2.add("HTML");
		node2.add("JSP");
		node3.add("Oracle");
		node3.add("MySQL");
		obj[0] = node1;//node1을 root node로 설정
		JTree tree=new JTree(obj);
		tree.setRootVisible(true);
		scrollPane.setViewportView(tree);
	}
}
