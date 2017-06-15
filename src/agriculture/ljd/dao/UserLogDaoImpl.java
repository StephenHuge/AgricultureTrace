package agriculture.ljd.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import agriculture.ljd.model.UserLog;

@Repository("userLogDao")
public class UserLogDaoImpl implements UserLogDao{
	
	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUserLog(UserLog userLog) {
		this.sessionFactory.getCurrentSession().save(userLog);
		this.sessionFactory.getCurrentSession().flush();
		
	}
	

	@Override
	public void updateUserLog(UserLog userLog) {
		this.sessionFactory.getCurrentSession().update(userLog);
		this.sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public String getTimeById(int userId) {
		return (String) sessionFactory.getCurrentSession().createQuery("select recordtime "
				+ "from USERLOG where userId=?").setParameter(0, userId).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLog> getAllOperationLog() {
		return sessionFactory.getCurrentSession().createQuery("select * from USERLOG").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLog> getOperationLogById(int userId) {
		return sessionFactory.getCurrentSession().createQuery("select * from USERLOG where"
				+ " userId=?").setParameter(0, userId).list();
	}
	
}
