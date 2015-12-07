package vo.list;

import java.util.Vector;

import po.TimePO;
import util.ListState;
import util.ListType;

public class ListVO extends Vector<String>{
	private ListType listType;//单据类型
	private long id;//单据id
	private ListState lst;//单据状态


	private TimePO time;//提交时间
	public ListVO(ListType listType, long id,ListState lst,TimePO time) {
		super();
		this.add(listType.toString());
		this.add(id+"");
		this.add(lst.toString());
		this.add(time.toString());
		this.listType = listType;
		this.id = id;
		this.lst=lst;
		this.time=time;
	}

	public ListType getListType() {
		return listType;
	}

	public void setListType(ListType listType) {
		this.listType = listType;
	}
	public ListState getLst() {
		return lst;
	}

	public void setLst(ListState lst) {
		this.lst = lst;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
