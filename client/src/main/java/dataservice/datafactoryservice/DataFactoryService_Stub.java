package dataservice.datafactoryservice;

import dataimpl.listDataServiceTxtFileImpl.OrdersDataServiceTxtFileImpl;
import dataservice.listdataservice.OrdersDataService;

public class DataFactoryService_Stub implements DataFactoryService {

	@Override
	public OrdersDataService getWareData() {
		// TODO Auto-generated method stub
		System.out.println("GetWareData Succeeded!");
		return new OrdersDataServiceTxtFileImpl();
	}

}
