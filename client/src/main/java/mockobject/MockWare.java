package mockobject;

import bl.trans.Ware;
import po.TimePO;
import po.WarePO;

public class MockWare extends Ware {
	public WarePO po;
	public MockWare(WarePO po)
	{
		this.po=po;
	}

	public double getCost()
	{
		return po.getcost();
	}

	public TimePO getTime()
	{
		return po.gettime();
		
	}

}
