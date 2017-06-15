package agriculture.ljd.service;

import java.util.HashMap;

public interface DeviceHistoryService {
	public HashMap<Integer, Float> getValueById(Integer [] deviceIds);
}
