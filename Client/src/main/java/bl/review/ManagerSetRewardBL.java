package bl.review;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.reviewblservice.ManagerSetRewardBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.reviewdataservice.SetRewardDataService;
import po.AccountPO;
import vo.InstituteVO;

public class ManagerSetRewardBL implements ManagerSetRewardBLService {
	private DataFactoryService dataFactory;
	private SetRewardDataService isd;
	private double[] s;
	private AccountPO po;
	@Override
	public AccountPO getPo() {
		return po;
	}
	public ManagerSetRewardBL(AccountPO po)
	{
		this.po=po;
	}
	@Override
	public double[] find() {
		// TODO Auto-generated method stub
		dataFactory = new DataFactory();
		isd = dataFactory.getSetRewardData();
		try {
			s=isd.findall();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void updata(double[] s) {
		// TODO Auto-generated method stub
		
		dataFactory = new DataFactory();
		isd = dataFactory.getSetRewardData();
		try {
			isd.Set(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
