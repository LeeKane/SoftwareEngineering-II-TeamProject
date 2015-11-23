/*
 * 系统名称：
 * 模块名称：
 * 描述：
 * 作者：徐骏
 * version 1.0
 * time  2010-7-2 下午02:17:13
 * copyright Anymusic Ltd.
 */
package ui.outlookpanel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import ui.XContorlUtil;

/**
 * @author 徐骏
 * @data   2010-7-2
 */
//Outlook中的二级选项
public class XOutlookListRenderer extends DefaultListCellRenderer
{
	private Color selectedColor;
	private Border normalBorder;
	private Border shrinkedBorder;
	
	public XOutlookListRenderer()
	{
		super();
		selectedColor = new Color(41,57,75);
		normalBorder = BorderFactory.createEmptyBorder(3, 19, 3, 2);
		shrinkedBorder = BorderFactory.createEmptyBorder(2, 7, 1, 2);
	}
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
		
		XOutlookPanelListItem listItem = (XOutlookPanelListItem)value;
		XOutlookList outlookList = (XOutlookList)list;
		setToolTipText(listItem.getToolTip());
		setIcon(listItem.getIcon());
		//收缩样式
		if (outlookList.getOutlookBar().getOutlookPanel().isShrinked())
		{
			setBorder(shrinkedBorder);
			setText(null);
		} 
		//普通样式
		else 
		{
			setBorder(normalBorder);
			setText(listItem.getText());
			setHorizontalAlignment(SwingConstants.LEADING);
			setIconTextGap(5);
		}
		if (!isSelected)
			setBackground(new Color(41,57,75));
		else
			setBackground(new Color(39,54,73));
		return this;
	}
}
