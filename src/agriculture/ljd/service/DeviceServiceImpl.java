package agriculture.ljd.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import agriculture.ljd.dao.DeviceDao;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService{

	private DeviceDao deviceDao;
	
	public DeviceDao getDeviceDao() {
		return deviceDao;
	}
	
	@Resource
	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}
	
	@Override
	public HashMap<Integer, String> getIdAndCode(Integer[] deviceIds) {
		return deviceDao.getIdAndCode(deviceIds);
	}
	

}
