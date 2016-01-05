package bl.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import blservice.reviewblservice.ConstantBLService;
import data.datafactory.DataFactory;
import dataservice.reviewdataservice.ConstantDataService;
import po.AccountPO;
import po.ConstantPO;
import vo.ConstantVO;

public class DistanceConstantBL implements ConstantBLService {
	private ConstantDataService cd;
	private ArrayList<ConstantVO> voList;
	private AccountPO po;

	public DistanceConstantBL(AccountPO po) {
		this.po = po;
		cd = DataFactory.getConstant();
	}

	@Override
	public Iterator<ConstantVO> findAll() {
		// TODO Auto-generated method stub
		voList = new ArrayList<ConstantVO>();
		ArrayList<ConstantPO> poList = new ArrayList<ConstantPO>();
		try {
			poList = cd.findAllDis();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ConstantPO po : poList) {
			ConstantVO vo = new ConstantVO(po.getName(), po.getValue());
			voList.add(vo);
		}
		return voList.iterator();
	}

	@Override
	public boolean addConstant(ArrayList<ConstantVO> list) {
		// TODO Auto-generated method stub
		try {
			cd.initDis();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (ConstantVO vo : list) {
			ConstantPO po = new ConstantPO(vo.getName(), vo.getValue());
			try {
				cd.setDis(po);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		return true;
	}

	@Override
	public AccountPO getPo() {
		// TODO Auto-generated method stub
		return po;
	}

}
