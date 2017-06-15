package agriculture.ljd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import agriculture.ljd.dao.AuthorityDao;
import agriculture.ljd.model.Authority;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService{

	private AuthorityDao authorityDao;
	
	
	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	@Resource
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	@Override
	public void add(Authority authority) {
		
		authorityDao.addAuthority(authority);
	}

	@Override
	public void update(Authority authority) {
		
		authorityDao.updateAuthority(authority);	
	}

	@Override
	public void delete(int userId) {
		
		authorityDao.delAuthority(userId);
	}
	
	@Override
	public int getGroupIdByUserId(int userId) {
		
		return authorityDao.getGroupIdByUserId(userId);
	}

	@Override
	public boolean containUserId(int userId) {
		
		return authorityDao.containUserId(userId);
	}

	@Override
	public List<Authority> getAllAuthority() {
		return authorityDao.getAllAuthority();
	}

}
