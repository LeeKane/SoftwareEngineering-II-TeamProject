package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.Border;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

public class XButton extends JButton {
	private Color foregroundColor;
	private Border border;

	public XButton() {
		foregroundColor = XContorlUtil.MENUITEM_BACKGROUND;
		this.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
		init();
	}

	public XButton(String x) {
		this.setText(x);
		foregroundColor = XContorlUtil.MENUITEM_BACKGROUND;
		this.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
		init();
	}

	private void init() {
		setFont(XContorlUtil.FONT_14_BOLD);
		setForeground(foregroundColor);
	}

}
