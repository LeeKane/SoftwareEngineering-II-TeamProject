package mockobject;

import bl.inquire.TransHistory;
import po.InstitutePO;
import po.TimePO;

public class MockTransHistory extends TransHistory {
	long id;
	String statement;
	TimePO time;//时间
	InstitutePO institute;//节点
	
	public MockTransHistory(long id, String statement, TimePO time, InstitutePO institute) {
		super();
		this.id = id;
		this.statement = statement;
		this.time = time;
		this.institute = institute;
	}
}
