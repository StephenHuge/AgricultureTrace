package agriculture.ljd.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import agriculture.ljd.model.GoodsAttr;

@Repository("goodsAttrDao")
public class GoodsAttrDaoImpl implements GoodsAttrDao{
	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addGoodsAttr(GoodsAttr goodsAttr) {
		this.sessionFactory.getCurrentSession().save(goodsAttr);
		this.sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public void updateGoodsAttr(GoodsAttr goodsAttr) {
		this.sessionFactory.getCurrentSession().update(goodsAttr);
		this.sessionFactory.getCurrentSession().flush();
		
	}
	@Override
	public void delGoodsAttr(int goodsId) {
		GoodsAttr goodsAttr = this.load(goodsId);
		this.sessionFactory.getCurrentSession().delete(goodsAttr);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public GoodsAttr load(int goodsId) {
		return (GoodsAttr) this.sessionFactory.getCurrentSession().load(GoodsAttr.class, goodsId);
	}
	
	@Override
	public int getGroupIdByGoodsId(int goodsId) {
		return (int) sessionFactory.getCurrentSession().createQuery("select groupId from GOODSATTR where goodsId=?")
		.setParameter(0, goodsId).uniqueResult();
	}

	@Override
	public GoodsAttr getAttrById(int goodsId) {
		return (GoodsAttr) this.sessionFactory.getCurrentSession().createQuery("select * from GoodsAttr where goodsId=?")
				.setParameter(0, goodsId).uniqueResult();
	}


}
