package agriculture.ljd.utils;

import agriculture.ljd.model.Authority;
import agriculture.ljd.model.User;

/*
 * 生成实体的类，用以返回各种类的实体
 * 以供Controller类直接调用
 * */
public final class GenEntityUtil {
	
	/*
	 * 生成User实体类
	 * */
	public static User genUser(int userId, String userName,String password) {
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		user.setUserId(userId);
		return user;
	}
	
	/*
	 * 生成Authority实体类
	 * */
	public static Authority genAuthority(int groupId,int userId) {
		Authority authority = new Authority();
		authority.setGroupId(groupId);
		authority.setUserId(userId);
		return authority;
	}
}
