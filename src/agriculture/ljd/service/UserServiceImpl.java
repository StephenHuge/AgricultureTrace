package agriculture.ljd.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import agriculture.ljd.dao.UserDao;
import agriculture.ljd.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao usersDao) {
		this.userDao = usersDao;
	}

	@Override
	public void add(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public void update(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void delete(int userId) {
		userDao.delUser(userId);
		
	}

	@Override
	public String getUserName(String username) {
		return userDao.getUserName(username);
	}

	@Override
	public String getPassword(String username) {
		return userDao.getPassword(username);
	}

	@Override
	public Integer getUserId(String username) {
		return userDao.getIdByName(username);
	}


}
