package vo.list;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;
import util.City;
import util.ListType;

public class LoadingListVO extends Vector<String> implements Serializable {
	private long id;
	private ListType type = ListType.TRANS;
	private TimePO loadDate;// 装车日期
	private long transNum;// 本营业厅汽运编号
	private City departPlace;// 出发地
	private City destination;// 到达地
	private long[] waybillNumList;// 本次装箱所有托运单号
	private String loadMonitor;// 监装员
	private String loadPerformer;// 押运员
	private double freight;// 运费

	public LoadingListVO(long id, ListType type, TimePO loadDate, long transNum, City departPlace, City destination,
			long[] waybillNumList, String loadMonitor, String loadPerformer, double freight) {
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
		this.add(id + "");
		this.add(type.toString());
		this.add(loadDate.toString());
		this.add(transNum + "");
		this.add(departPlace.toString());
		this.add(destination.toString());
		for (int i = 0; i < waybillNumList.length; i++) {
			this.add(waybillNumList[i] + "");

		}
		this.add(loadMonitor);
		this.add(loadPerformer);
		this.add(freight + "");
	}

	public long getId() {
		return id;
	}

	public ListType getType() {
		return type;
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

	public long[] getWaybillNumList() {
		return waybillNumList;
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
