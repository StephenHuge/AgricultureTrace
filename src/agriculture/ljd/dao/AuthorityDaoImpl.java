package agriculture.ljd.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import agriculture.ljd.model.Authority;

@Repository("authorityDao")
public class AuthorityDaoImpl implements AuthorityDao {
	
	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addAuthority(Authority authority) {
		this.sessionFactory.getCurrentSession().save(authority);
		this.sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public void updateAuthority(Authority authority) {
		this.sessionFactory.getCurrentSession().update(authority);
		this.sessionFactory.getCurrentSession().flush();
		
	}
	
	@Override
	public void delAuthority(int userId) {
		Authority authority = this.load(userId);
		this.sessionFactory.getCurrentSession().delete(authority);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Authority load(int userId) {
		return (Authority) this.sessionFactory.getCurrentSession().load(Authority.class, userId);
		
	}


	/*
	 * 根据用户的id查看用户是否有对相应组的操作权限，如
	 * 果有，则进入下一步核对用户名密码阶段
	 * */
	@Override
	public int getGroupIdByUserId(int userId) {
		return (int) sessionFactory.getCurrentSession().createQuery("select groupId from WRITEABLE where userId=?")
				.setParameter(0, userId).uniqueResult();
	}

	@Override
	public boolean containUserId(int userId) {
		return (boolean) sessionFactory.getCurrentSession().createQuery("select userId from WRITEABLE where userId=?")
				.setParameter(0, userId).uniqueResult().equals(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> getAllAuthority() {
		return (List<Authority>)sessionFactory.getCurrentSession().createQuery("select * from WRITEABLE")
				.list();
	}

}
