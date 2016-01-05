package bl.review;

import java.rmi.RemoteException;

import blservice.reviewblservice.ManagerSetRewardBLService;
import data.datafactory.DataFactory;
import dataservice.reviewdataservice.SetRewardDataService;
import po.AccountPO;

public class ManagerSetRewardBL implements ManagerSetRewardBLService {
	private SetRewardDataService isd;
	private double[] s;
	private AccountPO po;

	@Override
	public AccountPO getPo() {
		return po;
	}

	public ManagerSetRewardBL(AccountPO po) {
		this.po = po;
	}

	@Override
	public double[] find() {
		// TODO Auto-generated method stub
		isd = DataFactory.getSetRewardData();
		try {
			s = isd.findall();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void updata(double[] s) {
		// TODO Auto-generated method stub
		isd = DataFactory.getSetRewardData();
		try {
			isd.Set(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
