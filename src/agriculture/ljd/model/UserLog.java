package agriculture.ljd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERLOG")
public class UserLog {
	private int userLogId;
	private int userId;
	private int groupId;
	private String recordTime;
	
	@Id
	public int getUserLogId() {
		return userLogId;
	}
	public void setUserLogId(int userLogId) {
		this.userLogId = userLogId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	

	

}
