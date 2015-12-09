
package ui.statusbar;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;

import ui.XContorlUtil;

public class XStatusLabel extends JLabel {
	public XStatusLabel() {
		this(null, null);
	}

	public XStatusLabel(String text) {
		this(text, null);
	}

	public XStatusLabel(Icon icon) {
		this(null, icon);
	}

	public XStatusLabel(String text, Icon icon) {
		super(text, icon, 10);
		init();
	}

	protected void init() {
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		setFont(XContorlUtil.FONT_12_BOLD);
		setForeground(XContorlUtil.DEFAULT_TEXT_COLOR);
		setVerticalAlignment(0);
		setVerticalTextPosition(0);
		setIconTextGap(5);
	}
}
