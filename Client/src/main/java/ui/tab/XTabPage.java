
package ui.tab;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class XTabPage extends JPanel
{
	private JPanel centerPane;

	public XTabPage()
	{
		this(null);
		this.setOpaque(true);
	}

	public XTabPage(JComponent contentComponent)
	{
		centerPane = new JPanel(new BorderLayout());
		init(contentComponent);
	}

	private void init(JComponent contentComponent)
	{
		setLayout(new BorderLayout());
		add(centerPane, "Center");
		contentComponent.setOpaque(true);
		if (contentComponent != null)
			centerPane.add(contentComponent, "Center");
	}

	public JPanel getCenterPane()
	{
		return centerPane;
	}
}
