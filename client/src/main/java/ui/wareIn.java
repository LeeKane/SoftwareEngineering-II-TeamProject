package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class wareIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wareIn frame = new wareIn();
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
	public wareIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("入库单信息输入");
		label.setBounds(10, 10, 94, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("快递编号");
		label_1.setBounds(10, 47, 54, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(97, 42, 145, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("入库日期");
		label_2.setBounds(10, 89, 54, 15);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 84, 145, 26);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("仓库已经排到");
		label_3.setBounds(10, 132, 94, 15);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 127, 145, 26);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("目的地");
		label_4.setBounds(309, 47, 54, 15);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(355, 42, 145, 26);
		contentPane.add(textField_3);
		
		JLabel label_5 = new JLabel("位置");
		label_5.setBounds(10, 180, 54, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("区号");
		label_6.setBounds(62, 180, 54, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("排号");
		label_7.setBounds(133, 180, 54, 15);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("架号");
		label_8.setBounds(212, 180, 54, 15);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("位号");
		label_9.setBounds(296, 180, 54, 15);
		contentPane.add(label_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(88, 180, 41, 15);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 180, 41, 15);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(242, 180, 41, 15);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(330, 180, 41, 15);
		contentPane.add(textField_7);
		
		JButton button = new JButton("添加");
		button.setBounds(349, 130, 75, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("确认");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		
	}
}
