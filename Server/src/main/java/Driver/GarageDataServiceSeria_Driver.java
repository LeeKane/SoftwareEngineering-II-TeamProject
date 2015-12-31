package Driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.GarageDataSeriaServiceImpl;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.Garage;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;

public class GarageDataServiceSeria_Driver implements Serializable {
	public void drive(GarageDataSeriaService service)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		garageitem item = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 123457);
		garageitem item2 = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 1234527);
		garageitem item3 = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 4646);
		garageitem item4 = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 55555);
		GaragePlacePO place = new GaragePlacePO(1, 1, 1, 2);
		String address = "TxtData/1210_plane.txt";
		String address2 = "TxtData/1250.txt";
		String address3 = "TxtData/1250_motor.txt";
		String address4 = "TxtData/1250_train.txt";
		for(int i=0;i<29;i++)
		service.insert(address, item4);
		// try {
		// File f5 = new File("TxtData/warein.txt");
		// FileWriter fw5 = new FileWriter(f5);
		// BufferedWriter bw1 = new BufferedWriter(fw5);
		// bw1.write("");
		// } catch (Exception e) {
		//
		// }
		// try {
		// File f5 = new File("TxtData/wareout.txt");
		// FileWriter fw5 = new FileWriter(f5);
		// BufferedWriter bw1 = new BufferedWriter(fw5);
		// bw1.write("");
		// } catch (Exception e) {
		//
		// }

		

		

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		GarageDataSeriaService service = new GarageDataSeriaServiceImpl();
		GarageDataServiceSeria_Driver driver = new GarageDataServiceSeria_Driver();
		driver.drive(service);
	}

}
