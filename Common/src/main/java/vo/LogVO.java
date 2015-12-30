package vo;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;

public class LogVO extends Vector<String> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TimePO time;
	private String operation;
	
	public LogVO(TimePO time, String operation) {
		super();
		this.time = time;
		this.operation = operation;
		
		this.add(time.toString());
		this.add(operation);
	}

	public TimePO getTime() {
		return time;
	}

	public String getOperation() {
		return operation;
	}

}
