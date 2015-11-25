package vo.list;

import java.util.Vector;

import po.TimePO;
import util.City;
import util.GoodState;

public class ArrivaListVO extends Vector<String> {
	private static final long serialVersionUID = 1L;

	public ArrivaListVO(TimePO time, long transid, City StartCity,
			GoodState state) {
     this.add(time.toString());
     this.add(transid+"");
     this.add(StartCity.toString());
     this.add(state.toString());
	}
	
	public String getTime()
	{
		return this.get(0);
	}
	public String getId()
	{
		return this.get(1);
	}
	public String getCity()
	{
		return this.get(2);
	}
	public String getState()
	{
		return this.get(3);
	}
}
