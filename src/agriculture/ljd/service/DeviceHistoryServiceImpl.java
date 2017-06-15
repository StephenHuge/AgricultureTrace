package agriculture.ljd.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import agriculture.ljd.dao.DeviceHistoryDao;

@Service("deviceHistoryService")
public class DeviceHistoryServiceImpl implements DeviceHistoryService{

	private DeviceHistoryDao deviceHistoryDao;
	
	
	public DeviceHistoryDao getDeviceHistoryDao() {
		return deviceHistoryDao;
	}

	@Resource
	public void setDeviceHistoryDao(DeviceHistoryDao deviceHistoryDao) {
		this.deviceHistoryDao = deviceHistoryDao;
	}


	@Override
	public HashMap<Integer, Float> getValueById(Integer[] deviceIds) {
		return deviceHistoryDao.getValueById(deviceIds);
	}

}
