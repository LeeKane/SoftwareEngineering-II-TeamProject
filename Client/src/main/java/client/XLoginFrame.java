/*
s  * 系统名称：
 * 模块名称：
 * 描述：
 * 作者：徐骏
 * version 1.0
 * time  2010-7-8 下午01:50:48
 * copyright Anymusic Ltd.
 */
package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import bl.login.Login;
import blservice.loginblservice.LoginBLService;
import layout.TableLayout;
import po.AccountPO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XMain;
import ui.XPasswordField;
import ui.XTextField;
import ui.Xpanel;

/**
 * @author 徐骏
 * @data 2010-7-8
 */
public class XLoginFrame extends JFrame {
	private int width;
	private int height;
	private ImageIcon buttonIcon;
	private ImageIcon buttonRoverIcon;
	private ImageIcon buttonPressedIcon;
	private ImageIcon logoIcon;
	private ImageIcon logoRoverIcon;
	private ImageIcon inquireRoverIcon;
	private ImageIcon inquireIcon;	
	private ImageIcon inquirePressedIcon;
	private JLabel logoLabel;
	private JButton btnLogin;
	private JButton btnInquire;
	private Xpanel inputPane;
	private XButton exitButton;
	private MouseAdapter moveWindowListener;
	private String account;
	private String password;
	private LoginBLService bl = new Login();
	private String result;
	private AccountPO po;
	private XTextField accountField;
	private XPasswordField passwordField;
	private TexturePaint paint;

	public XLoginFrame() {
		width = 440;
		height = 655;
		buttonIcon = XContorlUtil.getImageIcon("ui/images/login_button.png");
		buttonRoverIcon = XContorlUtil
				.getImageIcon("ui/images/login_button_rover.png");
		buttonPressedIcon = XContorlUtil
				.getImageIcon("ui/images/login_button_rover.png");
		
		inquireIcon = XContorlUtil.getImageIcon("ui/images/inquire_button.png");
		inquireRoverIcon = XContorlUtil
				.getImageIcon("ui/images/inquire_button_rover.png");
		inquirePressedIcon = XContorlUtil
				.getImageIcon("ui/images/inquire_button_rover.png");
		// logoIcon = XContorlUtil.getImageIcon("ui/images/login_logo.png");

		// logoRoverIcon =
		// XContorlUtil.getImageIcon("ui/images/login_logo_rover.png");
		logoLabel = createDraggableLabel(logoIcon);
		
		btnLogin = new JButton();
		btnInquire=new JButton();
		
		inputPane = new Xpanel();
		moveWindowListener = new MouseAdapter() {

			private Point lastPoint;

			public void mousePressed(MouseEvent e) {
				lastPoint = e.getLocationOnScreen();
			}

			public void mouseDragged(MouseEvent e) {
				Point point = e.getLocationOnScreen();
				int offsetX = point.x - lastPoint.x;
				int offsetY = point.y - lastPoint.y;
				Rectangle bounds = getBounds();
				bounds.x += offsetX;
				bounds.y += offsetY;
				setBounds(bounds);
				lastPoint = point;
			}

			public void mouseEntered(MouseEvent e) {
				if (e.getSource() == logoLabel)
					logoLabel.setIcon(logoRoverIcon);
			}

			public void mouseExited(MouseEvent e) {
				if (e.getSource() == logoLabel)
					logoLabel.setIcon(logoIcon);
			}
		};
		init();

	}

