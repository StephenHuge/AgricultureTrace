package agriculture.ljd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.javafx.sg.prism.NGShape.Mode;
import com.sun.org.apache.xpath.internal.operations.Mod;

import agriculture.ljd.model.Authority;
import agriculture.ljd.model.UserLog;
import agriculture.ljd.service.AuthorityService;
import agriculture.ljd.service.UserLogService;
import agriculture.ljd.service.UserService;
import agriculture.ljd.utils.GenEntityUtil;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
	
	private AuthorityService authorityService;
	private UserLogService userLogService;
	private UserService userService;
	
	
	public AuthorityService getAuthorityService() {
		return authorityService;
	}
	
	@Resource
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	
	public UserLogService getUserLogService() {
		return userLogService;
	}
	
	@Resource
	public void setUserLogService(UserLogService userLogService) {
		this.userLogService = userLogService;
	}
	
	
	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addAuthority(@PathVariable int userId,
								@PathVariable int groupId,
								Model model) {
		//如果员工发邮件进行权限申请的话，则进行添加操作
		if (true) {
			authorityService.add(GenEntityUtil.genAuthority(groupId, userId));
			model.addAttribute("result","添加成功");
			return "/pages/user/authorityadd";
		} 
		
		return null;
	}
	
	/*
	 * 显示信息维护人员列表及其所对应的商品组
	 * */
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showUsers(Model model) {
		List<Authority> list = authorityService.getAllAuthority();
		model.addAttribute("list",list);
		return "pages/user/usershow";
	}
	
	/*
	 * 删除某个人员，这样相应人员对产品不再具有编辑权限
	 * */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deleteAuthority(@PathVariable int userId,
									Model model) {
		authorityService.delete(userId);
		return "pages/user/usershow";
	}
	
	/*
	 * 显示所有的历史记录列表
	 * */
	@RequestMapping(value="/showhistory",method=RequestMethod.GET)
	public String showAllOperationHistory(Model model){
		List<UserLog> list = userLogService.getAllOperationHistory();
		model.addAttribute("list",list);
		return "pages/user/allhistory";
	}
	
	/*
	 * 显示某个人的操作历史
	 * */
	@RequestMapping(value="/showhistory/{userId}",method=RequestMethod.GET)
	public String showOperationHistoryById(@PathVariable int userId,Model model){
		List<UserLog> list = userLogService.getOperationHistoryById(userId);
		model.addAttribute("list",list);
		return "pages/user/history";
	}

}
