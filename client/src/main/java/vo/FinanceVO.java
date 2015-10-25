package vo;

import po.InstitlePO;
import po.StaffPO;
import util.*;
public class FinanceVO {
	private StaffPO staff;/*收款人*/
	private InstitlePO institute;/*收款单位(收款方)*/
	private double money;/*收款金额*/
	public FinanceVO(StaffPO staff, InstitlePO institute, double money) {
		super();
		this.staff = staff;
		this.institute = institute;
		this.money = money;
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


}