	private void init() {
		setDefaultCloseOperation(2);
		setUndecorated(true);
		// AWTUtilities.setWindowOpaque(this, false);
		JPanel centerPane = new JPanel(new BorderLayout());
		// centerPane.add(btnLogin, "South");
		setContentPane(centerPane);
		setSize(width, height);
		// 窗体屏幕居中
		
		JPanel topPane = new JPanel(new BorderLayout());
		logoLabel.setOpaque(false);
		topPane.setOpaque(false);
		logoLabel.addMouseListener(moveWindowListener);
		logoLabel.addMouseMotionListener(moveWindowListener);
		topPane.addMouseListener(moveWindowListener);
		topPane.addMouseMotionListener(moveWindowListener);
		topPane.add(logoLabel, "Center");
		// topPane.add(createDraggableLabel(XContorlUtil.getImageIcon("ui/images/login_left_top.png")),
		// "West");
		// topPane.add(createDraggableLabel(XContorlUtil.getImageIcon("ui/images/login_right_top.png")),
		// "East");
		//
		//
		// centerPane.add(createDraggableLabel(XContorlUtil.getImageIcon("ui/images/login_left.png")),
		// "West");
		// centerPane.add(createDraggableLabel(XContorlUtil.getImageIcon("ui/images/login_right.png")),
		// "East");
		exitButton=new XButton();
		JPanel forePanel=new JPanel();
        forePanel.setSize(new Dimension(66, 66));
        forePanel.setLocation(width-30, -36);
        forePanel.setOpaque(false);
        forePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
        
        centerPane.add(forePanel,"Center");	
		centerPane.add(inputPane,"Center");
        centerPane.setComponentZOrder(forePanel, 0);
        
		inputPane.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		inputPane.setSize(new Dimension(440,655));
		int rowHeight = 60;
		int sepHeight = 16;
		double size[][] = {
				{ 0.15, 0, 0.7, 0.15 }, // Columns
				{ 270, rowHeight, sepHeight, rowHeight, sepHeight - 5,
						rowHeight, rowHeight } }; // Rows
		inputPane.setLayout(new TableLayout(size));
		inputPane.add(createInputLabel("  用户名:"), "0, 1"); // 第一列第二行
		accountField = new XTextField("");
		accountField.setForeground(XContorlUtil.DEFAULT_TEXT_COLOR);
		inputPane.add(accountField, "2,1"); // 第三列第二行
		inputPane.add(createInputLabel("     密码:"), "0,3"); // 第一列第四行
		passwordField = new XPasswordField();
		passwordField.setForeground(XContorlUtil.DEFAULT_TEXT_COLOR);
		inputPane.add(passwordField, "2,3"); // 第二列第四行

		inputPane.add(btnLogin, "2,5");
		inputPane.add(btnInquire,"2,6");

		setLocationRelativeTo(null);
		btnLogin.setBorder(null);
		btnLogin.setMargin(null);
		btnLogin.setOpaque(false);
		btnLogin.setIcon(buttonIcon);
		btnLogin.setRolloverEnabled(true);
		btnLogin.setRolloverIcon(buttonRoverIcon);
		btnLogin.setPressedIcon(buttonPressedIcon);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setRequestFocusEnabled(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account=accountField.getText();
				password=passwordField.getText();
				po=bl.login(account, password);
				if(po!=null)
					login();
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inputPane.setPaint();
				inputPane.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				inputPane.reSetPaint();
				inputPane.repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}
		});
		
		btnInquire.setBorder(null);
		btnInquire.setMargin(null);
		btnInquire.setOpaque(false);
		btnInquire.setIcon(inquireIcon);
		btnInquire.setRolloverEnabled(true);
		btnInquire.setRolloverIcon(inquireRoverIcon);
		btnInquire.setPressedIcon(inquirePressedIcon);
		btnInquire.setContentAreaFilled(false);
		btnInquire.setRequestFocusEnabled(false);
		btnInquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mainFrame=new XMain();
				mainFrame.setVisible(true);
			}
		});
		btnInquire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inputPane.setPaint();
				inputPane.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				inputPane.reSetPaint();
				inputPane.repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}
		});
		

		JCheckBox cbRememberMe = new JCheckBox("记住账号密码");
		cbRememberMe.setOpaque(false);
		setupComponent(cbRememberMe);
		// inputPane.add(cbRememberMe,"2,5");
		inputPane.addMouseListener(moveWindowListener);
		inputPane.addMouseMotionListener(moveWindowListener);

	}

	private JLabel createDraggableLabel(ImageIcon icon) {
		JLabel label = new JLabel(icon);
		label.addMouseListener(moveWindowListener);
		label.addMouseMotionListener(moveWindowListener);
		return label;
	}

	private JLabel createInputLabel(String text) {
		JLabel label = new JLabel(text);
		setupComponent(label);
		return label;
	}

	private void setupComponent(JComponent c) {
		c.setFont(XContorlUtil.FONT_14_BOLD);
		c.setForeground(XContorlUtil.MENUITEM_BACKGROUND);
	}

	protected void login() {
		JFrame mainFrame=new XMain(po);
		mainFrame.setVisible(true);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				XLoginFrame ui = new XLoginFrame();
				ui.setVisible(true);
			}

		});
	}

}
