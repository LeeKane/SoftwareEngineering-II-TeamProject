package dataimpl.datafactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.accountdataservice.AccountDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ArrivalListDataService;
import dataservice.listdataservice.DeliveryListDataService;
import dataservice.listdataservice.OrderListDataService;
import dataservice.listdataservice.ReceiveCourierListDataService;
import dataservice.listdataservice.TransCenterArrivalListDataService;
import dataservice.logindataservice.LoginDataService;



public class DataFactory implements DataFactoryService{

	@Override
	public OrderListDataService getWareData() {
		// TODO Auto-generated method stub
		OrderListDataService od = new OrderListDataServiceImpl();  
		return od;
	}

	@Override
	public ArrivalListDataService getArrivalData() {
		// TODO Auto-generated method stub
		ArrivalListDataService od = new ArrivalListImpl();  
		return od;
	}
	
	@Override
	public AccountDataService getAccountData(){
		AccountDataService od=new AccountDataServiceTxtImpl();
		return od;
		}
	
	@Override
	public DeliveryListDataService getDeliveryData(){
		DeliveryListDataService od=new DeliveryListDataServiceTxtImpl();
		return od;
	}
	
	@Override
	public ReceiveCourierListDataService getReceiveCourierData(){
		ReceiveCourierListDataService rld=new ReceiveCourierListImpl();
		return rld;
	}
	
	@Override
	public TransCenterArrivalListDataService getTransCenterArrivalListData(){
		TransCenterArrivalListDataService td=new TransCenterArrivalListDataServiceTxtImpl();
		return td;
	}
	
	@Override
	public InquireDataService getInquireData(){
		InquireDataService id=null;
		try {
			id = (InquireDataService)Naming.lookup("rmi://127.0.0.1:6600/InquireDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	@Override
	public LoginDataService getLoginData(){
		LoginDataService ld=null;
		try {
			ld = (LoginDataService)Naming.lookup("rmi://127.0.0.1:6600/LoginDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

}
