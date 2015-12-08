package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import DataServiceTxtFileImpl.AccountDataServiceTxtImpl;
import DataServiceTxtFileImpl.ArrivalListImpl;
import DataServiceTxtFileImpl.CarDataServiceTxtImpl;
import DataServiceTxtFileImpl.DeliveryListDataServiceTxtImpl;
import DataServiceTxtFileImpl.DriverDataServiceTxtImpl;
import DataServiceTxtFileImpl.InquireDataServiceTxtImpl;
import DataServiceTxtFileImpl.InstituteDataServiceTxtImpl;
import DataServiceTxtFileImpl.ListStateDataServiceTxtlmpl;
import DataServiceTxtFileImpl.LoadingListDataServiceTxtImpl;
import DataServiceTxtFileImpl.LoadingList_HallDataServiceTxtImpl;
import DataServiceTxtFileImpl.MoneyInListDataServiceImpl;
import DataServiceTxtFileImpl.OrderListDataServiceImpl;
import DataServiceTxtFileImpl.ReceiveCourierListImpl;
import DataServiceTxtFileImpl.StaffDataServiceTxtImpl;
import DataServiceTxtFileImpl.TransCenterArrivalListDataServiceTxtImpl;
import DataServiceTxtFileImpl.logindataserviceimpl;
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

public class NetworkMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OrderListDataService orderListDataService=new OrderListDataServiceImpl();
			AccountDataService accountDataService=new AccountDataServiceTxtImpl();
			ArrivalListDataService arrivalListDataService=new ArrivalListImpl();
			DeliveryListDataService deliveryListDataService=new DeliveryListDataServiceTxtImpl();
			ReceiveCourierListDataService receiveCourierListDataService=new ReceiveCourierListImpl();
			TransCenterArrivalListDataService transCenterArrivalListDataService =new TransCenterArrivalListDataServiceTxtImpl();
			InquireDataService inquireDataService=new InquireDataServiceTxtImpl();
			LoginDataService loginDataService=new logindataserviceimpl();		
			StaffDataService staffDataService=new StaffDataServiceTxtImpl();
			MoneyInListDataService moneyInListDataService=new MoneyInListDataServiceImpl();
			CarDataService	carDataService=new CarDataServiceTxtImpl();
			DriverDataService driverDataService	=new DriverDataServiceTxtImpl();
			InstituteDataService instituteDataService=new InstituteDataServiceTxtImpl();
			ListStateDataService listStateDataService=new ListStateDataServiceTxtlmpl();		
			LoadingList_HallDataService loadingList_HallDataService=new LoadingList_HallDataServiceTxtImpl();
			LoadingListDataService loadingListDataService=new LoadingListDataServiceTxtImpl();

			LocateRegistry.createRegistry(6600);
			Naming.rebind("rmi://127.0.0.1:6600/OrderListDataService", orderListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/AccountDataService", accountDataService);
			Naming.rebind("rmi://127.0.0.1:6600/ArrivalListDataService", arrivalListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/DeliveryListDataService", deliveryListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/ReceiveCourierListDataService", receiveCourierListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/TransCenterArrivalListDataService", transCenterArrivalListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/InquireDataService", inquireDataService);
			Naming.rebind("rmi://127.0.0.1:6600/LoginDataService", loginDataService);			
			Naming.rebind("rmi://127.0.0.1:6600/StaffDataService", staffDataService);
			Naming.rebind("rmi://127.0.0.1:6600/MoneyInListDataService", moneyInListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/CarDataService", carDataService);
			Naming.rebind("rmi://127.0.0.1:6600/DriverDataService", driverDataService);
			Naming.rebind("rmi://127.0.0.1:6600/InstituteDataService", instituteDataService);
			Naming.rebind("rmi://127.0.0.1:6600/ListStateDataService", listStateDataService);
			Naming.rebind("rmi://127.0.0.1:6600/LoadingList_HallDataService", loadingList_HallDataService);
			Naming.rebind("rmi://127.0.0.1:6600/LoadingListDataService", loadingListDataService);
					
			System.out.println("Service Start!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
