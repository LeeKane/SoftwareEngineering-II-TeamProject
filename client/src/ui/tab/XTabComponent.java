/*
 * 系统名称：
 * 模块名称：
 * 描述：
 * 作者：徐骏
 * version 1.0
 * time  2010-7-6 下午03:08:58
 * copyright Anymusic Ltd.
 */
package ui.tab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ui.XContorlUtil;


/**
 * TabPanel的包装面板
 * @author 徐骏
 * @data   2010-7-6
 */
public class XTabComponent extends JPanel
{

	private String backgroundUnselectedImageURL;
	private TexturePaint selectedPaint;
	private TexturePaint unselectedPaint;
	private ImageIcon icon;
	private ImageIcon pressedIcon;
	private Image unselectedLeftImage;
	private Image unselectedRightImage;
	private Image selectedLeftImage;
	private Image selectedRightImage;
	private JButton btnClose;
	private JLabel lbTitle;
	private XTabPanel tab;
	private Color selectedTitleColor;
	private Color unselectedTitleColor;
	private Border border;
	private String oId;
	
	public XTabComponent(String oId,XTabPanel tab)
	{
		super();
		setOpaque(true);
		this.oId = oId;
		selectedPaint = XContorlUtil.createTexturePaint("ui/images/tab_header_background.png");
		unselectedPaint = XContorlUtil.createTexturePaint("ui/images/tab_header_unselected_background.png");
		icon = XContorlUtil.getImageIcon("ui/images/tab_close.png");
		pressedIcon = XContorlUtil.getImageIcon("ui/images/tab_close_pressed.png");
		unselectedLeftImage = XContorlUtil.getImage("ui/images/tab_header_unselected_background.png");
		unselectedRightImage = XContorlUtil.getImage("ui/images/tab_header_unselected_background.png");
		selectedLeftImage = XContorlUtil.getImage("ui/images/tab_header_background.png");
		selectedRightImage = XContorlUtil.getImage("ui/images/tab_header_background.png");
		btnClose = new JButton();
		lbTitle = new JLabel();
		this.tab = null;
		selectedTitleColor = XContorlUtil.SELECTED_TEXT_COLOR;
		unselectedTitleColor = XContorlUtil.DEFAULT_TAB_TEXT_COLOR;
		border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		this.tab = tab;
		init();
	}

	private void init()
	{
		btnClose.setIcon(icon);
		btnClose.setPressedIcon(pressedIcon);
		btnClose.setToolTipText("Close this tab");
		btnClose.setMargin(XContorlUtil.ZERO_INSETS);
		btnClose.setFocusPainted(false);
		btnClose.setBorder(BorderFactory.createEmptyBorder(0, 3, 1, 3));
		btnClose.setContentAreaFilled(false);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				closeTab();
			}

		});
		lbTitle.setOpaque(false);
		lbTitle.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		lbTitle.setVerticalAlignment(0);
		lbTitle.setFont(XContorlUtil.FONT_12_BOLD);
		setLayout(new BorderLayout());
		add(btnClose, "East");
		add(lbTitle, "Center");
		setBorder(border);
		setOpaque(false);
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		if (isTabSelected())
		{
			//g2d.drawImage(selectedLeftImage, 0, 0, null);
			g2d.setPaint(selectedPaint);
			int x = selectedLeftImage.getWidth(null);
			int y = 0;
//			int width = getWidth() - x - selectedRightImage.getWidth(null);
//			int height = getHeight();
			g2d.fillRect(x, y, 2000, getHeight());
//			g2d.drawImage(selectedRightImage, x + width, 0, null);
		} else
		{
			//g2d.drawImage(unselectedLeftImage, 0, 0, null);
			g2d.setPaint(unselectedPaint);
			int x = unselectedLeftImage.getWidth(null);
			int y = 0;
			int width = getWidth() - x - selectedRightImage.getWidth(null);
			int height = getHeight();
			g2d.fillRect(x, y, width, height);
			g2d.drawImage(unselectedRightImage, x + width, 0, null);
			g2d.setColor(XContorlUtil.TAB_BOTTOM_LINE_COLOR);
			int lineY = getHeight() - 1;
			g2d.drawLine(0, lineY, getWidth(), lineY);
		}
	}

	public Dimension getPreferredSize()
	{
		int width = super.getPreferredSize().width;
		if (!isTabSelected())
			width = Math.min(width, tab.getPreferredUnselectedTabWidth());
		int height = tab.getPreferredTabHeight();
		return new Dimension(width, height);
	}

	public boolean isTabSelected()
	{
		int index = tab.indexOfTabComponent(this);
		int selectedIndex = tab.getSelectedIndex();
		return selectedIndex == index;
	}

	public void setTitle(String title)
	{
		lbTitle.setText(title);
	}

	public void updateSelection(boolean selected)
	{
		if (selected)
			lbTitle.setForeground(selectedTitleColor);
		else
			lbTitle.setForeground(unselectedTitleColor);
		btnClose.setVisible(selected);
	}

	private void closeTab()
	{
		int index = tab.indexOfTabComponent(this);
		tab.removeTabAt(index);
		if(tab.getTabCount()==0)
			tab.setVisible(false);
	}

	/**
	 * @param oId the oId to set
	 */
	public void setOId(String oId)
	{
		this.oId = oId;
	}

	/**
	 * @return the oId
	 */
	public String getOId()
	{
		return oId;
	}
}
