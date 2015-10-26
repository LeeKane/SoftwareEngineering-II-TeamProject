package dataservice.datafactoryservice;

import java.rmi.RemoteException;

import dataservice.listdataservice.OrdersDataService;

public class DataFactoryService_Driver {
	public void drive(DataFactoryService dataFactoryService) throws RemoteException {
		OrdersDataService ordersDataService=dataFactoryService.getWareData();
		System.out.println(ordersDataService.toString());
	}
	
	public static void main(String[] args) throws RemoteException {
		DataFactoryService dataFactoryService=new DataFactoryService_Stub();
		DataFactoryService_Driver driver=new DataFactoryService_Driver();
		driver.drive(dataFactoryService);
	}
}
