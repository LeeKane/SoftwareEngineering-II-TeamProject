
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

//工作区的选项
public class XListRenderer extends DefaultListCellRenderer
{
	private JPanel itemRender;
	private int separatorHeight = 30;
	//每组List的分割Group
	private JPanel separatorPanel;
	private JLabel separatorLabel;
	private XSeparator separator;
	private Color itemTextColor;
	private Color separatorTextColor;
	private Color itemSelectedBackground;
	private Color itemSelectedBorder;
	private Font separatorFont;
	
	public XListRenderer(XList list)
	{
		super();
		itemRender = new JPanel(new BorderLayout());
		separatorPanel = new JPanel() {

			public Dimension getPreferredSize()
			{
				Dimension size = super.getPreferredSize();
				return new Dimension(size.width, separatorHeight);
			}

		};
		//分割Group的样式
		separatorLabel = new JLabel();
		separator = new XSeparator(0);
		separatorTextColor = Color.white;
		separatorFont = XContorlUtil.FONT_12_BOLD;
		
		itemTextColor = XContorlUtil.LIST_TEXT_COLOR;	
		itemSelectedBackground = new Color(199, 198, 200);
		itemSelectedBorder = new Color(163, 163, 163);	
		itemRender.setOpaque(false);
		itemRender.add(this, "Center");
		separatorPanel.setLayout(new OverlayLayout(separatorPanel));
		JPanel separatorHelpPane = new JPanel(new BorderLayout());
		separatorHelpPane.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));
		separatorHelpPane.add(separator);
		separatorHelpPane.setOpaque(false);
		separatorPanel.setOpaque(false);
		separatorLabel.setOpaque(true);
		separatorLabel.setBackground(XContorlUtil.LIST_BACKGROUND);
		separatorLabel.setForeground(separatorTextColor);
		separatorLabel.setFont(separatorFont);
		separatorLabel.setVerticalAlignment(1);
		separatorLabel.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));
		JPanel labelHelpPane = new JPanel(new BorderLayout());
		labelHelpPane.setBorder(BorderFactory.createEmptyBorder(6, 15, 0, 0));
		labelHelpPane.add(separatorLabel, "West");
		labelHelpPane.setOpaque(false);
		separatorPanel.add(labelHelpPane);
		separatorPanel.add(separatorHelpPane);
	}
}
