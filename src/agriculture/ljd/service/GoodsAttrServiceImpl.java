package agriculture.ljd.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import agriculture.ljd.dao.GoodsAttrDao;
import agriculture.ljd.model.GoodsAttr;

@Service("goodsAttrService")
public class GoodsAttrServiceImpl implements GoodsAttrService{

	private GoodsAttrDao goodsAttrDao;
	
	public GoodsAttrDao getGoodsAttrDao() {
		return goodsAttrDao;
	}

	@Resource
	public void setGoodsAttrDao(GoodsAttrDao goodsAttrDao) {
		this.goodsAttrDao = goodsAttrDao;
	}

	@Override
	public void addGoodsAttr(GoodsAttr goodsAttr) {
		goodsAttrDao.addGoodsAttr(goodsAttr);
	}

	@Override
	public void delGoodsAttr(int goodsId) {
		goodsAttrDao.delGoodsAttr(goodsId);
		
	}

	@Override
	public void updateGoodsAttr(GoodsAttr goodsAttr) {
		goodsAttrDao.updateGoodsAttr(goodsAttr);
	}

	@Override
	public int getGroupIdByGoodsId(int goodsId) {
		return goodsAttrDao.getGroupIdByGoodsId(goodsId);
	}

	@Override
	public GoodsAttr getAttrById(int goodsId) {
		return goodsAttrDao.getAttrById(goodsId);
	}

}
