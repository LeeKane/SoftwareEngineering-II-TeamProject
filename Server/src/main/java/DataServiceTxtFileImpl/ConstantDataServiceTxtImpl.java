package DataServiceTxtFileImpl;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.reviewdataservice.ConstantDataService;
import po.ConstantPO;

public class ConstantDataServiceTxtImpl extends UnicastRemoteObject implements ConstantDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected ConstantDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ConstantPO> findAllPrice() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAllPrice(ArrayList<ConstantPO> list) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		
	}

}
