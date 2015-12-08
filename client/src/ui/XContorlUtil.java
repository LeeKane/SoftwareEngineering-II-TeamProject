package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.TexturePaint;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ui.menu.XMenu;
import ui.menu.XMenuBar;
import ui.menu.XMenuItem;
import ui.menu.XRootMenu;
import ui.outlookpanel.XOutlookBar;
import ui.outlookpanel.XOutlookPanel;

public class XContorlUtil
{
	//文本
	public static final Color DEFAULT_TEXT_COLOR = new Color(100,100,100);
	public static final Color SELECTED_TEXT_COLOR = new Color(0,202,152);
//	public static final Color DEFAULT_MENU_TEXT_COLOR = new Color(174,178,183);
	public static final Color DEFAULT_MENU_TEXT_COLOR = new Color(150,150,150);
	public static final Color DEFAULT_OUTLOOK_TEXT_COLOR = new Color(210,211,213);
	public static final Color DEFAULT_TAB_TEXT_COLOR = new Color(255,255,255);
	public static final Color DEFAULT_PAGE_TEXT_COLOR = new Color(103,106,116);
	public static final Font FONT_14_BOLD = new Font("微软雅黑", 1, 14);
	public static final Font FONT_12_BOLD = new Font("微软雅黑", 1, 12);
	public static final Font FONT_18_BOLD = new Font("微软雅黑", 1, 20);
	public static final Font FONT_14_PLAIN = new Font("微软雅黑", 0, 14);
	public static final Font FONT_12_PLAIN = new Font("微软雅黑", 0, 12);
	public static final Font FONT_22_BOLD = new Font("微软雅黑", 1, 24);
	//菜单
	public static final Color MENUITEM_SELECTED_BACKGROUND = new Color(166, 188, 140);
	public static final Color MENUITEM_BACKGROUND = new Color(250, 250, 251);
	//主面板
	public static final Color CONTENT_PANE_BACKGROUND = new Color(230,230,230);
	//工具栏按钮
	public static final Color BUTTON_ROVER_COLOR = new Color(196, 196, 197);
	//OutLook面板
	public static final Color OUTLOOK_TEXT_COLOR = new Color(120, 120, 125);
	public static final Color OUTLOOK_SPLIT_COLOR = new Color(174, 171, 162);
	public static final Color OUTLOOK_CONTAINER_COLOR = new Color(59,58,63) ;//容器的背景颜色，灰色
	//多视图Tab
	public static final Color TAB_BOTTOM_LINE_COLOR = new Color(167, 173, 175);
	//快捷菜单面板
	public static final Color LIST_SPLIT_COLOR = new Color(105, 113, 120);
	public static final Color LIST_BACKGROUND = new Color(175, 174, 176);
	public static final Color LIST_TEXT_COLOR = new Color(49, 52, 58);
	//图形
    public static Font CHART_AXIS_FONT = new Font("微软雅黑",Font.PLAIN,12) ;// 坐标轴字体
    public static Font CHART_TITLE_FONT = new Font("微软雅黑",Font.PLAIN,14);//标题字体
    public static Font CHART_LEGEND_FONT = new Font("微软雅黑",Font.PLAIN,12); //图例字体

