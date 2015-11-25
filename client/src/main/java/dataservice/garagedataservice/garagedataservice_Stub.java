package dataservice.garagedataservice;

import po.GaragePO;
import po.garageware;

public class garagedataservice_Stub implements garagedataservice {

	@Override
	public GaragePO creat(GaragePO po) {
		// TODO Auto-generated method stub
		System.out.println("creat success");
		return null;
	}

	@Override
	public void insert(garageware po) {
		// TODO Auto-generated method stub
		System.out.println("insert success");
	}

	@Override
	public void delete(garageware po) {
		// TODO Auto-generated method stub
		System.out.println("delete success");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("inits success");
	}

	@Override
	public void showGarage() {
		// TODO Auto-generated method stub
		System.out.println("show success");
	}

}
