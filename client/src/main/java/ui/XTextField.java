/*
 * 系统名称：
 * 模块名称：
 * 描述：
 * 作者：徐骏
 * version 1.0
 * time  2010-7-8 下午03:01:11
 * copyright Anymusic Ltd.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalTextFieldUI;



/**
 * @author 徐骏
 * @data   2010-7-8
 */
public class XTextField extends JTextField
{
	private Color foregroundColor;
	private Image backgroundLeftImage;
	private Image backgroundRightImage;
	private ImageIcon backgroundImageIcon;
	private TexturePaint paint;
	private Border border;

	public XTextField()
	{
		foregroundColor = XContorlUtil.DEFAULT_OUTLOOK_TEXT_COLOR;
		backgroundLeftImage = XContorlUtil.getImage("ui/images/logo.png");
		backgroundRightImage = XContorlUtil.getImage("ui/images/logo.png");
		backgroundImageIcon = XContorlUtil.getImageIcon("ui/images/logo.png");
		paint = XContorlUtil.createTexturePaint("ui/images/search.png");
		border = BorderFactory.createEmptyBorder(1, 3, 1, 3);
		init();
	}
	public XTextField(String text)
	{
		this();
		setText(text);
	}

	private void init()
	{
		setBorder(border);
		setFont(XContorlUtil.FONT_14_BOLD);
		setForeground(foregroundColor);
		setUI(new MetalTextFieldUI() {

			protected void paintBackground(Graphics g)
			{
				Graphics2D g2d = (Graphics2D)g;
				g2d.setPaint(paint);
				g2d.fillRect(0, 0, getWidth(), getHeight());
//				System.out.println(getWidth()+","+getHeight());
//				g2d.drawImage(backgroundLeftImage, 0, 0, null);
//				g2d.drawImage(backgroundRightImage, getWidth() - backgroundRightImage.getWidth(null), 0, null);
			}

		});
	}

	public Dimension getPreferredSize()
	{
	
		return new Dimension(super.getPreferredSize().width, backgroundImageIcon.getIconHeight());
	}
	
}
