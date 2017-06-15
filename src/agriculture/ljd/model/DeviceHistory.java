package agriculture.ljd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEVICEHISTORY")
public class DeviceHistory {
	
	private int deviceHistoryId;
	private int deviceId;
	private int rectime;
	private int switchValue;
	private float analogYValue;
	
	@Id
	public int getDeviceHistoryId() {
		return deviceHistoryId;
	}
	public void setDeviceHistoryId(int deviceHistoryId) {
		this.deviceHistoryId = deviceHistoryId;
	}
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	public int getRectime() {
		return rectime;
	}
	public void setRectime(int rectime) {
		this.rectime = rectime;
	}
	
	public int getSwitchValue() {
		return switchValue;
	}
	public void setSwitchValue(int switchValue) {
		this.switchValue = switchValue;
	}
	
	public float getAnalogYValue() {
		return analogYValue;
	}
	public void setAnalogYValue(float analogYValue) {
		this.analogYValue = analogYValue;
	}
	
	
}
