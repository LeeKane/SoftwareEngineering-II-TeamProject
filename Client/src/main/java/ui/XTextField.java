package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TexturePaint;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class XTextField extends JTextField implements FocusListener {
	private Color foregroundColor;
	private ImageIcon backgroundImageIcon;
	private TexturePaint paint;
	private Border border;
	private String hint;
	private boolean showingHint;

	public XTextField() {
		foregroundColor = XContorlUtil.DEFAULT_OUTLOOK_TEXT_COLOR;
		backgroundImageIcon = XContorlUtil.getImageIcon("ui/images/search.png");
		paint = XContorlUtil.createTexturePaint("ui/images/search.png");
		border = BorderFactory.createEmptyBorder(1, 3, 1, 3);
		init();
	}

	public XTextField(String hint) {
		this();
		this.hint = hint;
		this.showingHint = true;
		super.addFocusListener(this);
		setText(hint);
	}

	private void init() {
		setBorder(border);
		setFont(XContorlUtil.FONT_14_BOLD);
		setForeground(foregroundColor);
//		setUI(new BETextFieldUI() {
//
//			protected void paintBackground(Graphics g) {
//				Graphics2D g2d = (Graphics2D) g;
//				g2d.setPaint(paint);
//				g2d.fillRect(0, 0, getWidth(), getHeight());
//			}
//
//		});
	}

	public Dimension getPreferredSize() {
		return new Dimension(super.getPreferredSize().width, backgroundImageIcon.getIconHeight());
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText("");
			showingHint = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(hint);
			showingHint = true;
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}
}
