package bl.list;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.listblservice.ReceiveCourierListBLService;
import data.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ReceiveCourierListDataService;
import po.AccountPO;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.list.ReceiveCourierListPO;
import ui.XTimeChooser;
import util.ListState;
import util.TransState;
import vo.list.ReceiveCourierListVO;

public class ReceiveCourierListBL implements ReceiveCourierListBLService {
	private ArrayList<ReceiveCourierListVO> ReceiveCourierListList;
	private AccountPO po;

	public ReceiveCourierListBL(AccountPO po) {
		super();
		this.po = po;
		ReceiveCourierListList = new ArrayList<ReceiveCourierListVO>();
	}

	@Override
	public AccountPO getPo() {
		return po;
	}

	public ArrayList<ReceiveCourierListVO> getReceiveCourierListList() {
		return ReceiveCourierListList;
	}

	private TransPO transState;
	private InquireDataService inquireDataService;

	public ReceiveCourierListBL() {
		ReceiveCourierListList = new ArrayList<ReceiveCourierListVO>();
	}

	@Override
	public ReceiveCourierListVO addReceiveCourierList(TimePO time, long id, String name, String cellphoneNum,
			ListState state) {
		// TODO Auto-generated method stub
		ReceiveCourierListVO rv = new ReceiveCourierListVO(time, id, name, cellphoneNum, state);
		ReceiveCourierListList.add(rv);
		return rv;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		ReceiveCourierListDataService rd = DataFactory.getReceiveCourierData();
		if (!ReceiveCourierListList.isEmpty()) {
			for (ReceiveCourierListVO rv : ReceiveCourierListList) {
				ReceiveCourierListPO rp;
				TimePO time = rv.getTime();
				long id = rv.getId();
				String name = rv.getName();
				String cellphoneNum = rv.getCellphoneNum();
				ListState state = rv.getState();
				rp = new ReceiveCourierListPO(time, id, name, cellphoneNum, state);
				try {
					rd.insert(rp);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				XTimeChooser x = XTimeChooser.getInstance();
				x.getCurrentTime();
				x.getTimePO();
				// 要改
				transState = new TransPO(id, TransState.SENDER_RECEIVE, x.getTimePO(),
						new InstitutePO(po.getStaff().getCity(), po.getStaff().getOrgType(), po.getStaff().getOrgid()));// 添加运输状态

				inquireDataService = DataFactory.getInquireData();
				try {
					inquireDataService.insert(transState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ReceiveCourierListList.clear();
			return true;
		} else
			return false;
	}

}
