package vo;

import java.util.Vector;

import po.TimePO;
import util.ListState;
import util.Vehicle;

public class WareShowVO extends Vector<String> {
	private int qu;
	private int pai;
	private int jia;
	private int wei;
	private long id;
	private TimePO time;
	private ListState state;
	private Vehicle vehicle;
	public WareShowVO(ListState state,long id,TimePO time,int qu, int pai, int jia, int wei) {
		super();
		this.state=state;
		this.id=id;
		this.time=time;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		if(state.equals(ListState.SUBMITTED)){
		this.add("入库单");
		}
		if(state.equals(ListState.REVIEWED)){
			this.add("出库单");
			}
		this.add(id+"");
		this.add(time.toString());
		this.add(qu+"");
		this.add(pai+"");
		this.add(jia+"");
		this.add(wei+"");
	}
	public int getQu() {
		return qu;
	}
	public void setQu(int qu) {
		this.qu = qu;
	}
	public int getPai() {
		return pai;
	}
	public void setPai(int pai) {
		this.pai = pai;
	}
	public int getJia() {
		return jia;
	}
	public void setJia(int jia) {
		this.jia = jia;
	}
	public int getWei() {
		return wei;
	}
	public void setWei(int wei) {
		this.wei = wei;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TimePO getTime() {
		return time;
	}
	public void setTime(TimePO time) {
		this.time = time;
	}
	
	
	
}
