package bl.finance;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.financeblservice.FinanceMOBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.MoneyOutListDataService;
import po.AccountPO;
import po.BaccountPO;
import po.TimePO;
import po.list.MoneyOutListPO;
import util.Entry;
import util.ListState;
import vo.list.MoneyOutListVO;

public class FinanceMOBL implements FinanceMOBLService{
	private AccountPO po;
	private DataFactoryService dataFactory;
	private ArrayList<MoneyOutListVO> moneyOutListList;
	private String preFour;
	private String lastFour;
	private long Listid;
	private boolean result=false;
	private int count;
	public FinanceMOBL(AccountPO po)
	{
		this.po=po;
		count=0;
		dataFactory = new DataFactory();
		moneyOutListList =new ArrayList<MoneyOutListVO>();
	}
	@Override
	public MoneyOutListVO addMOList(long id, TimePO time, double money, String name, BaccountPO account, Entry entry,
			String note, ListState lst) {
		// TODO Auto-generated method stub
		id+=count;
		MoneyOutListVO moneyOutList=new MoneyOutListVO(id,time,money,name,account,entry,note,lst);
		moneyOutListList.add(moneyOutList);
		count++;
		return moneyOutList;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		MoneyOutListDataService od=dataFactory.getMoneyOutListData();
		if(!moneyOutListList.isEmpty())
		{
			for (int i = 0; i < moneyOutListList.size(); i++) 
			{
				MoneyOutListVO vo=moneyOutListList.get(i);
				MoneyOutListPO po=new MoneyOutListPO(vo.getId(),vo.getTime(),vo.getMoney(),vo.getName(),vo.getAccount(),vo.getEntry(),vo.getNote(),vo.getLst());
				try {
					result = od.insert(po);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
			moneyOutListList.clear();
			count=0;
			return result;
		}
		else
		return false;
	}
	@Override
	public long myGetListId(TimePO time)
	{
		MoneyOutListDataService od=dataFactory.getMoneyOutListData();
		if (time.getHour() >= 10) {
			preFour = time.getHour() + "";
		} else {
			preFour = "0" + time.getHour();
		}
		if (time.getMin() >= 10)
			preFour += (time.getMin() + "");
		else
			preFour += ("0" + time.getMin());
		try {
			lastFour = (od.findLast().getId() + 1) + "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lastFour = lastFour.substring(6);

		return Long.parseLong(preFour + "03" + lastFour);
	}
}
