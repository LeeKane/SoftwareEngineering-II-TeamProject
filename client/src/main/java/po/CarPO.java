package po;
import java.io.Serializable;
import java.awt.Image;
public class CarPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;/*车辆代号*/
	private long engine;/*发动机号*/
	private String carname;/*车辆代号*/
	private long basenumber;/*底盘号*/
	private String buytime;/*购买时间*/
	private String usetime;/*服役时间*/
	private Image image;/*车辆图片*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getEngine() {
		return engine;
	}
	public void setEngine(long engine) {
		this.engine = engine;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public long getBasenumber() {
		return basenumber;
	}
	public void setBasenumber(long basenumber) {
		this.basenumber = basenumber;
	}
	public String getBuytime() {
		return buytime;
	}
	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}
	public String getUsetime() {
		return usetime;
	}
	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

}
