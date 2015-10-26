package client;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.ordersInputView;
import blimpl.listbl.ordersInputBL;
import blservice.listblservice.ordersInputBLService;



public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame mFrame = new JFrame();
		mFrame.setSize(800, 600);
		mFrame.setLocation(300, 300);
		
		    ordersInputBLService bl = new ordersInputBL();
		    JPanel panel = new ordersInputView(bl);
     		mFrame.getContentPane().add(panel);
     		mFrame.setVisible(true);
	}

}