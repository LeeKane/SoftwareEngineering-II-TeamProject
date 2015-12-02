/*
 * 系统名称：
 * 模块名称：
 * 描述：
 * 作者：徐骏
 * version 1.0
 * time  2010-7-7 上午10:57:59
 * copyright Anymusic Ltd.
 */
package ui;

import javax.swing.JList;


/**
 * @author 徐骏
 * @data   2010-7-7
 */
//工作区
public class XList extends JList
{

	public XList()
	{
		init();
	}

	private void init()
	{
		setFont(XContorlUtil.FONT_12_BOLD);
		setForeground(XContorlUtil.DEFAULT_TEXT_COLOR);
		setBackground(XContorlUtil.LIST_BACKGROUND);
		setCellRenderer(new XListRenderer(this));
		setSelectionMode(0);
	}
}
