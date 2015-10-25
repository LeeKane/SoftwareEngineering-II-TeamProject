package vo;
import util.*;
public class DriverVO {
	private static final long serialVersionUID = 1L;
	private long number;/*司机编号*/
	private String name;/*司机姓名*/
	private String birthday;/*出生日期*/
	private String ID;/*身份证号*/
	private long Tel;/*手机号码*/
	private String carunit;/*车辆单位*/
	private String sex;/*性别*/
	private String licensedate;/*行驶证期限*/
	public DriverVO(long number, String name, String birthday, String iD,
			long tel, String carunit, String sex, String licensedate) {
		super();
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

	public String getBirthday() {
		return birthday;
	}
	
	public String getID() {
		return ID;
	}

	public long getTel() {
		return Tel;
	}

	public String getCarunit() {
		return carunit;
	}

	public String getSex() {
		return sex;
	}
	
	public String getLicensedate() {
		return licensedate;
	}

	
}
