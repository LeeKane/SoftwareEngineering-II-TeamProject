package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.TabbedPaneUI;
import javax.xml.parsers.ParserConfigurationException;

import client.XLoginFrame;
import po.AccountPO;
import po.StaffPO;
import ui.menu.XMenuBar;
import ui.outlookpanel.XOutlookLabel;
import ui.outlookpanel.XOutlookPanel;
import ui.statusbar.XStatusBar;
import ui.tab.XTabPage;
import util.City;
import util.OrgType;
import util.Permission;

public class XMain extends JFrame implements ActionListener {

	private XJumpController jumpController;

	private String menuBarXML;
	private String outlookPanelXML;

	private XContentPanel contentPanel;
	private XMenuBar menubar;
	private XOutlookPanel outlookPanel;
	private JTabbedPane tabPanel;
	private XStatusBar statusBar;

	private AccountPO po;

	public XMain(AccountPO po) {
		XContorlUtil.setupLookAndFeel();
		this.po = po;
		menuBarXML = "ui/menubar.xml";
		menubar = XContorlUtil.loadMenuBar(menuBarXML, this);
		contentPanel = new XContentPanel();
		initSwing();
	}

	public XMain() {
		XContorlUtil.setupLookAndFeel();
		this.po = new AccountPO(151200, Permission.SENDER, null, null, null);
		menuBarXML = "ui/menubar.xml";
		menubar = XContorlUtil.loadMenuBar(menuBarXML, this);
		contentPanel = new XContentPanel();
		initSwing();
	}

	private void initSwing() {
		setTitle("Express Logistics System");
		setDefaultCloseOperation(3);
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setIconImage(XContorlUtil.getImage("ui/Images/logo.png"));
		setContentPane(contentPanel);

		// 除却菜单栏之外的面板
		JPanel centerPane = new JPanel(new BorderLayout());
		centerPane.setOpaque(true);
		// 主面板背景
		centerPane.setBackground(XContorlUtil.CONTENT_PANE_BACKGROUND);

		initTab();
		initOutlookPanel();
		initStatusbar();

		Dimension d = outlookPanel.getSize();
		d.setSize(175, d.getHeight());
		outlookPanel.setPreferredSize(d);

		contentPanel.add(centerPane, "Center");
		contentPanel.add(outlookPanel, "West");

		centerPane.add(menubar, "North");
		centerPane.add(tabPanel, "Center");
		centerPane.add(statusBar, "South");
	}

	private void initOutlookPanel() {
		jumpController = new XJumpController(po);

		outlookPanel = new XOutlookPanel(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				System.out.println("Head:" + command);
			}

		}, new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (((JComponent) e.getSource()).contains(e.getPoint())) {
					XOutlookLabel label = (XOutlookLabel) e.getSource();
					String command = label.getCommand();

					// 得到所有要加入的page构成的ArrayList
					List<XTabPage> pageList = jumpController.getPageList(command);

					tabPanel.removeAll();
					for (XTabPage page : pageList) {
						tabPanel.addTab(page.getName(), page);
					}
				}
			}
		});
		outlookPanelXML = jumpController.getoutlookPanelXML(po.getPermission());
		String firstCommand = XContorlUtil.loadOutlookPanel(outlookPanelXML, outlookPanel);

		if (firstCommand != null) {
			List<XTabPage> pageList = jumpController.getPageList(firstCommand);

			tabPanel.removeAll();
			for (XTabPage page : pageList) {
				tabPanel.addTab(page.getName(), page);
			}
		}
	}

	private void initTab() {
		tabPanel = new JTabbedPane();
		tabPanel.setFont(XContorlUtil.FONT_12_BOLD);
		tabPanel.addMouseListener(new MouseAdapter() {
			private boolean isMaximized() {
				return outlookPanel.isShrinked();
			}

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1) {
					TabbedPaneUI ui = tabPanel.getUI();
					int tabIndex = ui.tabForCoordinate(tabPanel, e.getX(), e.getY());
					if (tabIndex != -1) {
						boolean maxed = isMaximized();
						outlookPanel.setShrink(!maxed);
					}
				}
			}
		});
	}

	private void initStatusbar() {
		statusBar = new XStatusBar(po.getPermission());
	}

	public static void main(String args[]) throws ParserConfigurationException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				XMain main = new XMain(new AccountPO(151232, Permission.COURIER, "mailer", "123456",
						new StaffPO("11010", "1002", City.BEIJING, OrgType.HALL, Permission.COURIER)));
				main.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "return":
			this.dispose();
			XLoginFrame loginUI = new XLoginFrame();
			loginUI.setVisible(true);
			break;
		case "exit":
			System.exit(-1);
			break;
		}
	}
}