
package ui.statusbar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.XContorlUtil;

public class XStatusSeparator extends JLabel
{
	private ImageIcon imageIcon;

	public XStatusSeparator()
	{
		imageIcon = XContorlUtil.getImageIcon("ui/images/statusbar_separator.png");
		init();
	}

	private void init()
	{
		setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		setOpaque(false);
		setIcon(imageIcon);
	}
}
