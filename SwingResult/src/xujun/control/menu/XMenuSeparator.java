package xujun.control.menu;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import xujun.control.XContorlUtil;

public class XMenuSeparator extends JLabel
{
	private ImageIcon imageIcon;

	public XMenuSeparator()
	{
		imageIcon = XContorlUtil.getImageIcon("xujun/control/images/separator_background.png");
		init();
	}

	private void init()
	{
		setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		setOpaque(false);
		setIcon(imageIcon);
	}
}