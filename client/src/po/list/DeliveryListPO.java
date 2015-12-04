package po.list;

import java.io.Serializable;

import po.TimePO;
import util.ListState;

public class DeliveryListPO implements Serializable {

	private TimePO time;//daodariqi
	private long code;//tiaoxingma
    private String name;//xingming
    private long id;//单据Id
    private ListState lst;//单据状态
    
    
	
	public DeliveryListPO(long id,TimePO time, long code, String name , ListState lst) {

		super();
		this.time = time;
		this.code = code;
		this.name = name;
		this.lst = lst;
		this.id=id;
	}
	public long getId()
	{
		return id;

	}
	public TimePO getTime() {
		return time;
	}
	public void setTime(TimePO time) {
		this.time = time;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ListState getLst() {
		return lst;
	}
	public void setLst(ListState lst) {
		this.lst = lst;
	}
	
	
}
