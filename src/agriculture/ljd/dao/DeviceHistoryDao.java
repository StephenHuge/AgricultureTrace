package agriculture.ljd.dao;

import java.util.HashMap;

public interface DeviceHistoryDao {
	public HashMap<Integer, Float> getValueById(Integer [] deviceIds);
}
