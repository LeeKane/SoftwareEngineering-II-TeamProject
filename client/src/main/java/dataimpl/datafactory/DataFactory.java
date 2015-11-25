package dataimpl.datafactory;

import DataServiceTxtFileImpl.ArrivalListImpl;
import DataServiceTxtFileImpl.OrderListDataServiceImpl;

import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ArrivalListDataService;
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

}
