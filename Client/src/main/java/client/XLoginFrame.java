package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import bl.login.Login;
import blservice.loginblservice.LoginBLService;
import dataimpl.datafactory.DataFactory;
import layout.TableLayout;
import po.AccountPO;
import ui.XContorlUtil;
import ui.XLoginPanel;
import ui.XMain;
import ui.XPasswordField;
import ui.XTextField;

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
	private XLoginPanel inputPane;
	private MouseAdapter moveWindowListener;
	private String account;
	private String password;
	private LoginBLService bl = new Login();
	private AccountPO po;
	private XTextField accountField;
	private XPasswordField passwordField;

	public XLoginFrame() {
		width = 440;
		height = 655;
		buttonIcon = XContorlUtil.getImageIcon("ui/images/login_button.png");
		buttonRoverIcon = XContorlUtil.getImageIcon("ui/images/login_button_rover.png");
		buttonPressedIcon = XContorlUtil.getImageIcon("ui/images/login_button_rover.png");

		inquireIcon = XContorlUtil.getImageIcon("ui/images/inquire_button.png");
		inquireRoverIcon = XContorlUtil.getImageIcon("ui/images/inquire_button_rover.png");
		inquirePressedIcon = XContorlUtil.getImageIcon("ui/images/inquire_button_rover.png");
		logoLabel = createDraggableLabel(logoIcon);

		btnLogin = new JButton();
		btnInquire = new JButton();

		inputPane = new XLoginPanel();
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
		setIconImage(XContorlUtil.getImage("ui/Images/logo.png"));
		JPanel centerPane = new JPanel(new BorderLayout());
		JPanel downPane = new JPanel(new BorderLayout());
		downPane.setBackground(new Color(50, 54, 66));
		downPane.setSize(new Dimension(600, 100));
		JTextField ss = new JTextField();
					
		ss.setFont(XContorlUtil.FONT_14_BOLD);
		ss.setForeground(XContorlUtil.MENUITEM_BACKGROUND);
		ss.setPreferredSize(new Dimension(310, 26));
		ss.setBackground(new Color(50, 54, 66));
		ss.setBorder(BorderFactory.createLineBorder(new Color(50, 54, 66), 0));
		if(DataFactory.hostIP==null){
			try {
				ss.setText(InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else
			ss.setText(DataFactory.hostIP);

		downPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		downPane.add(createInputLabel("       IP "));
		downPane.add(ss);

		JPanel mainPane = new JPanel(new BorderLayout());
		// centerPane.add(btnLogin, "South");
		mainPane.add(centerPane, "Center");
		mainPane.add(downPane, "South");
		setContentPane(mainPane);
		setSize(width, height);

		JPanel topPane = new JPanel(new BorderLayout());
		logoLabel.setOpaque(false);
		topPane.setOpaque(false);
		logoLabel.addMouseListener(moveWindowListener);
		logoLabel.addMouseMotionListener(moveWindowListener);
		topPane.addMouseListener(moveWindowListener);
		topPane.addMouseMotionListener(moveWindowListener);
		topPane.add(logoLabel, "Center");
		JPanel forePanel = new JPanel();
		forePanel.setSize(new Dimension(66, 66));
		forePanel.setLocation(width - 30, -36);
		forePanel.setOpaque(false);
		forePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		centerPane.add(forePanel, "Center");
		centerPane.add(inputPane, "Center");
		centerPane.setComponentZOrder(forePanel, 0);

		inputPane.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		inputPane.setSize(new Dimension(440, 655));
		int rowHeight = 60;
		int sepHeight = 16;
		double size[][] = { { 0.15, 0, 0.7, 0.15 }, // Columns
				{ 270, rowHeight, sepHeight, rowHeight, sepHeight - 5, rowHeight, rowHeight } }; // Rows
		inputPane.setLayout(new TableLayout(size));
		inputPane.add(createInputLabel("  用户名"), "0, 1"); // 第一列第二行
		accountField = new XTextField("");
		accountField.setForeground(XContorlUtil.DEFAULT_TEXT_COLOR);
		inputPane.add(accountField, "2,1"); // 第三列第二行
		inputPane.add(createInputLabel("     密码"), "0,3"); // 第一列第四行
		passwordField = new XPasswordField();
		passwordField.setForeground(XContorlUtil.DEFAULT_TEXT_COLOR);
		inputPane.add(passwordField, "2,3"); // 第二列第四行

		inputPane.add(btnLogin, "2,5");
		inputPane.add(btnInquire, "2,6");

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
				account = accountField.getText();
				password = passwordField.getText();
				DataFactory.hostIP = ss.getText();
				po = bl.login(account, password);
				if (po != null)
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
				inquire();
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
		c.setBorder(BorderFactory.createLineBorder(new Color(50, 54, 66), 0));
		c.setFont(XContorlUtil.FONT_14_BOLD);
		c.setForeground(XContorlUtil.MENUITEM_BACKGROUND);
	}

	protected void login() {
		JFrame mainFrame = new XMain(po);
		mainFrame.setVisible(true);
		this.dispose();
	}

	protected void inquire() {
		JFrame mainFrame = new XMain();
		mainFrame.setVisible(true);
		this.dispose();
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
