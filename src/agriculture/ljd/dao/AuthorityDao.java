package agriculture.ljd.dao;

import java.util.List;

import agriculture.ljd.model.Authority;
public interface AuthorityDao {
	public void addAuthority(Authority authority);
	public void updateAuthority(Authority authority);
	public void delAuthority(int userId);
	public Authority load(int userId);
	
	public int getGroupIdByUserId(int userId);
	public boolean containUserId(int userId);
	public List<Authority> getAllAuthority();
}
