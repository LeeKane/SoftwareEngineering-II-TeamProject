package xujun.control;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class XButton extends JButton{
	private Color foregroundColor;
	private Border border;

	public XButton()
	{
		foregroundColor = XContorlUtil.DEFAULT_TEXT_COLOR;
		border = BorderFactory.createEmptyBorder(0, 5, 0, 4);
		init();
	}
	
	private void init()
	{
		setFont(XContorlUtil.FONT_14_BOLD);
		setBorder(border);
		setForeground(foregroundColor);
	}
}
