package dataservice.warehousedataservice;
import java.rmi.RemoteException;
import po.*;
public class Warehousedataservice_Driver {
	public void drive(WarehouseDataService service) throws RemoteException{
		
		WareHousePO po=new WareHousePO();
	    long m=12345;
	    service.find(m);
	    service.insert(po);
	    service.delete(po);
	    service.update(po);
	    service.init();
	    service.finish();
	}
	
	public static void main(String[] args) throws RemoteException {
		WarehouseDataService service=new Warehousedataservice_Stub();
		Warehousedataservice_Driver driver=new Warehousedataservice_Driver();
		driver.drive(service);
	}
}
