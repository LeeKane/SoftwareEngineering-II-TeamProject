package po.list;

import util.ListType;

public class ListPO {
	private ListType listType;//单据类型
	private long id;//单据id
	
	public ListPO(ListType listType, long id) {
		super();
		this.listType = listType;
		this.id = id;
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
	
	public ListType toListType(String m){
		
		
		
		
		return listType;
		
	}
	
}
