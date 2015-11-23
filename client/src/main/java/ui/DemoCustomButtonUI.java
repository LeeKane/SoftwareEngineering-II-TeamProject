package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

/** DemoCustomButtonUI - demonstrates how to create a custom look and feel for
* a Swing component such as a <code>JButton</code>.<p>
*
* In Java, the implementation of the model-view-controller architecture
* combines the view and the controller into an entity known as a
* <i>UI delegate</i>.  (The word "delegate" loosely refers to
* "delegating"
* the UI responsibilities to a single entity, rather than integrating the UI
* in the model or in the component class itself.)  
* This strategy is taken due to the very tight inter-relationship between the
* view and the controller.  As noted by Fowler (see below), Sun's Swing
* developers found it very difficult to write a generic <i>controller</i>
* that did not know the specifics of the <i>view</i>.  Thus, they collapsed
* the two into a single entity -- the UI delegate.<p>
*
* The view and the controller, collectively,
* are often referred to
* in Java as the <i>look and feel</i> (L&F), where the <i>look</i> is the
* <i>view</i>, and the <i>feel</i> is the <i>controller</i>.<p>
*
* By combining the L&F, the wholesale replacement of one L&F for
* another is possible.  This is known in Java as
* <i>plugable look and feel</i>.<p>
*
* All L&F delegates are subclasses of the <code>ComponentUI</code>
* abstract class in the <code>javax.swing.plaf</code> package.
* <code>ComponentUI</code> includes many subclasses
* (also abstract),
* for example, <code>ButtonUI</code>, <code>ColorChooserUI</code>,
* <code>ComboBoxUI</code>, <code>LabelUI</code>,
* <code>ListUI</code>, <code>MenuBarUI</code>,
* <code>ScrollBarUI</code>, <code>ScrollPaneUI</code>, and so on.
* (The naming convention is to remove the "J" from the beginning of the
* component's class name, and add "UI" to the end.)
* Each of these, in term, includes one or more subclasses
* implementing a particular L&F.  For example, <code>ButtonUI</code>
* has a subclass named <code>BasicButtonUI</code> which implements
* the default L&F for a <code>JButton</code>.  In this demo program,
* we implement a new L&F for a <code>JButton</code> in a class (for
* convenience, an inner class) called <code>CustomButtonUI</code>.<p>
*
* <b>Note:</b> This demo does not implement all the details necessary
* to fully replace the look and feel for a <code>JButton</code>.
* For further details, read the article
* <a href="http://java.sun.com/products/jfc/tsc/articles/architecture/index.html">A Swing architecture overview: The inside story on JFC component design</a>
* by Amy Fowler.
* <p>
*
* Additionally, you can study the source code for classes such as
* <code>JComponent</code>, <code>ComponentUI</code>,
* <code>ButtonUI</code>, <code>BasicButtonUI</code>, etc.
* The source code for all Java classes
* is available from Sun's web site at
* <a href = "http://java.sun.com/j2se/">http://java.sun.com/j2se/</a>.<p>
*
* Screen snaps:<p>
*
* <code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Launch...</code><br>
* <center><img src="DemoCustomButtonUI-1.gif"></center><p>
* 
* <code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Custom button armed...</code><br>
* <center><img src="DemoCustomButtonUI-2.gif"></center><p>
* 
* <code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Custom button pressed...</code><br>
* <center><img src="DemoCustomButtonUI-3.gif"></center><p>
* 
* @see <a href="DemoCustomButtonUI.java">source code</a>
* @author Scott MacKenzie, 2002
*/
public class DemoCustomButtonUI
{
   public static void main(String[] args)
   {
      // use look and feel for my system (Win32)
      try {
         UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {}

      DemoCustomButtonUIFrame frame = new DemoCustomButtonUIFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("DemoCustomButtonUI");
      frame.pack();
      frame.show();
   }
}

class DemoCustomButtonUIFrame extends JFrame implements ActionListener
{
   JButton b1;
   JButton b2;

   public DemoCustomButtonUIFrame()
   {
      // ----------------------------------
      // construct and configure components
      // ----------------------------------

      b1 = new JButton("Regular Button");
      b2 = new JButton("Custom Button");

      // set a custom UI delegate

      b2.setUI(new CustomButtonUI());

      // -------------
      // add listeners
      // -------------

      b1.addActionListener(this);
      b2.addActionListener(this);

      // -----------------
      // layout components
      // -----------------

      JPanel panel = new JPanel();
      panel.add(b1);
      panel.add(b2);
      panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

      // make panel this JFrame's content pane

      this.setContentPane(panel);
   }

   // -------------------------------
   // implement ActionListener method
   // -------------------------------

