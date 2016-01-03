package vo;

import java.util.Vector;

public class GaragePlaceVO extends Vector<String> {
	private int qu;
	private int pai;
	private int jia;
	private int wei;

	public GaragePlaceVO(int qu, int pai, int jia, int wei) {
		super();
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.add(qu + "");
		this.add(pai + "");
		this.add(jia + "");
		this.add(wei + "");
	}
}
