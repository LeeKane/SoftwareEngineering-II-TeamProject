package vo.list;

import java.util.Vector;

import po.TimePO;

public class ReceiveCourierListVO extends Vector<String>{
	private TimePO time;//收件日期（时间）
	private long id;//收件编号
	private String name;//收件人姓名
	private String cellphoneNum;//收件人手机
	
	public ReceiveCourierListVO(TimePO time, long id, String name, String cellphoneNum) {
		this.time = time;
		this.id = id;
		this.name = name;
		this.cellphoneNum = cellphoneNum;
	
		this.add(time.toString());
		this.add(id+"");
		this.add(name);
		this.add(cellphoneNum);
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
}
