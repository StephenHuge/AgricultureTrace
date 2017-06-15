package agriculture.ljd.dao;

import java.util.List;

import agriculture.ljd.model.UserLog;

public interface UserLogDao {
	public void addUserLog(UserLog userLog);
	public void updateUserLog(UserLog userLog);
	public String getTimeById(int userId);
	public List<UserLog> getAllOperationLog();
	public List<UserLog> getOperationLogById(int userId);
}
