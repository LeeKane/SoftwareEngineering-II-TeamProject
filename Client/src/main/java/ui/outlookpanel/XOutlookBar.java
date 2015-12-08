
package ui.outlookpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ui.XContorlUtil;

//一级选项

public class XOutlookBar extends JPanel
{
	private Image backgroundSelectedLeft;
	private Image backgroundSelectedRight;
	private Image backgroundImage;
	private ImageIcon handlerIcon;
	private ImageIcon handlerSelectedIcon;
	private TexturePaint paint;
	private TexturePaint selectedPaint;
	private XOutlookLabel lbHandler;
	private Border handlerBorder;
	private Border handlerShrinkedBorder;
	private XOutlookLabel lbIcon;
	private XOutlookLabel lbTitle;
	private boolean selected;
	private Color titleColor;
	private Color selectedTitleColor;
	private MouseListener mouseListener;
	private MouseListener mouseListener2;
	private String text;

	private Icon icon = null;
	private Icon selectedIcon = null;
	private XOutlookPanel outlookPanel;
	private String actionCommand;
	
	
	public XOutlookBar(XOutlookPanel panel,MouseListener mouseListener,String command)
	{	
		super();
		this.actionCommand=command;
		backgroundSelectedLeft = XContorlUtil.getImage("ui/images/outlook_bar_background_selected_left.png");
		backgroundSelectedRight = XContorlUtil.getImage("ui/images/outlook_bar_background_selected_right.png");
		backgroundImage = XContorlUtil.getImage("ui/images/outlook_bar_background.png");
		handlerIcon = XContorlUtil.getImageIcon("ui/images/outlook_bar_handler.png");
		handlerSelectedIcon = XContorlUtil.getImageIcon("ui/images/outlook_bar_handler_selected.png");
		paint = XContorlUtil.createTexturePaint("ui/images/outlook_bar_background.png");
		selectedPaint = XContorlUtil.createTexturePaint("ui/images/outlook_bar_background_selected.png");
		lbHandler = new XOutlookLabel(actionCommand);
		handlerBorder = BorderFactory.createEmptyBorder(0, 0, 0, 16);
		handlerShrinkedBorder = BorderFactory.createEmptyBorder(0, 0, 0, 22);
		lbIcon = new XOutlookLabel(actionCommand);
		lbTitle = new XOutlookLabel(actionCommand);
		selected = false;
		titleColor = XContorlUtil.DEFAULT_OUTLOOK_TEXT_COLOR;
		selectedTitleColor = XContorlUtil.SELECTED_TEXT_COLOR;
		mouseListener2 = new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				if (((JComponent) e.getSource()).contains(e.getPoint()))
					changeStatus();
			}
		};
		this.mouseListener=mouseListener;
		this.outlookPanel = panel;
		
		init();
	}

	private void init()
	{
		setLayout(new BorderLayout());
//		add(lbHandler, "East");
		lbIcon.setVerticalAlignment(0);
		lbIcon.setBorder(BorderFactory.createEmptyBorder(2, 16, 0, 0));
		add(lbIcon, "West");
		lbTitle.setVerticalAlignment(0);
		lbTitle.setBorder(BorderFactory.createEmptyBorder(0, 22, 0, 0));
		lbTitle.setFont(XContorlUtil.FONT_14_BOLD);
		lbTitle.setForeground(titleColor);
		add(lbTitle, "Center");
		lbHandler.addMouseListener(mouseListener);
		lbTitle.addMouseListener(mouseListener);
		lbIcon.addMouseListener(mouseListener);	
		lbHandler.addMouseListener(mouseListener2);
		lbTitle.addMouseListener(mouseListener2);
		lbIcon.addMouseListener(mouseListener2);	
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (isSelected())
		{
			g2d.setPaint(selectedPaint);
			if (getSelectedIcon() != null)
				lbIcon.setIcon(getSelectedIcon());
			else
				lbIcon.setIcon(getIcon());
		}
		else
		{
			g2d.setPaint(paint);
			lbIcon.setIcon(getIcon());
		}
		g2d.fillRect(0, 0, getWidth(), getHeight());
//		if (isSelected())
//		{
//			g2d.drawImage(backgroundSelectedLeft, 0, 0, null);
//			g2d.drawImage(backgroundSelectedRight, getWidth()
//					- backgroundSelectedRight.getWidth(null), 0, null);
//		}
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(super.getPreferredSize().width, backgroundImage
				.getHeight(null));
	}
	public void setSelected(boolean selected)
	{
		if (selected != this.selected)
		{
			if (!isSelected())
				outlookPanel.closeAllBars();
			this.selected = selected;
			if (selected)
			{
				lbHandler.setIcon(handlerSelectedIcon);
				lbTitle.setForeground(selectedTitleColor);
			}
			else
			{
				lbHandler.setIcon(handlerIcon);
				lbTitle.setForeground(titleColor);
			}
			
//			outlookPanel.updateLayoutConstraint(getContentComponent(), selected);
//			outlookPanel.setAdditionalPaneVisible(!selected);
//			outlookPanel.revalidate();
		}
	}
	public void changeStatus()
	{	if(!isSelected())
			setSelected(!isSelected());
	}
	public boolean isSelected()
	{
		return selected;
	}
	public Icon getIcon()
	{
		return icon;
	}
	public void setIcon(Icon icon)
	{
		this.icon = icon;
		updateIcon();
	}
	public Icon getSelectedIcon()
	{
		return selectedIcon;
	}
	public void setSelectedIcon(Icon selectedIcon)
	{
		this.selectedIcon = selectedIcon;
		updateIcon();
	}
	private void updateIcon()
	{
		if (selected)
			lbIcon.setIcon(selectedIcon);
		else
			lbIcon.setIcon(icon);
	}
	public void setTitle(String title)
	{
		lbTitle.setText(title);
		lbTitle.setToolTipText(title);
		lbHandler.setToolTipText(title);
		lbIcon.setToolTipText(title);
		this.text=title;
	}
	public String getTitle()
	{
		return lbTitle.getText();
	}
	
	public XOutlookPanel getOutlookPanel()
	{
		return this.outlookPanel;
	}
	public void headerShrinkChanged(boolean headShrinked)
	{
		if (headShrinked){
			lbHandler.setBorder(handlerShrinkedBorder);
			lbTitle.setText("");
		}
		else{
			lbHandler.setBorder(handlerBorder);
			lbTitle.setText(this.text);
		}
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
