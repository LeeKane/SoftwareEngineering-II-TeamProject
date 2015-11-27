package vo.list;

import java.util.Vector;

import po.TimePO;
import util.City;
import util.ListType;

public class TransListVO extends Vector<String> {
	private ListType type=ListType.TRANS;/*中转单 */
	private TimePO time;   /*装车时间*/
	private long id;    /*中转单编号*/
	private long transID;/*货运编号*/
	private City StartCity;/*出发城市*/
	private City EndCity;/*到达城市*/
	private long transboxID;/*货柜号*/
	private String supersivor;/*监装员姓名*/
	private long[] orderlist;/*本次装箱所有托运单号*/
	private long yunfei;/*运费*/
	public TransListVO(ListType type, TimePO time, long id, long transID,
			City startCity, City endCity, long transboxID, String supersivor,
			long[] orderlist, long yunfei) {
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
		this.add(type.toString());
		this.add(time.toString());
		this.add(id+"");
		this.add(transID+"");
		this.add(transID+"");
		this.add(StartCity.toString());
		this.add(EndCity.toString());
		this.add(transboxID+"");
		this.add(supersivor);
		for(int i=0;i<orderlist.length;i++){
			this.add(orderlist[i]+"");
		}
		this.add(yunfei+"");
	}
	public ListType getType() {
		return type;
	}
	public TimePO getTime() {
		return time;
	}
	public long getId() {
		return id;
	}
	public long getTransID() {
		return transID;
	}
	public City getStartCity() {
		return StartCity;
	}
	public City getEndCity() {
		return EndCity;
	}
	public long getTransboxID() {
		return transboxID;
	}
	public String getSupersivor() {
		return supersivor;
	}
	public long[] getOrderlist() {
		return orderlist;
	}
	public long getYunfei() {
		return yunfei;
	}
	
	
}
