package dataservice.Transdataservice;

public interface Transdataservice {
	public double getCost(warePO po);

	public double getTime(warePO po);
	public double addCar(carPO po);
	public double deleteCar(long id);
	public double getCar(long id);
	public double getDriver(long id);
	public double addDriver(driverPO po,long id);
	public doubledeleteDriver(long id);
	public double addLoading(loadingPO po);
	public double getIncome(double income，long id);

}