	//其他
	public static final Color NO_COLOR = new Color(0, 0, 0, 0);
	public static final Insets ZERO_INSETS = new Insets(0, 0, 0, 0);
	/**
	 * ClassLoader获得BufferedImage,注意和getClass().getResource()的路径不同
	 * 最前面不带/
	 * @param @param imgPath
	 * @param @return    参数
	 * @return Image    返回类型
	 * @throws
	 */
	public static Image getImage(String imgPath)
	{
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(ClassLoader.getSystemResource(imgPath));
		} catch (IOException e)
		{
			System.out.println("图片路径找不到: "+imgPath);
			//e.printStackTrace();
		}
		return img;
	}
	public static ImageIcon getImageIcon(String imgPath)
	{
		ImageIcon icon = null;
		try
		{
			icon = new ImageIcon(ClassLoader.getSystemResource(imgPath));
			return icon;
		}
		catch (Exception e)
		{
			System.out.println("找不到图片： " +imgPath );
		}
		return icon;
	}
	public static Image iconToImage(Icon icon)
	{
		if (icon instanceof ImageIcon)
		{
			return ((ImageIcon) icon).getImage();
		}
		else
		{
			int w = icon.getIconWidth();
			int h = icon.getIconHeight();
			BufferedImage image = new BufferedImage(w, h, 2);
			Graphics2D g = image.createGraphics();
			icon.paintIcon(null, g, 0, 0);
			g.dispose();
			return image;
		}
	}
	public static ImageIcon createDyedIcon(ImageIcon icon, Color color)
	{
		if (color == null)
		{
			return icon;
		}
		else
		{
			int iconWidth = icon.getIconWidth();
			int iconHeight = icon.getIconHeight();
			BufferedImage bi = new BufferedImage(iconWidth, iconHeight, 2);
			Graphics2D g2d = bi.createGraphics();
			icon.paintIcon(null, g2d, 0, 0);
			g2d.dispose();
			Image dyedImage = createDyedImage(bi, color);
			return new ImageIcon(dyedImage);
		}
	}
	public static Image createDyedImage(Image image, Color color)
	{
		if (color == null)
			return image;
		if (image != null)
		{
			int w = image.getWidth(null);
			int h = image.getHeight(null);
			int pixels[] = new int[w * h];
			PixelGrabber pg = new PixelGrabber(image, 0, 0, w, h, pixels, 0, w);
			try
			{
				pg.grabPixels();
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
				return null;
			}
			BufferedImage bi = new BufferedImage(w <= 1 ? 1 : w,
					h <= 1 ? 1 : h, 2);
			for (int i = 0; i < pixels.length; i++)
			{
				int pixel = pixels[i];
				int row = i / w;
				int col = i % w;
				if (color != null && pixel != 0)
					pixel = color.getRGB();
				bi.setRGB(col, row, pixel);
			}
			return bi;
		}
		else
		{
			return null;
		}
	}
	public static Icon createMovedIcon(Icon icon)
	{
		return createMovedIcon(icon, 1, 1);
	}
	public static Icon createMovedIcon(final Icon icon, final int offsetX,
			final int offsetY)
	{
		return new Icon()
		{
			public void paintIcon(Component c, Graphics g, int x, int y)
			{
				icon.paintIcon(c, g, x + offsetX, y + offsetY);
			}
			public int getIconWidth()
			{
				return icon.getIconWidth();
			}
			public int getIconHeight()
			{
				return icon.getIconHeight();
			}
		};
	}
	
	public static TexturePaint createTexturePaint(String imgPath)
	{
		ImageIcon icon = getImageIcon(imgPath);
		int imageWidth = icon.getIconWidth();
		int imageHeight = icon.getIconHeight();
		BufferedImage bi = new BufferedImage(imageWidth, imageHeight, 2);
		Graphics2D g2d = bi.createGraphics();
		g2d.drawImage(icon.getImage(), 0, 0, null);
		g2d.dispose();
		return new TexturePaint(bi,
				new Rectangle(0, 0, imageWidth, imageHeight));
	}
	
	/**
	 * 获得Color
	 * @param c
	 * @return
	 * 徐骏
	 * 下午02:09:47
	 */
	public static Color getColor(String color) {
	    Color convertedColor = Color.ORANGE;
	    try {
	        convertedColor = new Color(Integer.parseInt(color, 16));
	    } catch(NumberFormatException e) {
	    	String error = String.format("颜色转化出错:s%",color);
	        System.out.println(error);
	    }
	    return convertedColor;
	}
	public static InputStream getXMLFile(String filePath)
	{
		return ClassLoader.getSystemResourceAsStream(filePath);
	}
	private static String getStringAttribute(org.w3c.dom.Node node, String name)
	{
		org.w3c.dom.Node attribute = node.getAttributes().getNamedItem(name);
		if (attribute != null)
			return attribute.getNodeValue();
		else
			return null;
	}
	private static Icon getIconAttribute(org.w3c.dom.Node node, String name)
	{
		String iconURL = getStringAttribute(node, name);
		if (iconURL != null && !iconURL.isEmpty())
			return getImageIcon(iconURL);
		else
			return null;
	}
	private static int getIntAttribute(org.w3c.dom.Node node, String name)
	{
		String value = getStringAttribute(node, name);
		if (value != null && !value.isEmpty())
			return Integer.valueOf(value).intValue();
		else
			return 0;
	}
	public static XMenuBar loadMenuBar(String xml, ActionListener action)
	{
		XMenuBar menuBar = null;
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(XContorlUtil.getXMLFile(xml));
			Element root = doc.getDocumentElement();
			NodeList rootMenus = root.getChildNodes();
			if (rootMenus != null)
			{
				menuBar = new XMenuBar();
				for (int i = 0; i < rootMenus.getLength(); i++)
				{
					org.w3c.dom.Node menu = rootMenus.item(i);
					if (menu.getNodeType() == Node.ELEMENT_NODE)
					{
						if (menu.getNodeName().equalsIgnoreCase("menu"))
						{
							String text = XContorlUtil.getStringAttribute(menu, "text");
							XRootMenu rootMenu = new XRootMenu();
							rootMenu.setText(text);
							menuBar.add(rootMenu);
							processMenuItem(menu, rootMenu, action);
						}
						if (menu.getNodeName().equalsIgnoreCase("logo"))
						{
							String imageURL = XContorlUtil.getStringAttribute(menu, "image");
//							menuBar.add(Box.createGlue());
							JLabel label = new JLabel(XContorlUtil.getImageIcon(imageURL));
//							label.setBorder(BorderFactory.createEmptyBorder(0,5, 0, 5));
							menuBar.add(label);
						}
						if (menu.getNodeName().equalsIgnoreCase("search"))
						{							
							XTextField searchField=new XTextField("搜索");
							menuBar.add(searchField);
							//menuBar.addSeparator();
						}
						if (menu.getNodeName().equalsIgnoreCase("bf"))
						{
							String text = XContorlUtil.getStringAttribute(menu, "text");
							XRootMenu rootMenu = new XRootMenu(FONT_18_BOLD);
							if(text.equals("B"))
								rootMenu.setText("   <   ");
							else if(text.equals("F"))
								rootMenu.setText("   >   ");
							menuBar.add(rootMenu);
							//menuBar.addSeparator();
						}
						if(menu.getNodeName().equalsIgnoreCase("time"))
						{
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
							String dateString = dateFormat.format(new Date());
							XLabel timeLabel=new XLabel(dateString);
							menuBar.add(timeLabel);
							//menuBar.addSeparator();
						}
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return menuBar;
	}
	private static void processMenuItem(org.w3c.dom.Node menu,
			JMenuItem parentMenu, ActionListener action)
	{
		NodeList children = menu.getChildNodes();
		if (children != null)
		{
			for (int j = 0; j < children.getLength(); j++)
			{
				org.w3c.dom.Node itemNode = children.item(j);
				if (itemNode.getNodeType() != Node.ELEMENT_NODE)
					continue;
				boolean isMenuItem = itemNode.getNodeName().equalsIgnoreCase(
						"menuitem");
				boolean isMenu = itemNode.getNodeName()
						.equalsIgnoreCase("menu");
				if (!isMenuItem && !isMenu)
					continue;
				String text = getStringAttribute(itemNode, "text");
				String tooltip = getStringAttribute(itemNode, "tooltip");
				Icon icon = getIconAttribute(itemNode, "icon");
				String command = getStringAttribute(itemNode, "action");
				JMenuItem menuItem = null;
				if (isMenu)
				{
					menuItem = new XMenu();
				}
				else
				{
					menuItem = new XMenuItem();
					menuItem.addActionListener(action);
				}
				menuItem.setText(text);
				menuItem.setToolTipText(tooltip);
				menuItem.setActionCommand(command);
				menuItem.setIcon(icon);
				parentMenu.add(menuItem);
				if (isMenu)
					processMenuItem(itemNode, menuItem, action);
			}
		}
	}
	
	public static String loadOutlookPanel(String xml, XOutlookPanel outlookPane)
	{
		String firstCommand = null;
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(getXMLFile(xml));
			Element root = doc.getDocumentElement();
			NodeList modules = root.getChildNodes();
			if (modules != null)
			{
				int count=0;
				for (int i = 0; i < modules.getLength(); i++)
				{
					org.w3c.dom.Node moduleNode = modules.item(i);
					if (moduleNode.getNodeType() == Node.ELEMENT_NODE
							&& moduleNode.getNodeName().equalsIgnoreCase(
									"module"))
					{
						count++;
						String text = getStringAttribute(moduleNode, "text");
						Icon icon = getIconAttribute(moduleNode, "icon");
						Icon iconSelected = getIconAttribute(moduleNode,
								"selected_icon");
						String command = getStringAttribute(moduleNode, "action");
						XOutlookBar bar = outlookPane.addBar(text, icon,
								iconSelected,command,outlookPane.getMouseListener());
						if(count==1){
							bar.setSelected(true);
							firstCommand=command;
						}
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return firstCommand;
	}

	public static void setupLookAndFeel()
	{
		try
	    {
	        //设置本属性将改变窗口边框样式定义
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
		
//		UIManager.put("Menu.selectionBackground", XContorlUtil.NO_COLOR);
//		UIManager.put("Menu.", XContorlUtil.NO_COLOR);
//		UIManager.put("MenuItem.selectionBackground",XContorlUtil.MENUITEM_SELECTED_BACKGROUND);
//		UIManager.put("PopupMenu.border", new FreePopupMenuBorder());	
		UIManager.put("RootPane.setupButtonVisible", false);
		UIManager.put("ToolTip.font", XContorlUtil.FONT_14_BOLD);
		UIManager.put("TabbedPane.contentBorderInsets",XContorlUtil.ZERO_INSETS);
//		UIManager.put("TabbedPane.tabInsets", XContorlUtil.ZERO_INSETS);
//		UIManager.put("TabbedPane.selectedTabPadInsets", XContorlUtil.ZERO_INSETS);
		UIManager.put("TabbedPane.tabAreaInsets", new Insets(0, 1, 0, 0));
	}
}
