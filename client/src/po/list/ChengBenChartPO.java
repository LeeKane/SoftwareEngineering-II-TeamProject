package po.list;

import po.TimePO;
import util.ListState;

public class ChengBenChartPO {
	
	
	private long id;//成本收益表编号
	private TimePO startdate;//开始日期
	private TimePO endate;//结束日期
	private double allmoneyin;//总收入
	private double allmoneyout;//总支出
	private double allearn;//总利润
	private ListState state;//单据状态
	



	public ChengBenChartPO(long id,TimePO startdate,TimePO endate,double allmoneyin,
			double allmoneyout,double allearn,ListState state){
		super();
		this.id = id;
		this.startdate = startdate;
		this.endate = endate;
		this.allmoneyin = allmoneyin;
		this.allmoneyout = allmoneyout;
		this.allearn = allearn;
		this.state = state;
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TimePO getStartdate() {
		return startdate;
	}


	public void setStartdate(TimePO startdate) {
		this.startdate = startdate;
	}


	public TimePO getEndate() {
		return endate;
	}


	public void setEndate(TimePO endate) {
		this.endate = endate;
	}




	public double getAllmoneyin() {
		return allmoneyin;
	}
	public void setAllmoneyin(double allmoneyin) {
		this.allmoneyin = allmoneyin;
	}
	public double getAllmoneyout() {
		return allmoneyout;
	}
	public void setAllmoneyout(double allmoneyout) {
		this.allmoneyout = allmoneyout;
	}
	public double getAllearn() {
		return allearn;
	}
	public void setAllearn(double allearn) {
		this.allearn = allearn;
	}
	public ListState getState() {
		return state;
	}


	public void setState(ListState state) {
		this.state = state;
	}

}
