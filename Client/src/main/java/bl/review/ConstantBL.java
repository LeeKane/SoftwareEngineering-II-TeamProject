package bl.review;

import java.io.IOException;
import java.util.ArrayList;

import blservice.reviewblservice.ConstantBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.reviewdataservice.ConstantDataService;
import po.AccountPO;
import po.ConstantPO;
import vo.ConstantVO;

public class ConstantBL implements ConstantBLService {
	private DataFactoryService dataFactory;
	private ConstantDataService cd;
	private ArrayList<ConstantVO> voList;
	private AccountPO po;

	@Override
	public AccountPO getPo() {
		return po;
	}

	public ConstantBL(AccountPO po) {
		this.po = po;
		dataFactory = new DataFactory();
		cd = dataFactory.getConstant();
	}

	@Override
	public ArrayList<ConstantVO> findAllPriceConstant() {
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
		return voList;
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
	public ArrayList<ConstantVO> findAllDisConstant() {
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
		return voList;
	}
}
