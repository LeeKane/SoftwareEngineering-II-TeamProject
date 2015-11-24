/**   
 * @Title: XRootMenu.java
 * @Package ui
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 徐骏  
 * @date 2010-7-1 下午08:06:46
 * @version V1.0   
 */

package ui.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.border.Border;

import ui.XContorlUtil;


/**
 * @ClassName: XRootMenu
 * @Description: TODO(菜单根条目)
 * @date 2010-7-1 下午08:06:46
 * 
 */
public class XRootMenu extends JMenu
{
	private Color foregroundColor;
	private String selectedBackgroundImageURL;
	private TexturePaint paint;
	private Border border;
	
	public XRootMenu()
	{
		foregroundColor = XContorlUtil.DEFAULT_MENU_TEXT_COLOR;
		paint = XContorlUtil.createTexturePaint("ui/images/menubar_background_selected.png");
		border = BorderFactory.createEmptyBorder(2, 0, 0, 0);
		setFont(XContorlUtil.FONT_14_BOLD);
		init();
	}

	public XRootMenu(String text)
	{
		super(text);
		foregroundColor = XContorlUtil.DEFAULT_MENU_TEXT_COLOR;
		paint = XContorlUtil.createTexturePaint("ui/images/menubar_background.png");
		border = BorderFactory.createEmptyBorder(2, 0, 0, 0);
		setFont(XContorlUtil.FONT_14_BOLD);
		init();
	}
	
	public XRootMenu(Font font)
	{
		foregroundColor = XContorlUtil.DEFAULT_MENU_TEXT_COLOR;
		paint = XContorlUtil.createTexturePaint("ui/images/menubar_background.png");
		border = BorderFactory.createEmptyBorder(2, 0, 0, 0);
		setFont(font);
		init();
	}

	private void init()
	{
		setBorder(border);
		setForeground(foregroundColor);
	}

	protected void paintComponent(Graphics g)
	{
		if (isSelected())
		{
			Graphics2D g2d = (Graphics2D)g;
			g2d.setPaint(paint);
			g2d.fillRect(0, 0, getWidth(), getHeight());
			super.paintComponent(g);
		} else
		{
			super.paintComponent(g);
		}
	}
}
