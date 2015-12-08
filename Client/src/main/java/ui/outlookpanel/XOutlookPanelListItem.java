
package ui.outlookpanel;

import javax.swing.Icon;

//二级选项设置
public class XOutlookPanelListItem
{
	private Icon icon;
	private String text;
	private String toolTip;
	private String actionCommand;
	
	public void setIcon(Icon icon)
	{
		this.icon = icon;
	}

	public Icon getIcon()
	{
		return icon;
	}
	
	public void setText(String value)
	{
		this.text = value;
	}
	
	public String getText()
	{
		return text;
	}

	public void setToolTip(String toolTip)
	{
		this.toolTip = toolTip;
	}

	public String getToolTip()
	{
		return toolTip;
	}

	public void setActionCommand(String actionCommand)
	{
		this.actionCommand = actionCommand;
	}

	public String getActionCommand()
	{
		return actionCommand;
	}
}
