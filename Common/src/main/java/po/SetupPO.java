package po;

import java.io.Serializable;

public class SetupPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TimePO setTime;//建账时间
	private String name;//帐名
	private String remark;//备注
	private boolean isSelected;//是否是现在使用的帐
	
	public SetupPO(TimePO setTime, String name, String remark, boolean isSelected) {
		super();
		this.setTime = setTime;
		this.name = name;
		this.remark = remark;
		this.isSelected = isSelected;
	}

	public TimePO getSetTime() {
		return setTime;
	}

	public void setSetTime(TimePO setTime) {
		this.setTime = setTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean getIsSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
