package vo;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;

public class SetupVO extends Vector<String> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TimePO setTime;// 建账时间
	private String name;// 帐名
	private String remark;// 备注
	private boolean isSelected;// 是否是现在使用的帐

	public SetupVO(TimePO setTime, String name, String remark, boolean isSelected) {
		super();
		this.setTime = setTime;
		this.name = name;
		this.remark = remark;
		this.isSelected = isSelected;

		this.add(setTime.toString());
		this.add(name);
		this.add(remark);
		if(isSelected==true)
			this.add("是");
		else
			this.add("否");
	}

	public TimePO getSetTime() {
		return setTime;
	}

	public String getName() {
		return name;
	}

	public String getRemark() {
		return remark;
	}

	public boolean getIsSelected() {
		return isSelected;
	}

}
