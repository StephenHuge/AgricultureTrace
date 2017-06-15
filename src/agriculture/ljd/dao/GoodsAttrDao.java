package agriculture.ljd.dao;

import agriculture.ljd.model.GoodsAttr;

public interface GoodsAttrDao {
	public void addGoodsAttr(GoodsAttr goodsAttr);
	public void delGoodsAttr(int goodsId);
	public void updateGoodsAttr(GoodsAttr goodsAttr);
	public GoodsAttr load(int goodsId);
	public int getGroupIdByGoodsId(int goodsId);
	public GoodsAttr getAttrById(int goodsId);
}
