package dataservice.reviewdataservice;
import java.rmi.RemoteException;

import po.*;
import util.*;
import dataservice.financedataservice.FinanceDataService;
import dataservice.reviewdataservice.ReviewDataService;
public class reviewdataservice_Driver {
	public void driver(ReviewDataService service) throws RemoteException{
		StaffPO staff=new StaffPO("JOHN",123456,OrgType.HALL,Permission.MANAGER);
		InstitutePO institute=new InstitutePO(City.BEIJING,OrgType.HALL,12345);
		ReviewPO po=new ReviewPO(staff,  institute);
	    long m=12345;
	    service.find(m);
	    service.insert(po);
	    service.delete(po);
	    service.update(po);
	    service.init();
	    service.finish();
	}
}
