package dataservice.reviewdataservice;
import java.rmi.RemoteException;

import po.*;
import util.*;
public class Reviewdataservice_Driver {
	public void driver(ReviewDataService service) throws RemoteException{
		StaffPO staff=new StaffPO(123456,"JOHN",OrgType.HALL,Permission.MANAGER);
		InstitutePO institute=new InstitutePO(City.BEIJING,OrgType.HALL,12345);
		ReviewPO po=new ReviewPO(staff,  institute);
	    long m=12345;
	 
	    service.delete(po);
	 
	 
	    service.finish();
	}
	public static void main(String[] args) throws RemoteException {
		ReviewDataService service=new Reviewdataservice_Stub();
		Reviewdataservice_Driver driver=new Reviewdataservice_Driver();
		driver.driver(service);
	}
	
}
