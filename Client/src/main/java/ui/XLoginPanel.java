package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;

import javax.swing.JPanel;

public class XLoginPanel extends JPanel {

	private TexturePaint paint = XContorlUtil.createTexturePaint("ui/images/login1.png");

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(paint);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	public void setPaint() {
		paint = XContorlUtil.createTexturePaint("ui/images/login2.png");
	}

	public void reSetPaint() {
		paint = XContorlUtil.createTexturePaint("ui/images/login1.png");
	}
}
