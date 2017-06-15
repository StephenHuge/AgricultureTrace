package agriculture.ljd.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import agriculture.ljd.model.GroupAttr;

public class GroupAttrDaoImpl implements GroupAttrDao{

	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void addGroupAttr(GroupAttr groupAttr) {
		this.sessionFactory.getCurrentSession().save(groupAttr);
		this.sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void updateGroupAttr(GroupAttr groupAttr) {
		this.sessionFactory.getCurrentSession().update(groupAttr);
		this.sessionFactory.getCurrentSession().flush();
	}
	@Override
	public void delGroupAttr(int groupId) {
		GroupAttr groupAttr = this.load(groupId);
		this.sessionFactory.getCurrentSession().delete(groupAttr);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public GroupAttr load(int groupId) {
		return (GroupAttr) this.sessionFactory.getCurrentSession().load(GroupAttr.class, groupId);
	}

	@Override
	public Integer[] getDeviceIdsByGroupId(int groupId) {
		return (Integer []) sessionFactory.getCurrentSession().createQuery("select deviceId from GroupAttr "
				+ "where groupId=?").setParameter(0, groupId).list().toArray();
	}

	@Override
	public GroupAttr getAttrById(int groupId) {
		return (GroupAttr) this.sessionFactory.getCurrentSession().createQuery("select * from GroupAttr where groupId=?")
				.setParameter(0, groupId).uniqueResult();
	}

	@Override
	public String getNameById(int groupId) {
		return (String) this.sessionFactory.getCurrentSession().createQuery("select groupName from GroupAttr where groupId=?")
				.setParameter(0, groupId).uniqueResult();
	}

}
