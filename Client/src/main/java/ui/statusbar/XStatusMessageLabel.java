
package ui.statusbar;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;

import testservice.TestService;
import ui.XContorlUtil;

public class XStatusMessageLabel extends XStatusLabel
{
	private static final ImageIcon ICON_ORANGE = XContorlUtil.getImageIcon("ui/images/statusbar_message_light_orange.png");
	private static final ImageIcon ICON_RED = XContorlUtil.getImageIcon("ui/images/statusbar_message_light_red.png");
	private static final ImageIcon ICON_GREEN = XContorlUtil.getImageIcon("ui/images/statusbar_message_light_green.png");

	public XStatusMessageLabel()
	{
		setText("Server is connected");
	}

	protected void init()
	{
		super.init();
		setFont(XContorlUtil.FONT_14_BOLD);
		setGreenLight();
		//启动监听线程
		initMockers();
	}

	public void setRedLight()
	{
		setIcon(ICON_RED);
	}

	public void setGreenLight()
	{
		setIcon(ICON_GREEN);
	}

	public void setOrangeLight()
	{
		setIcon(ICON_ORANGE);
	}
	private void initMockers()
	{
		Thread thread = new Thread()
		{
			public void run()
			{
				do
				{
					try {
						TestService testService=(TestService)Naming.lookup("rmi://127.0.0.1:6600/TestService");
						setGreenLight();
						setText("Server is connected");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						setRedLight();
						setText("Server connection is broken");
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						setRedLight();
						setText("Server connection is broken");
						e.printStackTrace();
					} catch (NotBoundException e) {
						// TODO Auto-generated catch block
						setRedLight();
						setText("Server connection is broken");
						e.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				while (true);
			}
		};
		thread.start();
	}
}
