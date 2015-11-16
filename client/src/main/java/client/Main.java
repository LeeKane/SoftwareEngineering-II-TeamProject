package client;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.OrdersInputView;
import bllist.list.OrdersInputBL;
import blservice.listblservice.OrdersInputBLService;



public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame mFrame = new JFrame();
		mFrame.setSize(800, 600);
		mFrame.setLocation(300, 300);
		
		    OrdersInputBLService bl = new OrdersInputBL();
		    JPanel panel = new OrdersInputView(bl);
     		mFrame.getContentPane().add(panel);
     		mFrame.setVisible(true);
	}

}