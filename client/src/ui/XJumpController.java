package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import bl.account.AccountManger;
import bl.list.ArrivaListBL;
import bl.list.DeliveryListBL;
import bl.list.MoneyInListBL;
import bl.list.OrdersInputBL;
import bl.list.ReceiveCourierListBL;
import bl.review.InstituteManager;
import bl.review.StaffManager;
import bl.trans.LoadingList;
import bl.trans.TransCenterArriveBL;
import blservice.accountblservice.AccountBLService;
import blservice.listblservice.MoneyInListBLService;
import blservice.listblservice.OrdersInputBLService;
import blservice.listblservice.ReceiveCourierListBLService;
import blservice.listblservice.arrivaList_HallBLService;
import blservice.listblservice.delivery_HallBLService;
import blservice.reviewblservice.InstituteBLService;
import blservice.reviewblservice.StaffBLService;
import blservice.transblservice.LoadingListBLService;
import blservice.transblservice.TransCenterArriveBLService;
import po.AccountPO;
import ui.page.AcceptView;
import ui.page.CarView;
import ui.page.Chart1View;
import ui.page.Chart2View;
import ui.page.InquireView;
import ui.page.InstituteManageView;
import ui.page.ListReviewView;
import ui.page.LoadingListInputView;
import ui.page.LoadingListInputView_Hall;
import ui.page.LoginAcocuntMangerView;
import ui.page.MoneyInView_Hall;
import ui.page.OrdersInputView;
import ui.page.ReceiveInputView;
import ui.page.StaffManageView;
import ui.page.deliveryview_Hall;
import ui.page.reciveview_Hall;
import ui.tab.XTabPage;
import util.Permission;

public class XJumpController {
	private OrdersInputBLService obl;
    private arrivaList_HallBLService abl;
    private delivery_HallBLService dbl;
    private LoadingListBLService lbl;
    private AccountBLService accountBl;
    private InstituteBLService ibl;
    private ReceiveCourierListBLService rcBL;
    private MoneyInListBLService mibl;
	private TransCenterArriveBLService tbl;
	private StaffBLService sbl;
    
    public XJumpController(AccountPO po){
    	obl = new OrdersInputBL(po);
    	abl=new ArrivaListBL();
    	dbl=new DeliveryListBL();
    	lbl=new LoadingList();
    	accountBl=new AccountManger();
    	ibl=new InstituteManager();
    	rcBL=new ReceiveCourierListBL();
    	mibl=new MoneyInListBL(po);
    	tbl=new TransCenterArriveBL(po);
    	sbl=new StaffManager(po);
    }
    
	public List<XTabPage> getPageList(String command){
		List<XTabPage> pageList=new ArrayList<XTabPage>();
		
		switch (command){
		case "Chart1":
		   
			pageList.add(createPage(new OrdersInputView(obl)));
			pageList.add(createPage(new InstituteManageView(ibl)));
			pageList.add(createPage(new StaffManageView(sbl)));
			pageList.add(createPage(new CarView()));
			//pageList.add(createPage(new ListReviewView()));
			pageList.add(createPage(new MoneyInView_Hall(mibl)));
			pageList.add(createPage(new InquireView()));
			//pageList.add(createPage(new DriverView()));
			break;
		case "Chart2":
			pageList.add(createPage(new ReceiveInputView(rcBL)));
			pageList.add(createPage(new reciveview_Hall(abl)));
			pageList.add(createPage(new deliveryview_Hall(dbl)));
			pageList.add(createPage(new LoadingListInputView_Hall()));
			break;
		case "Chart3":
			pageList.add(createPage(new AcceptView(tbl)));
			pageList.add(createPage(new LoadingListInputView(lbl)));
			pageList.add(createPage(new LoginAcocuntMangerView(accountBl)));
			pageList.add (createPage(new Chart1View()));
			pageList.add(createPage(new Chart2View()));
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
