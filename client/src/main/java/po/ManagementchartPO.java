package po;
import java.io.Serializable;
import util.*;
public class ManagementchartPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TimePO time;

	ListType listType;
	/**
	 * 
	 * @param  listType 如收款单
	 *@param 日期
	 * 
	 */
	public ManagementchartPO(ListType listType,TimePO time){
		this.listType=listType;
		this.time=time;
		
	}
	public ListType getListType() {
		return listType;
	}
	public void setListType(ListType listType) {
		this.listType = listType;
	}
	public TimePO getTime() {
		return time;
	}
	public void setTime(TimePO time) {
		this.time = time;
	}


}
