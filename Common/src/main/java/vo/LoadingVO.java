package vo;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;
import util.City;
import util.ListType;

public class LoadingVO  extends Vector<String> implements Serializable{

	private long waybillNum;//本装运货物的托运单号
	private double freight;//运费
	private TimePO loadDate;//装车日期
	private long transNum;//本营业厅汽运编号
	private City departPlace;//出发地
	private City destination;//到达地
	private String loadMonitor;//监装员
	private String loadPerformer;//押运员
	public LoadingVO( TimePO loadDate,
			long transNum, City departPlace, City destination,
			long waybillNum, String loadMonitor, String loadPerformer,
			double freight) {
		super();
		this.waybillNum= waybillNum;
		this.freight = freight;

		this.loadDate = loadDate;
		this.transNum = transNum;
		this.departPlace = departPlace;
		this.destination = destination;
	
		this.loadMonitor = loadMonitor;
		this.loadPerformer = loadPerformer;
	

		this.add(loadDate.toString());
		this.add(transNum+"");
		this.add(departPlace.toString());
		this.add(destination.toString());
		this.add(waybillNum+"");
		this.add(loadMonitor);
		this.add(loadPerformer);
		this.add(freight+"");
	}

	public TimePO getLoadDate() {
		return loadDate;
	}
	public long getTransNum() {
		return transNum;
	}
	public City getDepartPlace() {
		return departPlace;
	}
	public City getDestination() {
		return destination;
	}
	public long getWaybillNum() {
		return waybillNum;
	}
	public String getLoadMonitor() {
		return loadMonitor;
	}
	public String getLoadPerformer() {
		return loadPerformer;
	}
	public double getFreight() {
		return freight;
	}
	
	
}
