package po;

import java.io.Serializable;

public class TimePO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int year=0; //年
	private int month=0; //月
	private int day=0; //日
	private int hour=0; //时
	private int min=0; //分
	private int sec=0; //秒
	
	public TimePO(int year, int month, int day, int hour, int min, int sec) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	@Override
	public String toString() {
		return year+"y"+month+"m"+day+"d"+hour+"h"+min+"m"+sec+"s";
	}
	

	
	
	
}
