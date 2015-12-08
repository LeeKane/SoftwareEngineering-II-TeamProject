package po;
import java.io.Serializable;
import util.*;

public class CostchartPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ListType moneyin;
	TimePO paytime;
	private double paymoney;
	private String payer;
	private String payaccount;
	private double rent;
	TimePO rentyear;
	private double freight;
	private long waybillnum;
	private double wages;
	TimePO wagesmonth;
	private double reward;
	RewardType rewardtype;
	

	public CostchartPO(ListType moneyin,
	TimePO paytime, double paymoney, String payer,String payaccount,double rent,TimePO rentyear,double freight,long waybillnum,double wages,TimePO wagesmonth,double reward,RewardType rewardtype){
		this.paytime=paytime;
		this.paymoney=paymoney;
		this.payer=payer;
		this.payaccount=payaccount;
		this.rent=rent;
		this.rentyear=rentyear;
		this.freight=freight;
		this.waybillnum=waybillnum;
		this.wages=wages;
		this.wagesmonth=wagesmonth;
		this.reward=reward;
		this.rewardtype=rewardtype;
	}
	public ListType getMoneyin() {
		return moneyin;
	}
	public void setMoneyin(ListType moneyin) {
		this.moneyin = moneyin;
	}
	public TimePO getPaytime() {
		return paytime;
	}
	public void setPaytime(TimePO paytime) {
		this.paytime = paytime;
	}
	public double getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(double paymoney) {
		this.paymoney = paymoney;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public String getPayaccount() {
		return payaccount;
	}
	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public TimePO getRentyear() {
		return rentyear;
	}
	public void setRentyear(TimePO rentyear) {
		this.rentyear = rentyear;
	}
	public double getFreight() {
		return freight;
	}
	public void setFreight(double freight) {
		this.freight = freight;
	}
	public long getWaybillnum() {
		return waybillnum;
	}
	public void setWaybillnum(long waybillnum) {
		this.waybillnum = waybillnum;
	}
	public double getWages() {
		return wages;
	}
	public void setWages(double wages) {
		this.wages = wages;
	}
	public TimePO getWagesmonth() {
		return wagesmonth;
	}
	public void setWagesmonth(TimePO wagesmonth) {
		this.wagesmonth = wagesmonth;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	public RewardType getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(RewardType rewardtype) {
		this.rewardtype = rewardtype;
	}
	

}
