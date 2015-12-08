
package ui.tab;

import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ui.XContorlUtil;

public class XTabPanel extends JTabbedPane
{
	private int preferredUnselectedTabWidth;
	private int preferredTabHeight;

	public XTabPanel()
	{
		preferredUnselectedTabWidth = 80;
		preferredTabHeight = XContorlUtil.getImageIcon("ui/images/tab_header_background.png").getIconHeight();
		init();
	}

	private void init()
	{
		setFont(XContorlUtil.FONT_12_BOLD);
		setForeground(XContorlUtil.DEFAULT_TEXT_COLOR);
		setBorder(null);
		setFocusable(false);
		setTabLayoutPolicy(1);
		setOpaque(false);
		setUI(new XTabPanelUI(this));
		addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				updateTabComponents();
			}	
		});
	}

	
	@Override
	public void addTab(String title, Component component)
	{
		super.addTab(title, component);
		this.setVisible(true);
		int index = getTabCount() - 1;
		// 这里暂时用title代替oId
		XTabComponent tabComponent = new XTabComponent(title, this);
		tabComponent.setTitle(title);
		setTabComponentAt(index, tabComponent);
		setToolTipTextAt(index, title);
		updateTabComponents();
	}
	//设置选中操作
	public boolean isSelectTabComponents(String oId)
	{
		for(int i=0;i<getTabCount();i++)
		{
			Component c = getTabComponentAt(i);
			if (c instanceof XTabComponent)
			{
				if(((XTabComponent) c).getOId().equals(oId))
				{
					setSelectedIndex(i);
					updateTabComponents();
					return true;
				}
			}
		}
		return false;
	}

	public int getPreferredTabHeight()
	{
		return preferredTabHeight;
	}

	private void updateTabComponents()
	{
		int selectedIndex = getSelectedIndex();
		for (int i = 0; i < getTabCount(); i++)
		{
			Component c = getTabComponentAt(i);
			if (c instanceof XTabComponent)
			{
				XTabComponent component = (XTabComponent)c;
				boolean selected = selectedIndex == i;
				component.updateSelection(selected);
			}
		}

	}

	public int getPreferredUnselectedTabWidth()
	{
		return preferredUnselectedTabWidth;
	}

}
