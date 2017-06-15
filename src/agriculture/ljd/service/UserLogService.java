package agriculture.ljd.service;

import java.util.List;

import agriculture.ljd.model.UserLog;

public interface UserLogService {
	public String getTimeById(int userId);
	public List<UserLog> getAllOperationHistory();
	public List<UserLog> getOperationHistoryById(int userId);
}
