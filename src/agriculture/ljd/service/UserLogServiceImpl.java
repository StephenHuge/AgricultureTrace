package agriculture.ljd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import agriculture.ljd.dao.UserLogDao;
import agriculture.ljd.model.UserLog;

@Service("userLogService")
public class UserLogServiceImpl implements UserLogService{

	private UserLogDao userLogDao;
	
	public UserLogDao getUserLogDao() {
		return userLogDao;
	}
	
	@Resource
	public void setUserLogDao(UserLogDao userLogDao) {
		this.userLogDao = userLogDao;
	}

	@Override
	public String getTimeById(int userId) {
		return userLogDao.getTimeById(userId);
	}

	@Override
	public List<UserLog> getAllOperationHistory() {
		
		return userLogDao.getAllOperationLog();
	}

	@Override
	public List<UserLog> getOperationHistoryById(int userId) {
		return userLogDao.getOperationLogById(userId);
	}

}
