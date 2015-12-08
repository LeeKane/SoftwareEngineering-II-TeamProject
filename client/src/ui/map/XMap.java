
package ui.map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JPanel;

import ui.XContorlUtil;


public class XMap extends JPanel
{
	private MapToolBar toolBar;
	private MapPanel mapPanel;

	public XMap()
	{
		setLayout(new BorderLayout());
		mapPanel = new MapPanel();
		toolBar = new MapToolBar(mapPanel);
		
		add(toolBar,BorderLayout.NORTH);
		add(mapPanel,BorderLayout.CENTER);	
	}
	public Map getMap()
	{
		return mapPanel.getMap();
	}
	
}
