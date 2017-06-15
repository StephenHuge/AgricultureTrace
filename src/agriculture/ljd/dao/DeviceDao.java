package agriculture.ljd.dao;

import java.util.HashMap;

public interface DeviceDao {
	public HashMap<Integer, String> getIdAndCode(Integer [] deviceIds);
	
}
