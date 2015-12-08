package vo;

import java.io.Serializable;
import java.util.Vector;

import po.InstitutePO;
import po.TimePO;
import util.TransState;

public class TransVO extends Vector<String> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8699574494798217939L;
	private long id;
	private TransState statement;
	private TimePO time;//时间
	private InstitutePO institute;//节点
	public TransVO(long id, TransState statement, TimePO time,
			InstitutePO institute) {
		super();
		this.id = id;
		this.statement = statement;
		this.time = time;
		this.institute = institute;
		this.add(id+"");
		this.add(time.toString());
		this.add(institute.toString());
		this.add(statement.toString());
	}
	public long getId() {
		return id;
	}
	public TransState getStatement() {
		return statement;
	}
	public TimePO getTime() {
		return time;
	}
	public InstitutePO getInstitute() {
		return institute;
	}
	
	
}
