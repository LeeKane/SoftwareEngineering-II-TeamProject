package vo;

import po.InstitlePO;
import po.StaffPO;
import po.TimePO;
import util.*;
public class FinanceVO {
	private TimePO time;
	private StaffPO staff;/*收款人*/
	private InstitlePO institute;/*收款单位(收款方)*/
	private double money;/*收款金额*/
	public FinanceVO(StaffPO staff, InstitlePO institute, double money,TimePO time) {
		super();
		this.staff = staff;
		this.institute = institute;
		this.money = money;
		this.time=time;
	}
	public StaffPO getStaff() {
		return staff;
	}
	public InstitlePO getInstitute() {
		return institute;
	}
	public double getMoney() {
		return money;
	}
	public TimePO getTime() {
		return time;
	}

}
