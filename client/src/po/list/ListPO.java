package po.list;

import util.ListState;
import util.ListType;

public class ListPO {
	private ListType listType;//单据类型
	private long id;//单据id
	private ListState lst;//单据状态
	
	
	public ListPO(ListType listType, long id,ListState lst) {
		super();
		this.listType = listType;
		this.id = id;
		this.lst = lst;
	}

	public ListType getListType() {
		return listType;
	}

	public void setListType(ListType listType) {
		this.listType = listType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public ListState getLst() {
		return lst;
	}

	public void setLst(ListState lst) {
		this.lst = lst;
	}

	
	public ListType toListType(String m){
		return listType;
		
	}
	
}
