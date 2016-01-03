
package ui.statusbar;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;

import dataimpl.datafactory.DataFactory;
import testservice.TestService;
import ui.XContorlUtil;

public class XStatusMessageLabel extends XStatusLabel {
	private static final ImageIcon ICON_ORANGE = XContorlUtil
			.getImageIcon("ui/images/statusbar_message_light_orange.png");
	private static final ImageIcon ICON_RED = XContorlUtil.getImageIcon("ui/images/statusbar_message_light_red.png");
	private static final ImageIcon ICON_GREEN = XContorlUtil
			.getImageIcon("ui/images/statusbar_message_light_green.png");

	public XStatusMessageLabel() {
		setText("服务器已连接");

	}

	protected void init() {
		super.init();
		setFont(XContorlUtil.FONT_14_BOLD);
		setGreenLight();
		// 启动监听线程
		initMockers();
	}

	public void setRedLight() {
		setIcon(ICON_RED);
	}

	public void setGreenLight() {
		setIcon(ICON_GREEN);
	}

	public void setOrangeLight() {
		setIcon(ICON_ORANGE);
	}

	private void initMockers() {
		Thread thread = new Thread() {
			public void run() {
				do {
					try {
						TestService testService = DataFactory.getTest();
						setGreenLight();
						setText("服务器已连接");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						setRedLight();
						setText("服务器连接中断");
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						setRedLight();
						setText("服务器连接中断");
						e.printStackTrace();
					} catch (NotBoundException e) {
						// TODO Auto-generated catch block
						setRedLight();
						setText("服务器连接中断");
						e.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (true);
			}
		};
		thread.start();
	}
}
