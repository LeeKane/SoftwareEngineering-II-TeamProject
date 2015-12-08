package vo.list;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;
import util.ListState;

public class ReceiveCourierListVO extends Vector<String> implements Serializable{
	private TimePO time;//收件日期（时间）
	private long id;//收件编号
	private String name;//收件人姓名
	private String cellphoneNum;//收件人手机
	private ListState state;//审批状态
	
	public ReceiveCourierListVO(TimePO time, long id, String name, String cellphoneNum, ListState state) {
		this.time = time;
		this.id = id;
		this.name = name;
		this.cellphoneNum = cellphoneNum;
		this.state=state;
	
		this.add(id+"");
		this.add(name);
		this.add(cellphoneNum);
		this.add(time.toNormalString());
	}

	public TimePO getTime() {
		return time;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCellphoneNum() {
		return cellphoneNum;
	}

	public ListState getState() {
		return state;
	}
}
