package agriculture.ljd.service;

import agriculture.ljd.model.GroupAttr;

public interface GroupAttrService {
	public void addGroupAttr(GroupAttr groupAttr);
	public void delGroupAttr(int groupId);
	public void updateGroupAttr(GroupAttr groupAttr);
	public Integer[] getDeviceIdsByGroupId(int groupId);
	public GroupAttr getAttrById(int groupId);
	public String getNameById(int groupId);
}
