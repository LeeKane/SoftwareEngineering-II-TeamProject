package po;

import java.io.Serializable;
import java.util.ArrayList;

public class LoadingPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TimePO loadDate;//装车日期
	private long transNum;//本营业厅汽运编号
	private String departPlace;//出发地
	private String destination;//到达地
	private ArrayList<?> waybillNumList;//本次装箱所有托运单号
	private String loadMonitor;//监装员
	private String loadPerformer;//押运员
	private double freight;//运费
	
	public LoadingPO(TimePO loadDate, long transNum, String departPlace, String destination, ArrayList<?> waybillNumList,
			String loadMonitor, String loadPerformer, double freight) {
		super();
		this.loadDate = loadDate;
		this.transNum = transNum;
		this.departPlace = departPlace;
		this.destination = destination;
		this.waybillNumList = waybillNumList;
		this.loadMonitor = loadMonitor;
		this.loadPerformer = loadPerformer;
		this.freight = freight;
	}

	public TimePO getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(TimePO loadDate) {
		this.loadDate = loadDate;
	}

	public long getTransNum() {
		return transNum;
	}

	public void setTransNum(long transNum) {
		this.transNum = transNum;
	}

	public String getDepartPlace() {
		return departPlace;
	}

	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public ArrayList<?> getWaybillNumList() {
		return waybillNumList;
	}

	public void setWaybillNumList(ArrayList<?> waybillNumList) {
		this.waybillNumList = waybillNumList;
	}

	public String getLoadMonitor() {
		return loadMonitor;
	}

	public void setLoadMonitor(String loadMonitor) {
		this.loadMonitor = loadMonitor;
	}

	public String getLoadPerformer() {
		return loadPerformer;
	}

	public void setLoadPerformer(String loadPerformer) {
		this.loadPerformer = loadPerformer;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}
	
}
