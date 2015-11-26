package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

public class XButton extends JButton{
	private Color foregroundColor;
	private Border border;

	public XButton()
	{
		foregroundColor = XContorlUtil.MENUITEM_BACKGROUND;
		this.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
		//border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		init();
	}
	public XButton(String x)
	{
		this.setText(x);
		foregroundColor = XContorlUtil.MENUITEM_BACKGROUND;
		this.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
		//border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		init();
	}
	
	private void init()
	{
		setFont(XContorlUtil.FONT_14_BOLD);
		//setBorder(border);
		setForeground(foregroundColor);
	}
	
}
