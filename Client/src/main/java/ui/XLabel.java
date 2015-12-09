package ui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class XLabel extends JLabel {
	private Color foregroundColor;
	private Border border;

	public XLabel(String text) {
		super(text);
		foregroundColor = XContorlUtil.DEFAULT_MENU_TEXT_COLOR;
		border = BorderFactory.createEmptyBorder(0, 2, 0, 2);
		init();
	}

	public XLabel(Icon icon) {
		super(icon);
		foregroundColor = XContorlUtil.DEFAULT_MENU_TEXT_COLOR;
		border = BorderFactory.createEmptyBorder(0, 2, 0, 2);
		init();
	}

	private void init() {
		setFont(XContorlUtil.FONT_14_BOLD);
		setBorder(border);
		setForeground(foregroundColor);
	}
}