   public void actionPerformed(ActionEvent ae)
   {
      if (ae.getSource() == b1)
         System.out.println("Regular button pressed");
      else if (ae.getSource() == b2)
         System.out.println("Custom button pressed");
   }

   // -----------
   // inner class
   // -----------

   class CustomButtonUI extends ButtonUI
   {
      final Insets I = new Insets(8, 15, 8, 15);

      public void installUI(JComponent c)
      {
         AbstractButton b = (AbstractButton)c;
         BasicButtonListener listener = new BasicButtonListener(b);
         b.addMouseListener(listener);
      }

      public void uninstallUI(JComponent c)
      {
         AbstractButton b = (AbstractButton)c;
         BasicButtonListener listener = new BasicButtonListener(b);
         b.removeMouseListener(listener);
      }

      public Insets getDefaultMargin(AbstractButton ab)
      {
         return I;
      }

      public Insets getInsets(JComponent c)
      {
         return I;
      }

      public Dimension getMaximumSize(JComponent c)
      {
         return this.getPreferredSize(c);
      }

      public Dimension getMinimumSize(JComponent c)
      {
         return this.getPreferredSize(c);
      }

      public Dimension getPreferredSize(JComponent c)
      {
         Graphics g = c.getGraphics();
         FontMetrics fm = g.getFontMetrics();

         Dimension d = new Dimension();
         d.width = fm.stringWidth(((JButton)c).getText()) +  I.left + I.right;
         d.height = fm.getHeight() + I.top + I.bottom;
         return d;
      }

      public void paint(Graphics g, JComponent c)
      {
         Graphics2D g2 = (Graphics2D)g;

         AbstractButton b = (AbstractButton)c;
         ButtonModel bm = b.getModel();

         FontMetrics fm = g2.getFontMetrics();

         // define some colors for drawing
     
         Color backgroundColor;
         Color bevelColor;
         Color lineColor;

         if (bm.isArmed() && !bm.isPressed())
         {
            backgroundColor = new Color(255, 204, 102);
            bevelColor = new Color(235, 160, 45);
            lineColor = bevelColor;
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         else if (bm.isPressed())
         {
            backgroundColor = new Color(235, 160, 45);
            bevelColor = new Color(255, 204, 102);
            lineColor = new Color(188, 119, 18);
         }
         else
         {
            backgroundColor = new Color(153, 204, 102);
            bevelColor = new Color(53, 160, 107);
            lineColor = bevelColor;
         }

         // define some polygons for drawing

         Dimension d = c.getPreferredSize();
         int x = d.width - 1;    // x-coordinate of right edge
         int y = d.height - 1;   // y-coordinate of bottom edge
         final int BW = 3;       // bevel width

         int[] outerX = { 0, 0, x, x };
         int[] outerY = { 0, y, y, 0 };
         //int[] outerY = { 0, y, 0, 0 };

         int[] innerX = { BW, BW, x - BW, x - BW };
         int[] innerY = { BW, y - BW, y - BW, BW };

         int[] topBevelX = { 0, BW, x - BW, x };
         int[] topBevelY = { 0, BW, BW, 0 };

         int[] leftBevelX = { 0, 0, BW, BW };
         int[] leftBevelY = { 0, y, y - BW, BW };

         int[] bottomBevelX = { 0, x, x - BW, BW };
         int[] bottomBevelY = { y, y, y - BW, y - BW };

         int[] rightBevelX = { x, x - BW, x - BW, x };
         int[] rightBevelY = { 0, BW, y - BW, y };

         Polygon outer = new Polygon(outerX, outerY, outerX.length);
         Polygon inner = new Polygon(innerX, innerY, innerX.length);
         Polygon topBevel = new Polygon(topBevelX, topBevelY, topBevelX.length);
         Polygon leftBevel = new Polygon(leftBevelX, leftBevelY, leftBevelX.length);
         Polygon bottomBevel = new Polygon(bottomBevelX, bottomBevelY, bottomBevelX.length);
         Polygon rightBevel = new Polygon(rightBevelX, rightBevelY, rightBevelX.length);

         g2.setColor(backgroundColor);
         g2.fillPolygon(outer);

         g2.setColor(bevelColor);
         g2.fillPolygon(topBevel);
         g2.fillPolygon(rightBevel);

         g2.setColor(lineColor);
         g2.drawPolygon(outer);
         g2.drawPolygon(inner);
         g2.drawPolygon(topBevel);
         g2.drawPolygon(leftBevel);
         g2.drawPolygon(bottomBevel);
         g2.drawPolygon(rightBevel);
         g2.drawPolygon(outer);

         // paint foreground

         g2.setColor(Color.black);
         String s = ((JButton)c).getText();
         x = I.left;
         y = I.top + fm.getAscent();
         g2.drawString(s, x, y);
      }
   }
}