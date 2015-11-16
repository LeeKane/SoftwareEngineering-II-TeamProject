package mockobject;

import po.CarPO;

import bltrans.trans.Car;

public class MockCar extends Car{
	public CarPO po;
	public MockCar(CarPO po)
	{
		this.po=po;
	}
	
}
