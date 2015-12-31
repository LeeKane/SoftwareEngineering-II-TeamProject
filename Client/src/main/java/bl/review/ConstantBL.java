package bl.review;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.reviewblservice.ConstantBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.reviewdataservice.ConstantDataService;
import po.AccountPO;
import po.ConstantPO;
import vo.ConstantVO;

public class ConstantBL implements ConstantBLService{
	private DataFactoryService dataFactory;
	private ConstantDataService cd;
	private ArrayList<ConstantVO> voList;
	private AccountPO po;

	public ConstantBL(AccountPO po){
		this.po=po;
		dataFactory=new DataFactory(); 
		cd=dataFactory.getConstant();
	}


	@Override
	public ArrayList<ConstantVO> findAllPriceConstant() {
		// TODO Auto-generated method stub
		voList=new ArrayList<ConstantVO>();
		ArrayList<ConstantPO> poList=new ArrayList<ConstantPO>();
		try {
			poList=cd.findAllPrice();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addPriceConstant(ArrayList<ConstantVO> list) {
		// TODO Auto-generated method stub
		
	}

}
