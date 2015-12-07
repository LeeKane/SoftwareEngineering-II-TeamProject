package dataservice.listdataservice;

import java.io.IOException;
import java.util.ArrayList;

import po.AccountPO;
import po.list.MoneyInListPO;
import vo.InstituteVO;

public interface MoneyInListDataService {	
	public void init();
	public boolean MoneyInUpdate (ArrayList<MoneyInListPO> po) throws IOException ;
	public ArrayList<MoneyInListPO> findAll(AccountPO po) throws IOException;
	public ArrayList<String> delete() throws IOException;
	public void insert(ArrayList<MoneyInListPO> po);
	public void update(ArrayList<MoneyInListPO> po);
	public ArrayList<AccountPO> findAllCourier(AccountPO po) throws IOException;
	public String delete(ArrayList<MoneyInListPO> po) throws IOException;
}
