package po;

import java.io.Serializable;

public class garageware implements Serializable{
  public TimePO time;
  public long id;
public garageware(TimePO time, long id) {
	super();
	this.time = time;
	this.id = id;
}
public TimePO getTime() {
	return time;
}
public void setTime(TimePO time) {
	this.time = time;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
  
}
