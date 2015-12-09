package vo;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;
import util.ListType;
import util.ResultMessage;

public class StatisticalchartVO extends Vector<String> implements Serializable {
	ListType listType;
	ResultMessage resultMessage;
	TimePO time;
	private boolean managementchart;

	public StatisticalchartVO(ListType listType, ResultMessage resultMessage, TimePO time, boolean managementchart) {
		super();
		this.listType = listType;
		this.resultMessage = resultMessage;
		this.time = time;
		this.managementchart = managementchart;
		this.add(listType.toString());
		this.add(resultMessage.toString());
		this.add(time.toString());
		this.add(managementchart + "");
	}

	public ListType getListType() {
		return listType;
	}

	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	public TimePO getTime() {
		return time;
	}

	public boolean isManagementchart() {
		return managementchart;
	}

}
