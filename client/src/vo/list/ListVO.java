package vo.list;

import util.ListType;

public class ListVO {
	private ListType listType;//单据类型
	private long id;//单据id
	
	public ListVO(ListType listType, long id) {
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

}
