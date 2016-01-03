package po;

import java.io.Serializable;

public class LogPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TimePO time;
	private String operation;

	public LogPO(TimePO time, String operation) {
		super();
		this.time = time;
		this.operation = operation;
	}

	public TimePO getTime() {
		return time;
	}

	public void setTime(TimePO time) {
		this.time = time;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
