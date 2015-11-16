package mockobject;

import po.WarePO;
import module.trans.Ware;

public class MockWare extends Ware {
	private WarePO po;
	public MockWare(WarePO po)
	{
		this.po=po;
	}

	public double getCost()
	{
		return 0;
	}

	public String getTime()
	{
		return null;
		
	}

}
