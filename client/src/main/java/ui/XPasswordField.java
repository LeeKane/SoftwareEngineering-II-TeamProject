package ui;

import java.awt.Color;
import java.awt.TexturePaint;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class XPasswordField extends JPasswordField{
	private Color foregroundColor;
	private ImageIcon backgroundImageIcon;
	private TexturePaint paint;
	private Border border;

	public XPasswordField(){
		super();
		foregroundColor = XContorlUtil.DEFAULT_OUTLOOK_TEXT_COLOR;
		backgroundImageIcon = XContorlUtil.getImageIcon("ui/images/search.png");
		paint = XContorlUtil.createTexturePaint("ui/images/search.png");
		border = BorderFactory.createEmptyBorder(1, 3, 1, 3);
		init();
	}
		
	private void init()
	{
		setBorder(border);
		setFont(XContorlUtil.FONT_14_BOLD);
		setForeground(foregroundColor);
	}
}
