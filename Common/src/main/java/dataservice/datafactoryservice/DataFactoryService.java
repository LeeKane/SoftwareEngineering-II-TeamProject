package dataservice.datafactoryservice;
import java.rmi.Remote;

import dataservice.CarDataService.CarDataService;
import dataservice.DriverDataService.DriverDataService;
import dataservice.ListStateDataService.ListStateDataService;
import dataservice.StaffDataService.StaffDataService;
import dataservice.accountdataservice.AccountDataService;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ArrivalListDataService;
import dataservice.listdataservice.DeliveryListDataService;
import dataservice.listdataservice.LoadingListDataService;
import dataservice.listdataservice.LoadingList_HallDataService;
import dataservice.listdataservice.MoneyInListDataService;
import dataservice.listdataservice.OrderListDataService;
import dataservice.listdataservice.ReceiveCourierListDataService;
import dataservice.listdataservice.TransCenterArrivalListDataService;
import dataservice.logindataservice.LoginDataService;
import dataservice.reviewdataservice.InstituteDataService;

public interface DataFactoryService extends Remote{
	

	//得到货物数据
	public 	OrderListDataService getWareData();

	public AccountDataService getAccountData();

	public ArrivalListDataService getArrivalData();

	public DeliveryListDataService getDeliveryData();

	public ReceiveCourierListDataService getReceiveCourierData();

	public TransCenterArrivalListDataService getTransCenterArrivalListData();

	public InquireDataService getInquireData();

	public LoginDataService getLoginData();
	
	public StaffDataService getStaffData();
	
	public MoneyInListDataService getMoneyInListData();
	
	public CarDataService getCarData();
	
	public DriverDataService getDriverData();
	
	public InstituteDataService getInstituteData();
	
	public ListStateDataService getListStateData();
	
	public LoadingList_HallDataService getLoadingList_HallData();
	
	public LoadingListDataService getLoadingListData();
	
}
