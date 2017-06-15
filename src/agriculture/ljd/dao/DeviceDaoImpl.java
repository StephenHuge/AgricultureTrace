package agriculture.ljd.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("deviceDao")
public class DeviceDaoImpl implements DeviceDao {

	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public HashMap<Integer, String> getIdAndCode(Integer[] deviceIds) {
		HashMap<Integer, String> result = new HashMap<>();
		for (int i = 0; i < deviceIds.length; i++) {
			String tmp = (String) sessionFactory.getCurrentSession().createQuery("select deviceCode from DEVICE where deviceId=?")
					.setParameter(0, deviceIds[i]).uniqueResult();
			result.put(deviceIds[i], tmp);
		}
		return result;
	}
	
}
