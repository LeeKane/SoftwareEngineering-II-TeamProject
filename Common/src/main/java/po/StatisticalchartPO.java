package po;
import java.io.Serializable;
import util.*;

public class StatisticalchartPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ListType listType;
	ResultMessage resultMessage;
	TimePO time;
	private boolean managementchart;
	
	/**
	 * @param 日期 time
	 * @param ListType 入款单，收款单
	 * @param managementchart 是否生成经营情况表
	 * 
	 */
	public StatisticalchartPO (boolean managementchart,ListType ListType,ResultMessage resultMessage,TimePO time){
		this.managementchart=managementchart;
		this.listType=ListType;
		this.resultMessage=resultMessage;
		this.time=time;
	}
	public boolean isManagementchart() {
		return managementchart;
	}
	public void setManagementchart(boolean managementchart) {
		this.managementchart = managementchart;
	}public ListType getListType() {
		return listType;
	}
	public void setListType(ListType listType) {
		this.listType = listType;
	}
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
	public TimePO getTime() {
		return time;
	}
	public void setTime(TimePO time) {
		this.time = time;
	}
	
}
