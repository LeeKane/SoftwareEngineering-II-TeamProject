package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;

import javax.swing.JSeparator;

public class XSeparator extends JSeparator {
	private Image image;
	private TexturePaint paint;

	public XSeparator() {
		image = XContorlUtil.getImage("ui/images/separator_background.png");
		paint = XContorlUtil.createTexturePaint("ui/images/separator_background.png");
	}

	public XSeparator(int direction) {
		super(direction);
		image = XContorlUtil.getImage("ui/images/separator_background.png");
		paint = XContorlUtil.createTexturePaint("ui/images/separator_background.png");
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(paint);
		int x = 0;
		int y = 0;
		int width = getWidth();
		int height = image.getHeight(null);
		g2d.fillRect(x, y, width, height);
	}
}
