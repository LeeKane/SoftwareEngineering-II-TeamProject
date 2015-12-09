package vo;

import java.io.Serializable;

import po.InstitutePO;
import po.StaffPO;
import po.TimePO;

public class FinanceVO implements Serializable {
	private TimePO time;
	private StaffPO staff;/* 收款人 */
	private InstitutePO institute;/* 收款单位(收款方) */
	private double money;/* 收款金额 */

	public FinanceVO(StaffPO staff, InstitutePO institute, double money, TimePO time) {
		super();
		this.staff = staff;
		this.institute = institute;
		this.money = money;
		this.time = time;
	}

	public StaffPO getStaff() {
		return staff;
	}

	public InstitutePO getInstitute() {
		return institute;
	}

	public double getMoney() {
		return money;
	}

	public TimePO getTime() {
		return time;
	}

}
