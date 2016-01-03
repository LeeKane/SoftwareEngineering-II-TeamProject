package bl.inquire;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.inquireblservice.InquireBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquiredataservice.InquireDataService;
import po.AccountPO;
import po.TransPO;
import vo.TransVO;

public class Inquire implements InquireBLService {
	private InquireDataService ds;
	private ArrayList<TransPO> poList;
	private ArrayList<TransVO> voList;
	private DataFactoryService dataFactory;
	private AccountPO po;

	@Override
	public AccountPO getPo() {
		return po;
	}

	public Inquire(AccountPO po) {
		super();
		this.po = po;
		dataFactory = new DataFactory();
		voList = new ArrayList<TransVO>();
		ds = dataFactory.getInquireData();
		poList = new ArrayList<TransPO>();
	}

	@Override
	public void endInquire() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<TransVO> inquire(String id) {
		// TODO Auto-generated method stub
		try {
			poList = ds.find(Long.parseLong(id));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < poList.size(); i++) {
			TransPO po = poList.get(i);
			TransVO vo = new TransVO(po.getId(), po.getStatement(), po.getTime(), po.getInstitute());
			voList.add(vo);
		}
		return voList;
	}

}
