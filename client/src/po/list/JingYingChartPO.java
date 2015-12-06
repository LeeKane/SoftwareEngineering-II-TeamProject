package po.list;

import po.TimePO;
import util.ListState;

public class JingYingChartPO {
	
	private long id;//经营情况表编号
    private TimePO startdate;//开始日期
	private TimePO endate;//结束日期
	private MoneyInListPO[] allmoneyinlist;//所有收款单
	private MoneyOutListPO[] allmoneyoutlist;//所有出款单

	
	public JingYingChartPO(long id,TimePO startdate,TimePO endate,
			MoneyInListPO[] allmoneyinlist,MoneyOutListPO[] allmoneyoutlist) {
		super();
		this.id = id;
		this.startdate = startdate;
		this.endate = endate;
		this.allmoneyinlist = allmoneyinlist;
		this.allmoneyoutlist = allmoneyoutlist;
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

	public MoneyInListPO[] getAllmoneyinlist() {
		return allmoneyinlist;
	}

	public void setAllmoneyinlist(MoneyInListPO[] allmoneyinlist) {
		this.allmoneyinlist = allmoneyinlist;
	}

	public MoneyOutListPO[] getAllmoneyoutlist() {
		return allmoneyoutlist;
	}

	public void setAllmoneyoutlist(MoneyOutListPO[] allmoneyoutlist) {
		this.allmoneyoutlist = allmoneyoutlist;
	}


}
