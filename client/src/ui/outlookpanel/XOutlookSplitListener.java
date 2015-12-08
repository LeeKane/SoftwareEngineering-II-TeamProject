
package ui.outlookpanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

import ui.XHeader;
import ui.XListSplitListener;


public class XOutlookSplitListener extends XListSplitListener
{
	public XOutlookSplitListener(XHeader header)
	{
		super(header);
	}

	public void mouseDragged(MouseEvent e)
	{
		if (!header.isShrinked() && lastPoint != null)
		{
			JComponent parent = (JComponent)header.getParent();
			Dimension size = parent.getPreferredSize();
			Point thisPoint = e.getPoint();
			int xMovement = thisPoint.x - lastPoint.x;
			size.width += xMovement;
			size.width = Math.max(size.width, 37);
			parent.setPreferredSize(size);
			header.revalidateParent();
		}
	}
}
