package po;
import java.io.Serializable;
public class DriverPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long number;/*司机编号*/
	private String name;/*司机姓名*/
	private TimePO birthday;/*出生日期*/
	private String ID;/*身份证号*/
	private String Tel;/*手机号码*/
	private String carunit;/*车辆单位*/
	private String sex;/*性别*/
	private String licensedate;/*行驶证期限*/
	
	
	
	public DriverPO(long number, String name, TimePO birthday, String iD,
			String tel, String carunit, String sex, String licensedate) {
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
	public void setNumber(long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TimePO getBirthday() {
		return birthday;
	}
	public void setBirthday(TimePO birthday) {
		this.birthday = birthday;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getCarunit() {
		return carunit;
	}
	public void setCarunit(String carunit) {
		this.carunit = carunit;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLicensedate() {
		return licensedate;
	}
	public void setLicensedate(String licensedate) {
		this.licensedate = licensedate;
	}
	

}
