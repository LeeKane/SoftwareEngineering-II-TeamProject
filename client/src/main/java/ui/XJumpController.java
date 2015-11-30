package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import bl.list.ArrivaListBL;
import bl.list.DeliveryListBL;
import bl.list.OrdersInputBL;
import blservice.listblservice.OrdersInputBLService;
import blservice.listblservice.arrivaList_HallBLService;
import blservice.listblservice.delivery_HallBLService;
import ui.page.AcceptView;
import ui.page.OrdersInputView;
import ui.page.ReceiveInputView;
import ui.page.deliveryview_Hall;
import ui.page.reciveview_Hall;
import ui.tab.XTabPage;
import util.Permission;

public class XJumpController {
    private OrdersInputBLService bl = new OrdersInputBL();
    private arrivaList_HallBLService abl=new ArrivaListBL();
    private delivery_HallBLService dbl=new DeliveryListBL();

	public List<XTabPage> getPageList(String command){
		List<XTabPage> pageList=new ArrayList<XTabPage>();
		
		switch (command){
		case "Chart1":
			pageList.add(createPage(new OrdersInputView(bl)));
			break;
		case "Chart2":
			pageList.add(createPage(new ReceiveInputView()));
			pageList.add(createPage(new reciveview_Hall(abl)));
			pageList.add(createPage(new deliveryview_Hall(dbl)));
			break;
		case "Chart3":
			pageList.add(createPage(new AcceptView()));
			break;
		}		
		
		return pageList;		
	}
	
	private XTabPage createPage(JComponent pageContent)
	{
		XTabPage page = new XTabPage(pageContent);
		return page;
	}
	
	public String getoutlookPanelXML(){

		return "ui/outlook.xml";		
	}
}
