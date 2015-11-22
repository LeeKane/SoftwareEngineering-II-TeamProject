/**   
 * @Title: XGCButton.java
 * @Package xujun.control.statusbar
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 徐骏  
 * @date 2010-7-6 下午10:39:31
 * @version V1.0   
 */

package xujun.control.statusbar;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import xujun.control.XContorlUtil;

/**
 * @ClassName: XGCButton
 * @Description: GC按钮
 * @date 2010-7-6 下午10:39:31
 * 
 */
public class XGCButton extends JButton
{
	public XGCButton()
	{
		super();
		ImageIcon icon=XContorlUtil.getImageIcon("xujun/control/images/gc.png");
		setSize(icon.getImage().getWidth(null),
				icon.getImage().getHeight(null));
		setIcon(icon);
		//完全填充
		setMargin(new Insets(0,0,0,0));//将边框外的上下左右空间设置为0
		setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0
		setBorderPainted(false);//不打印边框
		setBorder(null);//除去边框
		setText(null);//除去按钮的默认名称
		setFocusPainted(false);//除去焦点的框
		setContentAreaFilled(false);//除去默认的背景填充
		
		setToolTipText("释放内存");
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.gc();
			}
		});
	}
	
	@Override
	public void setIcon(Icon icon)
	{
		super.setIcon(icon);
		if (icon == null)
		{
			setPressedIcon(null);
			setRolloverIcon(null);
		} else
		{
			Icon pressedIcon = XContorlUtil.createMovedIcon(icon);
			setPressedIcon(pressedIcon);
		}
	}
}
