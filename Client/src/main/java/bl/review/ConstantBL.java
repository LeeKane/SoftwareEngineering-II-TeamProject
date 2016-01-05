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

public class ConstantBL implements ConstantBLService {
	private ConstantDataService cd;
	private ArrayList<ConstantVO> voList;
	private AccountPO po;

	@Override
	public AccountPO getPo() {
		return po;
	}

	public ConstantBL(AccountPO po) {
		this.po = po;
		cd = DataFactory.getConstant();
	}

	@Override
	public Iterator<ConstantVO> findAllPriceConstant() {
		// TODO Auto-generated method stub
		voList = new ArrayList<ConstantVO>();
		ArrayList<ConstantPO> poList = new ArrayList<ConstantPO>();
		try {
			poList = cd.findAllPrice();
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
	public boolean addPriceConstant(ArrayList<ConstantVO> list) {
		try {
			cd.init();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (ConstantVO vo : list) {
			ConstantPO po = new ConstantPO(vo.getName(), vo.getValue());
			try {
				cd.setPrice(po);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addDisConstant(ArrayList<ConstantVO> list) {
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
	public Iterator<ConstantVO> findAllDisConstant() {
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
}
