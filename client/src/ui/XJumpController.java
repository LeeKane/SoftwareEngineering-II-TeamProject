package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import bl.account.AccountManger;
import bl.list.ArrivaListBL;
import bl.list.DeliveryListBL;
import bl.list.OrdersInputBL;
import bl.list.ReceiveCourierListBL;
import bl.trans.LoadingList;
import blservice.accountblservice.AccountBLService;
import blservice.listblservice.OrdersInputBLService;
import blservice.listblservice.ReceiveCourierListBLService;
import blservice.listblservice.arrivaList_HallBLService;
import blservice.listblservice.delivery_HallBLService;
import blservice.transblservice.LoadingListBLService;
import ui.page.AcceptView;
import ui.page.InstituteManageView;
import ui.page.LoadingListInputView;
import ui.page.LoadingListInputView_Hall;
import ui.page.LoginAcocuntMangerView;
import ui.page.OrdersInputView;
import ui.page.ReceiveInputView;
import ui.page.deliveryview_Hall;
import ui.page.reciveview_Hall;
import ui.tab.XTabPage;
import util.Permission;

public class XJumpController {
    private OrdersInputBLService obl = new OrdersInputBL();
    private arrivaList_HallBLService abl=new ArrivaListBL();
    private delivery_HallBLService dbl=new DeliveryListBL();
    private LoadingListBLService lbl=new LoadingList();
    private AccountBLService accountBl=new AccountManger();
    private ReceiveCourierListBLService rcBL=new ReceiveCourierListBL();
    
	public List<XTabPage> getPageList(String command){
		List<XTabPage> pageList=new ArrayList<XTabPage>();
		
		switch (command){
		case "Chart1":
			pageList.add(createPage(new OrdersInputView(obl)));
			pageList.add(createPage(new InstituteManageView(accountBl)));
			break;
		case "Chart2":
			pageList.add(createPage(new ReceiveInputView(rcBL)));
			pageList.add(createPage(new reciveview_Hall(abl)));
			pageList.add(createPage(new deliveryview_Hall(dbl)));
			pageList.add(createPage(new LoadingListInputView_Hall()));
			break;
		case "Chart3":
			pageList.add(createPage(new AcceptView()));
			pageList.add(createPage(new LoadingListInputView(lbl)));
			pageList.add(createPage(new LoginAcocuntMangerView(accountBl)));
			break;
		}		
		
		return pageList;		
	}
	
	private XTabPage createPage(JComponent pageContent)
	{
		XTabPage page = new XTabPage(pageContent);
		return page;
	}
	
	public String getoutlookPanelXML(Permission permission){
		switch (permission){
		case COURIER:
			return "ui/outlook_courier.xml";
		case SENDER:
			return "ui/outlook_sender.xml";
		case HALLCLERK:
			return "ui/outlook_hallclerk.xml";
		case CENTERCLERK:
			return "ui/outlook_centerclerk.xml";
		case WAREKEEPER:
			return "ui/outlook_warekeeper.xml";
		case COUNTER:
			return "ui/outlook_counter.xml";
		case MANAGER:
			return "ui/outlook_manager.xml";
		case ADMINISTRATOR:
			return "ui/outlook_administrator.xml";
		default:
			return null;
		}				
	}
}
