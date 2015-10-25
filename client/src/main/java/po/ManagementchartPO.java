package po;
import java.io.Serializable;
import util.*;
public class ManagementchartPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//日期
	ListType listType;
	/**
	 * 
	 * @param  listType 如收款单
	 *@param 日期
	 * 
	 */
	public ManagementchartPO(ListType listType){
		this.listType=listType;
		
	}
	public ListType getListType() {
		return listType;
	}
	public void setListType(ListType listType) {
		this.listType = listType;
	}


}
