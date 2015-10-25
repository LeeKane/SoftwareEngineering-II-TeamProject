package po;
import java.io.Serializable;

import util.*;
public class FinancePO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TimePO time;/*时间*/
private StaffPO staff;/*收款人*/
private InstitlePO institute;/*收款单位(收款方)*/
private double money;/*收款金额*/
public FinancePO(StaffPO staff, InstitlePO institute, double money,TimePO time) {
	super();
	this.staff = staff;
	this.institute = institute;
	this.money = money;
	this.time=time;
}

public TimePO getTime() {
	return time;
}

public void setTime(TimePO time) {
	this.time = time;
}

public StaffPO getStaff() {
	return staff;
}
public void setStaff(StaffPO staff) {
	this.staff = staff;
}
public InstitlePO getInstitute() {
	return institute;
}
public void setInstitute(InstitlePO institute) {
	this.institute = institute;
}
public double getMoney() {
	return money;
}
public void setMoney(double  money) {
	this.money = money;
}

	
}
