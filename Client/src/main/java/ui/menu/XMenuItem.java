
package ui.menu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

import ui.XContorlUtil;

public class XMenuItem extends JMenuItem {
	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
	private Color foregroundColor;
	private int borderThickness;
	private Border border;
	private int preferredHeight;

	public XMenuItem() {
		backgroundColor = XContorlUtil.MENUITEM_BACKGROUND;
		foregroundColor = XContorlUtil.OUTLOOK_CONTAINER_COLOR;
		borderThickness = 1;
		border = BorderFactory.createLineBorder(backgroundColor, borderThickness);
		preferredHeight = 23;
		init();
	}

	public XMenuItem(String text) {
		super(text);
		backgroundColor = XContorlUtil.MENUITEM_BACKGROUND;
		foregroundColor = XContorlUtil.OUTLOOK_CONTAINER_COLOR;
		borderThickness = 1;
		border = BorderFactory.createLineBorder(backgroundColor, borderThickness);
		preferredHeight = 23;
		init();
	}

	private void init() {
		setForeground(foregroundColor);
		setFont(XContorlUtil.FONT_14_BOLD);
		setBackground(backgroundColor);
		setBorder(border);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.getPreferredSize().width, preferredHeight);
	}
}
