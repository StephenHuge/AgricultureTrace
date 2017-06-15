package agriculture.ljd.service;

import java.util.HashMap;

import javax.annotation.Resource;

public class DeviceValueService {
	private DeviceHistoryService deviceHistoryService;
	private DeviceService deviceService;
	
	public DeviceHistoryService getDeviceHistoryService() {
		return deviceHistoryService;
	}
	
	@Resource
	public void setDeviceHistoryService(DeviceHistoryService deviceHistoryService) {
		this.deviceHistoryService = deviceHistoryService;
	}
	
	
	public DeviceService getDeviceService() {
		return deviceService;
	}
	
	@Resource
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	public HashMap<String, Float> getDeviceValue(Integer [] deviceIds) {
		HashMap<String, Float> result = new HashMap<>();
		for (int i = 0; i < deviceIds.length; i++) {
			result.put(deviceService.getIdAndCode(deviceIds).get(deviceIds[i]), 
					deviceHistoryService.getValueById(deviceIds).get(deviceIds[i]));
		}
		return result;
	}
}
