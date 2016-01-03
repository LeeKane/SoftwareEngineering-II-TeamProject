package bl.warehouse;

import java.io.FileNotFoundException;
import java.io.IOException;

import blservice.warehouseblservice.WareInBLservice;
import po.TimePO;
import util.City;
import vo.WareInInputVO;

public class WareInBLservice_Driver {
	public void driver(WareInBLservice service) throws FileNotFoundException, IOException, ClassNotFoundException {
		TimePO time = new TimePO(2015, 12, 14, 11, 12, 22);
		WareInInputVO vo1 = new WareInInputVO(12345, City.BEIJING, time);

		service.submitWareIn();
		for (int i = 0; i < service.getWareInList().size(); i++) {
			service.getWareInList().get(i).getPlace().showplace();
		}

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//// WareInBLservice service=new WareInBLserviceImpl();
		// WareInBLservice_Driver driver=new WareInBLservice_Driver();
		// driver.driver(service);
	}

}
