package po.list;

import java.io.Serializable;

import po.TimePO;
import util.City;
import util.ListState;
import util.ListType;

public class TransListPO implements Serializable {

	private ListType type = ListType.TRANS;/* 中转单 */
	private TimePO time; /* 装车时间 */
	private long id; /* 中转单编号 */
	private long transID;/* 货运编号 */
	private City StartCity;/* 出发城市 */
	private City EndCity;/* 到达城市 */
	private long transboxID;/* 货柜号 */
	private String supersivor;/* 监装员姓名 */
	private long[] orderlist;/* 本次装箱所有托运单号 */
	private double yunfei;/* 运费 */
	private ListState lst;/* 单据状态 */
	private long code;

	public TransListPO(ListType type, TimePO time, long id, long transID, City startCity, City endCity, long transboxID,
			String supersivor, long[] orderlist, double yunfei, ListState lst, long code) {
		super();
		this.type = type;
		this.time = time;
		this.id = id;
		this.transID = transID;
		StartCity = startCity;
		EndCity = endCity;
		this.transboxID = transboxID;
		this.supersivor = supersivor;
		this.orderlist = orderlist;
		this.yunfei = yunfei;
		this.lst = lst;
		this.code = code;
	}

	public ListType getType() {
		return type;
	}

	public void setType(ListType type) {
		this.type = type;
	}

	public TimePO getTime() {
		return time;
	}

	public void setTime(TimePO time) {
		this.time = time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTransID() {
		return transID;
	}

	public void setTransID(long transID) {
		this.transID = transID;
	}

	public City getStartCity() {
		return StartCity;
	}

	public void setStartCity(City startCity) {
		StartCity = startCity;
	}

	public City getEndCity() {
		return EndCity;
	}

	public void setEndCity(City endCity) {
		EndCity = endCity;
	}

	public long getTransboxID() {
		return transboxID;
	}

	public void setTransboxID(long transboxID) {
		this.transboxID = transboxID;
	}

	public String getSupersivor() {
		return supersivor;
	}

	public void setSupersivor(String supersivor) {
		this.supersivor = supersivor;
	}

	public long[] getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(long[] orderlist) {
		this.orderlist = orderlist;
	}

	public double getYunfei() {
		return yunfei;
	}

	public void setYunfei(double yunfei) {
		this.yunfei = yunfei;
	}

	public ListState getLst() {
		return lst;
	}

	public void setLst(ListState lst) {
		this.lst = lst;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

}
