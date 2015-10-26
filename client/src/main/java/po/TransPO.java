//历史记录
package po;

public class TransPO {
	private TimePO time;//时间
	private InstitutePO institute;//节点
	
	public TransPO(TimePO time, InstitutePO institute) {
		super();
		this.time = time;
		this.institute = institute;
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
