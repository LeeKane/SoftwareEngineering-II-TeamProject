package po.list;

import java.io.Serializable;

import po.TimePO;

public class DeliveryListPO implements Serializable {

	private TimePO time;//daodariqi
	private long code;//tiaoxingma
    private String name;//xingming
    
    
	public DeliveryListPO(TimePO time, long code, String name) {
		super();
		this.time = time;
		this.code = code;
		this.name = name;
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
	
	
	
	
}
