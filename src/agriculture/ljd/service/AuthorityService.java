package agriculture.ljd.service;

import java.util.List;

import agriculture.ljd.model.Authority;

public interface AuthorityService {
	
	public void add(Authority authority);
	public void update(Authority authority);
	public void delete(int userId);
	
	public int getGroupIdByUserId(int userId);
	public boolean containUserId(int userId);
	public List<Authority> getAllAuthority();
}
