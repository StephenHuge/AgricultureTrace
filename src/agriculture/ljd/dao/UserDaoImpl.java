package agriculture.ljd.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import agriculture.ljd.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateUser(User user) {
		this.sessionFactory.getCurrentSession().update(user);
		this.sessionFactory.getCurrentSession().flush();
		
	}
	@Override
	public void delUser(int userId) {
		User user = this.load(userId);
		this.sessionFactory.getCurrentSession().delete(user);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public User load(int userId) {
		return (User) this.sessionFactory.getCurrentSession().load(User.class, userId);
	}

	public String getUserName(String username) {
		return (String) sessionFactory.getCurrentSession().createQuery("select username from USER where username=?")
				.setParameter(0, username).uniqueResult();
	}
	
	@Override
	public String getPassword(String username) {
		return (String) sessionFactory.getCurrentSession().createQuery("select password from USER where username=?")
				.setParameter(0, username).uniqueResult();
	}

	@Override
	public int getIdByName(String username) {
		return (Integer) sessionFactory.getCurrentSession().createQuery("select userId from USER where userName=?")
				.setParameter(0, username).uniqueResult();
	}





}
