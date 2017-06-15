package agriculture.ljd.dao;

import agriculture.ljd.model.User;

public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	public void delUser(int userId);
	public User load(int userId);
	
	public int getIdByName(String username);
	public String getUserName(String username);
	public String getPassword(String username);
}
