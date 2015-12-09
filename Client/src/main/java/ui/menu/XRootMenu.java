
package ui.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.TexturePaint;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.border.Border;

import ui.XContorlUtil;

public class XRootMenu extends JMenu {
	private Color foregroundColor;
	private String selectedBackgroundImageURL;
	private TexturePaint paint;
	private Border border;

	public XRootMenu() {
		foregroundColor = XContorlUtil.DEFAULT_MENU_TEXT_COLOR;
		paint = XContorlUtil.createTexturePaint("ui/images/menubar_background_selected.png");
		border = BorderFactory.createEmptyBorder(2, 0, 0, 0);
		setFont(XContorlUtil.FONT_14_BOLD);
		init();
	}

	public XRootMenu(String text) {
		super(text);
		foregroundColor = XContorlUtil.DEFAULT_MENU_TEXT_COLOR;
		paint = XContorlUtil.createTexturePaint("ui/images/menubar_background.png");
		border = BorderFactory.createEmptyBorder(2, 0, 0, 0);
		setFont(XContorlUtil.FONT_14_BOLD);
		init();
	}

	public XRootMenu(Font font) {
		foregroundColor = XContorlUtil.DEFAULT_MENU_TEXT_COLOR;
		paint = XContorlUtil.createTexturePaint("ui/images/menubar_background.png");
		border = BorderFactory.createEmptyBorder(2, 0, 0, 0);
		setFont(font);
		init();
	}

	private void init() {
		setBorder(border);
		setForeground(foregroundColor);
	}
}
