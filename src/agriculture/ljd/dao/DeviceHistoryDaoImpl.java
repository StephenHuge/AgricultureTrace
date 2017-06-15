package agriculture.ljd.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

public class DeviceHistoryDaoImpl implements DeviceHistoryDao{
	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HashMap<Integer, Float> getValueById(Integer[] deviceIds) {
		HashMap<Integer, Float> result = new HashMap<>();
		for (int i = 0; i < deviceIds.length; i++) {
			Float tmp = (Float) sessionFactory.getCurrentSession().createQuery("select analogyValue"
					+ " from DEVICEHISTORY where deviceId=?")
			.setParameter(0, deviceIds[i]).uniqueResult();
			result.put(deviceIds[i], tmp);
		}
		return result;
	}

	
	
}
