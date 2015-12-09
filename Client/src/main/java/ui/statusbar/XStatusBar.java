
package ui.statusbar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ui.XContorlUtil;
import util.Permission;

public class XStatusBar extends JPanel {
	private String backgroundImageURL;
	private Image backgroundLeftImage;
	private Image backgroundRightImage;
	private ImageIcon backgroundImageIcon;
	private TexturePaint paint;
	private JPanel leftPane;
	private JPanel rightPane;
	private Border border;
	private Permission permission;

	public XStatusBar(Permission permission) {
		this.permission = permission;

		backgroundLeftImage = XContorlUtil.getImage("ui/images/statusbar_background_left.png");
		backgroundRightImage = XContorlUtil.getImage("ui/images/statusbar_background_right.png");
		backgroundImageIcon = XContorlUtil.getImageIcon("ui/images/statusbar_background.png");
		paint = XContorlUtil.createTexturePaint("ui/images/statusbar_background.png");
		leftPane = new JPanel(new BorderLayout());
		rightPane = new JPanel(new FlowLayout(3, 0, 0));
		border = BorderFactory.createEmptyBorder(2, 10, 0, 0);
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		add(leftPane, "Center");
		add(rightPane, "East");
		setBorder(border);
		leftPane.setOpaque(false);
		rightPane.setOpaque(false);

		addDefaultSubLabel();
	}

	private void addDefaultSubLabel() {
		// 消息
		leftPane.add(new XStatusMessageLabel(), BorderLayout.CENTER);
		addSeparator();
		// 内存
		rightPane.add(new XMemoryBar());
		addSeparator();
		// 释放内存
		rightPane.add(new XGCButton());
		addSeparator();
		// 当前用户
		rightPane.add(new XStatusLabel(permission.toString(), XContorlUtil.getImageIcon("ui/images/user.png")));
		addSeparator();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(paint);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	public JPanel getLeftPane() {
		return leftPane;
	}

	public JPanel getRightPane() {
		return rightPane;
	}

	public void addSeparator() {
		rightPane.add(new XStatusSeparator());
	}

	public Dimension getPreferredSize() {
		return new Dimension(super.getPreferredSize().width, backgroundImageIcon.getIconHeight());
	}
}
