package agriculture.ljd.service;

import agriculture.ljd.model.User;

public interface UserService {
	public void add(User user);
	public void update(User user);
	public void delete(int userId);
	
	public String getUserName(String username);
	public String getPassword(String username);
	public Integer getUserId(String username);
	
}
