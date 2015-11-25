package dataimpl.datafactory;

import DataServiceTxtFileImpl.ArrivalListImpl;
import dataimpl.listDataServiceTxtFileImpl.OrdersDataServiceTxtFileImpl;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ArrivalListDataService;
import dataservice.listdataservice.OrderListDataService;



public class DataFactory implements DataFactoryService{

	@Override
	public OrderListDataService getWareData() {
		// TODO Auto-generated method stub
		OrderListDataService od = new OrdersDataServiceTxtFileImpl();  
		return od;
	}


}
