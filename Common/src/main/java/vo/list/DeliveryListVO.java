package vo.list;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;

public class DeliveryListVO extends Vector<String> implements Serializable {
	private TimePO time;// daodariqi
	private long code;// tiaoxingma
	private String name;// xingming

	public DeliveryListVO(TimePO time, long code, String name) {

		this.add(time.toString());
		this.add(code + "");
		this.add(name);
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
