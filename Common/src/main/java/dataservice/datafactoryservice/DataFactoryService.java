package dataservice.datafactoryservice;
import dataservice.accountdataservice.AccountDataService;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ArrivalListDataService;
import dataservice.listdataservice.DeliveryListDataService;
import dataservice.listdataservice.OrderListDataService;
import dataservice.listdataservice.ReceiveCourierListDataService;
import dataservice.listdataservice.TransCenterArrivalListDataService;
import dataservice.logindataservice.LoginDataService;

public interface DataFactoryService {
	//得到货物数据
	public 	OrderListDataService getWareData();

	public AccountDataService getAccountData();

	public ArrivalListDataService getArrivalData();

	public DeliveryListDataService getDeliveryData();

	public ReceiveCourierListDataService getReceiveCourierData();

	public TransCenterArrivalListDataService getTransCenterArrivalListData();

	public InquireDataService getInquireData();

	public LoginDataService getLoginData();
	
}
