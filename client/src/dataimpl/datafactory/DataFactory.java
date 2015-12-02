package dataimpl.datafactory;

import DataServiceTxtFileImpl.AccountDataServiceTxtImpl;
import DataServiceTxtFileImpl.ArrivalListImpl;
import DataServiceTxtFileImpl.DeliveryListDataServiceTxtImpl;
import DataServiceTxtFileImpl.OrderListDataServiceImpl;
import dataservice.accountdataservice.AccountDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ArrivalListDataService;
import dataservice.listdataservice.DeliveryListDataService;
import dataservice.listdataservice.OrderListDataService;



public class DataFactory implements DataFactoryService{

	@Override
	public OrderListDataService getWareData() {
		// TODO Auto-generated method stub
		OrderListDataService od = new OrderListDataServiceImpl();  
		return od;
	}

	
	public ArrivalListDataService getArrivalData() {
		// TODO Auto-generated method stub
		ArrivalListDataService od = new ArrivalListImpl();  
		return od;
	}
	
	public AccountDataService getAccountData(){
		AccountDataService od=new AccountDataServiceTxtImpl();
		return od;
		}
	
	public DeliveryListDataService getDeliveryData(){
		DeliveryListDataService od=new DeliveryListDataServiceTxtImpl();
		return od;
		}
	

}
