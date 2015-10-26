package dataimpl.datafactory;

import dataimpl.listDataServiceTxtFileImpl.ordersDataServiceTxtFileImpl;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ordersDataService;



public class DataFactory implements DataFactoryService{

	@Override
	public ordersDataService getWareData() {
		// TODO Auto-generated method stub
		ordersDataService od = new ordersDataServiceTxtFileImpl();  
		return od;
	}

}
