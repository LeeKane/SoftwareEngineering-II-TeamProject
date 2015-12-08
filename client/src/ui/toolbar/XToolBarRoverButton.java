
package ui.toolbar;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import ui.XContorlUtil;


public class XToolBarRoverButton extends XToolBarButton
{
	private Color roverDyeColor;

	public XToolBarRoverButton()
	{
		roverDyeColor = new Color(86, 146, 61);
	}

	public void setIcon(Icon icon)
	{
		super.setIcon(icon);
		if (icon == null)
		{
			setPressedIcon(null);
			setRolloverIcon(null);
		} else
		{
			java.awt.Image image = XContorlUtil.iconToImage(icon);
			Icon roverIcon = XContorlUtil.createDyedIcon(new ImageIcon(image), roverDyeColor);
			Icon pressedIcon = XContorlUtil.createMovedIcon(roverIcon);
			setRolloverIcon(roverIcon);
			setPressedIcon(pressedIcon);
		}
	}
}
