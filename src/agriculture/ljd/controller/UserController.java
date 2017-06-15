package agriculture.ljd.controller;

import javax.annotation.Resource;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import agriculture.ljd.service.AuthorityService;
import agriculture.ljd.service.GroupAttrService;
import agriculture.ljd.service.UserService;
import agriculture.ljd.utils.GenEntityUtil;

/*
 * �û�Controller������������Ϣά����Ա��ע�ᡢ��¼������
 * ���ߣ����̶�
 * ʱ�䣺2017.4.2
 * */

@Controller
@RequestMapping("/user")
public class UserController {

	private AuthorityService authorityService;
	private UserService userService;
	private GroupAttrService groupAttrService;
	
	
	public AuthorityService getAuthorityService() {
		return authorityService;
	}
	
	@Resource
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	
	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	public GroupAttrService getGroupAttrService() {
		return groupAttrService;
	}

	@Resource
	public void setGroupAttrService(GroupAttrService groupAttrService) {
		this.groupAttrService = groupAttrService;
	}
	

	/*
	 * ��Ϣά����Ա��¼�������������Ƶ�¼����
	 * ����Ϊ�û���������
	 * */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSystem(@PathVariable String username,
								@PathVariable String password,
								Model model){
		if (userService.getUserName(username).equals(null)) {
			model.addAttribute("result","�û���������");
			return "pages/user/login";
		}
		
		if (BCrypt.checkpw(password, userService.getPassword(username))) {
			model.addAttribute("result","��¼�ɹ������Ժ�");
			return "pages/goods/" + getGroupName(username) + "/goods_detail_edit";
		} else {
			model.addAttribute("result","�������");
			return "pages/user/login";
		}
				
	}
	
	/*
	 * ��Ϣά����Աע��Controller�������ĳ��Ա��ע��Ϊ��Ϣά����Ա
	 * ����Ϊ�û�id���û����������
	 * */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerSystem(@PathVariable int userId,
								 @PathVariable int groupId,
								 @PathVariable String userName,
							 	 @PathVariable String password,
								 Model model) {

		if (authorityService.containUserId(userId)) {
			return "pages/user/register_failed";	
		} 
			
		if (userService.getUserName(userName).equals(null)) {
			userService.add(GenEntityUtil.genUser(userId, userName, password));
			
			return "pages/user/register_success";
			
			//return "pages/goods/" + groupAttrService.getNameById(groupId) + "/goods_detail_edit";
		} else {
			model.addAttribute("result","����Ȩ�ޣ���ֱ�ӵ�¼");
			return "pages/user/login";
		}
					
	}	
	
	/*
	 * �����û�����ȡ������ƣ������Ǵ��׻��ǰ���
	 * */
	private String getGroupName(String username){
		return groupAttrService.getNameById(authorityService.
				getGroupIdByUserId(userService.getUserId(username)));
	}
	
	
}
