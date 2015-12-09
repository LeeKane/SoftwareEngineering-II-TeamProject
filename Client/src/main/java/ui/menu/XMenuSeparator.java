package ui.menu;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.XContorlUtil;

public class XMenuSeparator extends JLabel {
	private ImageIcon imageIcon;

	public XMenuSeparator() {
		imageIcon = XContorlUtil.getImageIcon("ui/images/separator_background.png");
		init();
	}

	private void init() {
		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setOpaque(false);
		setIcon(imageIcon);
	}
}