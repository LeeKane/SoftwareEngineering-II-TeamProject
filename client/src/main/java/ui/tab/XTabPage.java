/*
 * 系统名称：
 * 模块名称：
 * 描述：
 * 作者：徐骏
 * version 1.0
 * time  2010-7-6 下午03:23:15
 * copyright Anymusic Ltd.
 */
package ui.tab;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * contentComponent是在Tab页中显示的控件，一般为JPanel
 * @author 徐骏
 * @data   2010-7-6
 */
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
