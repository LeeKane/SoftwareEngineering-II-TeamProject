//历史记录
package po;

public class TransPO {
	private long id;
	private String statement;
	private TimePO time;//时间
	private InstitutePO institute;//节点
	
	public TransPO(long id, String statement, TimePO time, InstitutePO institute) {
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

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
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
