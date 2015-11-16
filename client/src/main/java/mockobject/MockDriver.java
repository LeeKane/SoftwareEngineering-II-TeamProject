package mockobject;

import po.DriverPO;
import bl.trans.Driver;

public class MockDriver extends Driver {
  public DriverPO po;
  public long id;
  public MockDriver (DriverPO po,long id)
  {
	  this.po=po;
	  this.id=id;
	  
  }
}
