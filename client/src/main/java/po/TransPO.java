//历史记录
package po;

import util.TransState;

public class TransPO {
	private long id;
	private TransState statement;
	private TimePO time;//时间
	private InstitutePO institute;//节点
	
	public TransPO(long id, TransState statement, TimePO time, InstitutePO institute) {
		super();
		this.id = id;
		this.statement = statement;
		this.time = time;
		this.institute = institute;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TransState getStatement() {
		return statement;
	}

	public void setStatement(TransState statement) {
		this.statement = statement;
	}

	public TimePO getTime() {
		return time;
	}

	public void setTime(TimePO time) {
		this.time = time;
	}

	public InstitutePO getInstitute() {
		return institute;
	}

	public void setInstitute(InstitutePO institute) {
		this.institute = institute;
	}	
}
