package agriculture.ljd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GROUPATTR ")
public class GroupAttr {
	
	private int groupId;
	private String groupName;
	private int deviceId;
	
	private String certificationId;
	private String execStandard;
	private String productArea;
	private String envVideo;
	private String licence;
	
	@Id
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	public String getCertificationId() {
		return certificationId;
	}
	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}
	
	public String getExecStandard() {
		return execStandard;
	}
	public void setExecStandard(String execStandard) {
		this.execStandard = execStandard;
	}
	
	public String getProductArea() {
		return productArea;
	}
	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}
	
	public String getEnvVideo() {
		return envVideo;
	}
	public void setEnvVideo(String envVideo) {
		this.envVideo = envVideo;
	}
	
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	
}
