package vo;
import java.io.Serializable;
import java.util.Vector;

import po.*;

public class DriverVO extends Vector<String> implements Serializable{
	private long number;/*司机编号*/
	private String name;/*司机姓名*/
	private TimePO birthday;/*出生日期*/
	private String ID;/*身份证号*/
	private String Tel;/*手机号码*/
	private String carunit;/*车辆单位*/
	private String sex;/*性别*/
	private TimePO licensedate;/*行驶证期限*/
	public DriverVO(long number, String name, TimePO birthday, String iD,
			String tel, String carunit, String sex, TimePO licensedate) {
		super();
		
		this.add(number+"");
		this.add(name);
		this.add(birthday.toSpecicalString());
		this.add(iD);
		this.add(tel);
		this.add(carunit);
		this.add(sex);
		this.add(licensedate.toSpecicalString());

		this.number = number;
		this.name = name;
		this.birthday = birthday;
		ID = iD;
		Tel = tel;
		this.carunit = carunit;
		this.sex = sex;
		this.licensedate = licensedate;
	}
	public long getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}

	public TimePO getBirthday() {
		return birthday;
	}
	
	public String getID() {
		return ID;
	}

	public String getTel() {
		return Tel;
	}

	public String getCarunit() {
		return carunit;
	}

	public String getSex() {
		return sex;
	}
	
	public TimePO getLicensedate() {
		return licensedate;
	}

	
}
