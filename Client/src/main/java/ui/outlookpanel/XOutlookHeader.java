
package ui.outlookpanel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ui.XHeader;

public class XOutlookHeader extends XHeader {
	private LayoutManager toolbarLayout;
	private JPanel toolbar;
	private ImageIcon separatorIcon;

	public XOutlookHeader(ActionListener listener) {
		toolbarLayout = new FlowLayout(FlowLayout.LEFT, 2, 1);
		toolbar = new JPanel(toolbarLayout);
		init();
	}

	private void init() {
		toolbar.setOpaque(false);
		toolbar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		add(toolbar, "Center");
	}
	// 在Header上添加工具按钮

	protected Object getResizeHandlerLayoutConstraint() {
		return "East";
	}

	protected Object getShrinkHandlerLayoutConstraint() {
		return "West";
	}

	protected Border createBorder() {
		return BorderFactory.createEmptyBorder(4, 0, 0, 7);
	}

	protected ImageIcon getShrinkIcon(boolean shrinked) {
		if (shrinked)
			return RIGHT_ARROW_ICON;
		else
			return LEFT_ARROW_ICON;
	}

	protected JComponent getCenterComponent() {
		return null;
	}

	public void setShrink(boolean shrinked) {
		super.setShrink(shrinked);
		toolbar.setVisible(!shrinked);
	}

	protected int getShrinkedWidth() {
		return 37;
	}

	public JPanel getToolBar() {
		return toolbar;
	}
}
