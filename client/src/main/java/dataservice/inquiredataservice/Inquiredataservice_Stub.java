package dataservice.inquiredataservice;

import java.rmi.RemoteException;

import po.*;
import util.City;
import util.OrgType;

public class Inquiredataservice_Stub implements InquireDataService {
 
	TimePO time=new TimePO(1,1,1,1,1,1);
	InstitutePO institute=new InstitutePO(City.BEIJING,OrgType.HALL,123456);
	TransPO po=new TransPO(1, "已经送达", time,institute);
	
	@Override
	
	public TransPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return po;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INIT SUCCESS");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS");
	}
	
	

}
