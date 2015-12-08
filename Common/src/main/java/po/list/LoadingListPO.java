package po.list;

import java.io.Serializable;
import java.util.ArrayList;

import po.TimePO;
import util.City;
import util.ListState;
import util.ListType;
//装车单
public class LoadingListPO implements Serializable {
	private long id;
	private ListType type=ListType.LOADING;
	private TimePO loadDate;//装车日期
	private long transNum;//本营业厅汽运编号
	private City departPlace;//出发地
	private City destination;//到达地
	private ArrayList<Long> waybillNumList;//本次装箱所有托运单号
	private String loadMonitor;//监装员
	private String loadPerformer;//押运员
	private double freight;//运费
	private ListState lst;//单据状态

	

	public LoadingListPO(long id, ListType type, TimePO loadDate,
			long transNum, City departPlace, City destination,
			ArrayList<Long> waybillNumList, String loadMonitor, String loadPerformer,
			double freight,ListState lst) {
		super();
		this.id = id;
		this.type = type;
		this.loadDate = loadDate;
		this.transNum = transNum;
		this.departPlace = departPlace;
		this.destination = destination;
		this.waybillNumList = waybillNumList;
		this.loadMonitor = loadMonitor;
		this.loadPerformer = loadPerformer;
		this.freight = freight;
		this.lst = lst;
		
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public ListType getType() {
		return type;
	}
	public void setType(ListType type) {
		this.type = type;
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
	public City getDepartPlace() {
		return departPlace;
	}
	public void setDepartPlace(City departPlace) {
		this.departPlace = departPlace;
	}
	public City getDestination() {
		return destination;
	}
	public void setDestination(City destination) {
		this.destination = destination;
	}
	public ArrayList<Long> getWaybillNumList() {
		return waybillNumList;
	}
	public void setWaybillNumList(ArrayList<Long> waybillNumList) {
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

	public ListState getLst() {
		return lst;
	}


	public void setLst(ListState lst) {
		this.lst = lst;
	}



}
