package agriculture.ljd.utils;

import agriculture.ljd.model.Authority;
import agriculture.ljd.model.User;

/*
 * ����ʵ����࣬���Է��ظ������ʵ��
 * �Թ�Controller��ֱ�ӵ���
 * */
public final class GenEntityUtil {
	
	/*
	 * ����Userʵ����
	 * */
	public static User genUser(int userId, String userName,String password) {
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		user.setUserId(userId);
		return user;
	}
	
	/*
	 * ����Authorityʵ����
	 * */
	public static Authority genAuthority(int groupId,int userId) {
		Authority authority = new Authority();
		authority.setGroupId(groupId);
		authority.setUserId(userId);
		return authority;
	}
}
