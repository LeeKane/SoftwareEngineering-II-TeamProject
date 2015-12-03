package po.list;

import po.TimePO;
import util.ListState;

public class ReceiveCourierListPO {
	private TimePO time;//收件日期（时间）
	private long id;//收件编号
	private String name;//收件人姓名
	private String cellphoneNum;//收件人手机
	private ListState state;//审批状态
		
	public ReceiveCourierListPO(TimePO time, long id, String name, String cellphoneNum, ListState state) {
		super();
		this.time = time;
		this.id = id;
		this.name = name;
		this.cellphoneNum = cellphoneNum;
		this.state = state;
	}
	
	public TimePO getTime() {
		return time;
	}
	public void setTime(TimePO time) {
		this.time = time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellphoneNum() {
		return cellphoneNum;
	}
	public void setCellphoneNum(String cellphoneNum) {
		this.cellphoneNum = cellphoneNum;
	}
	public ListState getState() {
		return state;
	}
	public void setState(ListState state) {
		this.state = state;
	}
}
