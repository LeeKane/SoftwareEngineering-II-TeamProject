package vo;

import java.util.Vector;

import po.TimePO;

public class WareShowVO extends Vector<String> {
	private int qu;
	private int pai;
	private int jia;
	private int wei;
	private long id;
	private TimePO time;
	public WareShowVO(long id,TimePO time,int qu, int pai, int jia, int wei) {
		super();
		this.id=id;
		this.time=time;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.add(id+"");
		this.add(time.toString());
		this.add(qu+"");
		this.add(pai+"");
		this.add(jia+"");
		this.add(wei+"");
	}
}
