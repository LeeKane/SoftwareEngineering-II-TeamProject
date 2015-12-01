/**   
 * @Title: Main.java
 * @Package ui
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 徐骏  
 * @date 2010-7-1 下午08:23:53
 * @version V1.0   
 */

package client;

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

import ui.XContentPanel;
import ui.XContorlUtil;
import ui.XJumpController;
import ui.chart.ChartPanelTest1;
import ui.menu.XMenuBar;
import ui.outlookpanel.XOutlookLabel;
import ui.outlookpanel.XOutlookPanel;
import ui.statusbar.XStatusBar;
import ui.tab.XTabPage;
import util.Permission;

public class Main extends JFrame
{
	private XJumpController jumpController;
	
	private String menuBarXML;
	private String outlookPanelXML;
	
	private XContentPanel contentPanel;
	private XMenuBar menubar;
	private XOutlookPanel outlookPanel;
	private JTabbedPane tabPanel;
	private XStatusBar statusBar;
	
	private Permission permission;
	
	public Main(Permission permission)
	{
		XContorlUtil.setupLookAndFeel();
		this.permission=permission;
		menuBarXML = "ui/menubar.xml";
		menubar = XContorlUtil.loadMenuBar(menuBarXML, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String command = e.getActionCommand();
				System.out.println("Menu:"+command);
			}
		});				
		contentPanel = new XContentPanel();		
		initSwing();
	}
	
	private void initSwing()
	{
		setTitle("Express Logistics System");
		setDefaultCloseOperation(3);
		setSize(1024, 768);
		setLocationRelativeTo(null); 
		setIconImage(XContorlUtil.getImage("ui/Images/logo.png"));
		setContentPane(contentPanel);

		//除却菜单栏之外的面板
		JPanel centerPane = new JPanel(new BorderLayout());
		centerPane.setOpaque(true);
		//主面板背景
		centerPane.setBackground(XContorlUtil.CONTENT_PANE_BACKGROUND);
		
		initTab();
		initOutlookPanel();
		initStatusbar();
		
		Dimension d=outlookPanel.getSize();
		d.setSize(175, d.getHeight());
		outlookPanel.setPreferredSize(d);
				
		contentPanel.add(centerPane, "Center");
		contentPanel.add(outlookPanel, "West");
		
		centerPane.add(menubar, "North");
		centerPane.add(tabPanel,"Center");
		centerPane.add(statusBar,"South");
	}
	
	private void initOutlookPanel()
	{
		jumpController=new XJumpController();
		
		outlookPanel = new XOutlookPanel(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String command = e.getActionCommand();
				System.out.println("Head:"+command);
			}
			
		}
		,
		new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				if (((JComponent) e.getSource()).contains(e.getPoint())){
					XOutlookLabel label=(XOutlookLabel)e.getSource();
					String command=label.getCommand();
					
					//得到所有要加入的page构成的ArrayList
					List<XTabPage> pageList=jumpController.getPageList(command);
					
					tabPanel.removeAll();
					for(XTabPage page:pageList){
						tabPanel.addTab(command, page);
					}
				}				
			}
		}
		);		
		outlookPanelXML=jumpController.getoutlookPanelXML(permission);
		String firstCommand=XContorlUtil.loadOutlookPanel(outlookPanelXML, outlookPanel);
		
		if(firstCommand!=null){
			List<XTabPage> pageList=jumpController.getPageList(firstCommand);
			
			tabPanel.removeAll();
			for(XTabPage page:pageList){
				tabPanel.addTab(firstCommand, page);
			}
		}
	}
	private void initTab()
	{
		tabPanel = new JTabbedPane();
		tabPanel.setFont(XContorlUtil.FONT_12_BOLD);
		tabPanel.addMouseListener(new MouseAdapter()
		{
			private boolean isMaximized()
			{
				return outlookPanel.isShrinked();
			}
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() > 1)
				{
					TabbedPaneUI ui = tabPanel.getUI();
					int tabIndex = ui.tabForCoordinate(tabPanel, e.getX(), e.getY());
					if (tabIndex != -1)
					{
						boolean maxed = isMaximized();
						outlookPanel.setShrink(!maxed);
					}
				}
			}
		});
//		tabPanel.addTab("快递信息管理", createPage(new ChartPanelTest1().getChartPanel()));
//		tabPanel.addTab("图形模版二", createPage(new ChartPanelTest2().getChartPanel()));	
	}
	
	private XTabPage createPage(JComponent pageContent)
	{
		XTabPage page = new XTabPage(pageContent);
		return page;
	}
		
	private void initStatusbar()
	{
		statusBar = new XStatusBar(permission);
	}
	
	public static void main(String args[]) throws ParserConfigurationException
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Main main = new Main(Permission.COURIER);
				main.setVisible(true);
			}
		});
	}
}