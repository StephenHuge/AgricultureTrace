package agriculture.ljd.service;

import javax.annotation.Resource;

import agriculture.ljd.dao.GroupAttrDao;
import agriculture.ljd.model.GroupAttr;

public class GroupAttrServiceImpl implements GroupAttrService{

	private GroupAttrDao groupAttrDao;
	
	public GroupAttrDao getGroupAttrDao() {
		return groupAttrDao;
	}

	@Resource
	public void setGroupAttrDao(GroupAttrDao groupAttrDao) {
		this.groupAttrDao = groupAttrDao;
	}

	@Override
	public void addGroupAttr(GroupAttr groupAttr) {
		groupAttrDao.addGroupAttr(groupAttr);
		
	}

	@Override
	public void delGroupAttr(int groupId) {
		groupAttrDao.delGroupAttr(groupId);
		
	}

	@Override
	public void updateGroupAttr(GroupAttr groupAttr) {
		groupAttrDao.updateGroupAttr(groupAttr);
		
	}

	@Override
	public Integer[] getDeviceIdsByGroupId(int groupId) {
		return groupAttrDao.getDeviceIdsByGroupId(groupId);
	}

	@Override
	public GroupAttr getAttrById(int groupId) {
		return groupAttrDao.getAttrById(groupId);
	}

	@Override
	public String getNameById(int groupId) {
		return groupAttrDao.getNameById(groupId);
	}

}
