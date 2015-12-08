package dataservice.datafactoryservice;

import java.rmi.RemoteException;

import dataservice.listdataservice.OrderListDataService;

public class DataFactoryService_Driver {
	public void drive(DataFactoryService dataFactoryService) throws RemoteException {
		OrderListDataService ordersDataService=dataFactoryService.getWareData();
		System.out.println(ordersDataService.toString());
	}
	
	public static void main(String[] args) throws RemoteException {
		DataFactoryService dataFactoryService=new DataFactoryService_Stub();
		DataFactoryService_Driver driver=new DataFactoryService_Driver();
		driver.drive(dataFactoryService);
	}
}
