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
 * 用户Controller，用来控制信息维护人员的注册、登录的流程
 * 作者：刘继东
 * 时间：2017.4.2
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
	 * 信息维护人员登录函数，用来控制登录流程
	 * 参数为用户名和密码
	 * */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSystem(@PathVariable String username,
								@PathVariable String password,
								Model model){
		if (userService.getUserName(username).equals(null)) {
			model.addAttribute("result","用户名不存在");
			return "pages/user/login";
		}
		
		if (BCrypt.checkpw(password, userService.getPassword(username))) {
			model.addAttribute("result","登录成功，请稍候");
			return "pages/goods/" + getGroupName(username) + "/goods_detail_edit";
		} else {
			model.addAttribute("result","密码错误");
			return "pages/user/login";
		}
				
	}
	
	/*
	 * 信息维护人员注册Controller，负责给某个员工注册为信息维护人员
	 * 参数为用户id、用户名、密码等
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
			model.addAttribute("result","已有权限，请直接登录");
			return "pages/user/login";
		}
					
	}	
	
	/*
	 * 根据用户名获取组的名称，比如是大米还是白面
	 * */
	private String getGroupName(String username){
		return groupAttrService.getNameById(authorityService.
				getGroupIdByUserId(userService.getUserId(username)));
	}
	
	
}
