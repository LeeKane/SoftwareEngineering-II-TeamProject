
package ui.outlookpanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

import layout.TableLayout;
import ui.XContorlUtil;

public class XOutlookPanel extends JPanel {
	// Header
	private XOutlookHeader header;
	// 容器Panel//就是放所有标签的，采用TableLayout
	private JPanel barPane;
	// barPane的背景
	private JPanel additionalPane;
	private Hashtable componentLayoutRows;
	private JPanel centerPane;
	private TableLayout barPaneLayout;
	private MouseListener mouseListener;

	/**
	 * 构造XOutlookPanel
	 * 
	 * @param headerListener
	 *            Header的监听器
	 * @param listSelectionListener
	 *            ListItemSelection的监听器
	 */
	public XOutlookPanel(ActionListener headerListener, MouseListener mouseListener) {
		super();
		// 注册Header事件//收缩功能shrink
		this.header = new XOutlookHeader(headerListener) {
			public void setShrink(boolean shrinked) {
				super.setShrink(shrinked);
				shrinkChanged(shrinked);
			}

		};
		this.mouseListener = mouseListener;
		barPaneLayout = new TableLayout();
		barPane = new JPanel(barPaneLayout);

		additionalPane = new JPanel(new BorderLayout());
		componentLayoutRows = new Hashtable();
		centerPane = new JPanel(new BorderLayout());

		init();
	}

	private void init() {
		additionalPane.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		additionalPane.setPreferredSize(new Dimension(0, 0));
		additionalPane.setBorder(new Border() {

			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				g.setColor(XContorlUtil.OUTLOOK_SPLIT_COLOR);
			}

			public Insets getBorderInsets(Component c) {
				return new Insets(1, 0, 0, 0);
			}

			public boolean isBorderOpaque() {
				return true;
			}

		});

		centerPane.add(barPane, "North");
		centerPane.add(additionalPane, "Center");
		barPaneLayout.insertColumn(0, -1D);
		setLayout(new BorderLayout());

		add(header, "North");
		add(centerPane, "Center");
	}

	public XOutlookBar addBar(String title, Icon icon, Icon selectedIcon, String command, MouseListener mouseListener) {
		XOutlookBar bar = new XOutlookBar(this, mouseListener, command);
		bar.setSelected(false);
		bar.setTitle(title);
		bar.setIcon(icon);
		bar.setSelectedIcon(selectedIcon);
		bar.setActionCommand(command);
		int rowCount = barPaneLayout.getRow().length;
		barPaneLayout.insertRow(rowCount, -2D);
		barPane.add(bar, (new StringBuilder()).append("0,").append(rowCount).toString());
		componentLayoutRows.put(bar, Integer.valueOf(rowCount));
		rowCount++;
		barPaneLayout.insertRow(rowCount, -3D);
		// 加载列表
		return bar;
	}

	public void updateLayoutConstraint(Component component, boolean selected) {
		int rowIndex = ((Integer) componentLayoutRows.get(component)).intValue();
		double constraint = -1D;
		if (!selected)
			constraint = -3D;
		barPaneLayout.setRow(rowIndex, constraint);
	}

	public JComponent getAdditionalPane() {
		return additionalPane;
	}

	public void setAdditionalPaneVisible(boolean visible) {
		centerPane.remove(barPane);
		centerPane.remove(additionalPane);
		if (visible) {
			centerPane.add(barPane, "North");
			centerPane.add(additionalPane, "Center");
		} else {
			centerPane.add(barPane, "Center");
		}
	}

	public void closeAllBars() {
		for (int i = 0; i < barPane.getComponentCount(); i++) {
			Component c = barPane.getComponent(i);
			if (!(c instanceof XOutlookBar))
				continue;
			XOutlookBar bar = (XOutlookBar) c;
			if (bar.isSelected())
				bar.setSelected(false);
		}
	}

	public XOutlookBar getSelectedBar() {
		for (int i = 0; i < barPane.getComponentCount(); i++) {
			Component c = barPane.getComponent(i);
			if (!(c instanceof XOutlookBar))
				continue;
			XOutlookBar bar = (XOutlookBar) c;
			if (bar.isSelected())
				return bar;
		}

		return null;
	}

	public void setShrink(boolean shrinked) {
		header.setShrink(shrinked);
	}

	public boolean isShrinked() {
		return header.isShrinked();
	}

	private void shrinkChanged(boolean shrinked) {
		for (int i = 0; i < barPane.getComponentCount(); i++) {
			Component c = barPane.getComponent(i);
			if (c instanceof XOutlookBar) {
				XOutlookBar bar = (XOutlookBar) c;
				bar.headerShrinkChanged(shrinked);
			}
		}
	}

	public MouseListener getMouseListener() {
		return mouseListener;
	}

	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}
}
