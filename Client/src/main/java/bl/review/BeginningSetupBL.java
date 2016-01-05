package bl.review;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import blservice.reviewblservice.BeginningSetupBLService;
import data.datafactory.DataFactory;
import dataservice.reviewdataservice.BeginningSetupDataService;
import po.AccountPO;
import po.SetupPO;
import po.TimePO;
import vo.SetupVO;

public class BeginningSetupBL implements BeginningSetupBLService {
	private BeginningSetupDataService bsd = DataFactory.getBeginningSetupData();
	private ArrayList<SetupVO> voList;
	private AccountPO po;

	public BeginningSetupBL(AccountPO po) {
		super();
		this.po = po;
	}

	@Override
	public AccountPO getPo() {
		return po;
	}

	@Override
	public void swapDefault(SetupVO vo1, SetupVO vo2) {
		// TODO Auto-generated method stub
		SetupPO po1 = new SetupPO(vo1.getSetTime(), vo1.getName(), vo1.getRemark(), vo1.getIsSelected());
		SetupPO po2 = new SetupPO(vo2.getSetTime(), vo2.getName(), vo2.getRemark(), vo2.getIsSelected());
		try {
			bsd.swap(po1, po2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean setupUpdate(ArrayList<SetupVO> voList) {
		// TODO Auto-generated method stub
		try {
			bsd.init();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (SetupVO vo : voList) {
			SetupPO po = new SetupPO(vo.getSetTime(), vo.getName(), vo.getRemark(), vo.getIsSelected());
			try {
				bsd.insert(po);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public Iterator<SetupVO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<SetupPO> polist = null;
		try {
			polist = bsd.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		voList = new ArrayList<SetupVO>();

		for (SetupPO po : polist) {
			SetupVO vo = new SetupVO(po.getSetTime(), po.getName(), po.getRemark(), po.getIsSelected());
			voList.add(vo);
		}

		return voList.iterator();
	}

	@Override
	public boolean deleteSetup(String time) {
		// TODO Auto-generated method stub
		try {
			bsd.delete(time);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public SetupVO addSetup(TimePO timePO, String name, String remark, boolean isSelected) {
		// TODO Auto-generated method stub
		return null;
	}

}
