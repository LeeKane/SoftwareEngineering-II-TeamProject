package xujun.control;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class WatermarkTextField extends JTextField {
  BufferedImage img;
  TexturePaint texture;
  public WatermarkTextField(File file) throws IOException { //临时就把异常往外抛了.
   super();                                                 //方法接收一个Image图片文件.
   img = ImageIO.read(file);
   Rectangle rect = new Rectangle(0,0,
   img.getWidth(null),img.getHeight(null));
   texture = new TexturePaint(img, rect);
   setOpaque(false);
  }
  public void paintComponent(Graphics g) {
   Graphics2D g2 = (Graphics2D)g;
   g2.setPaint(texture);
   g.fillRect(0,0,getWidth(),getHeight());
   super.paintComponent(g);
  }
//Main类我就不说了Java的基础.
  public static void main(String[] args) throws Exception {
   JFrame frame = new JFrame("Watermark JTextField Hack");
   frame.setLayout(new GridLayout(1,2));
   JTextField textfield = new WatermarkTextField(new File("/Users/akari/Desktop/SwingResult/bin/xujun/control/images/server.png"));
   textfield.setForeground(Color.white);
   textfield.setText("A Text Field");
   textfield.setSize(120,30);
   frame.getContentPane().add(textfield);
   frame.getContentPane().add(new JButton("前面那家伙真漂亮"));
   frame.setSize(250,60);
   frame.setVisible(true);
  }
}