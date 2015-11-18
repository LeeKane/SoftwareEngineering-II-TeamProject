package mockobject;

import bl.finance.FinanceReceipt;
import po.InstitutePO;
import po.StaffPO;
import po.TimePO;

public class MockFinanceReceipt extends FinanceReceipt{
	TimePO time;/*时间*/
	StaffPO staff;/*收款人*/
	InstitutePO institute;/*收款单位(收款方)*/
	double money;/*收款金额*/
	
	public MockFinanceReceipt(TimePO time, StaffPO staff, InstitutePO institute, double money) {
		super();
		this.time = time;
		this.staff = staff;
		this.institute = institute;
		this.money = money;
	}
}
