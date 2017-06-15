package agriculture.ljd.service;

import agriculture.ljd.model.GoodsAttr;

public interface GoodsAttrService {
	public void addGoodsAttr(GoodsAttr goodsAttr);
	public void delGoodsAttr(int goodsId);
	public void updateGoodsAttr(GoodsAttr goodsAttr);
	public int getGroupIdByGoodsId(int goodsId);
	public GoodsAttr getAttrById(int goodsId);
}
