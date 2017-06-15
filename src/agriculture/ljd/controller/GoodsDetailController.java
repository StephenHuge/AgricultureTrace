package agriculture.ljd.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import agriculture.ljd.service.DeviceValueService;
import agriculture.ljd.service.GoodsAttrService;
import agriculture.ljd.service.GroupAttrService;

@Controller
@RequestMapping("/goodsDetail")
public class GoodsDetailController {
	
	private GoodsAttrService goodsAttrService;
	private GroupAttrService groupAttrService;
	private DeviceValueService deviceValueService;
	
	public GoodsAttrService getGoodsAttrService() {
		return goodsAttrService;
	}
	
	@Resource
	public void setGoodsAttrService(GoodsAttrService goodsAttrService) {
		this.goodsAttrService = goodsAttrService;
	}
	
	
	public GroupAttrService getGroupAttrService() {
		return groupAttrService;
	}
	
	@Resource
	public void setGroupAttrService(GroupAttrService groupAttrService) {
		this.groupAttrService = groupAttrService;
	}

	public DeviceValueService getDeviceValueService() {
		return deviceValueService;
	}

	@Resource
	public void setDeviceValueService(DeviceValueService deviceValueService) {
		this.deviceValueService = deviceValueService;
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public String getGoodsInfo(@PathVariable int id,Model model){
		int groupId = goodsAttrService.getGroupIdByGoodsId(id);
		model.addAttribute("goodsAttr",goodsAttrService.getAttrById(id));
		model.addAttribute("groupAttr", groupAttrService.getAttrById(groupId));
		model.addAttribute("deviceValue", deviceValueService.
				getDeviceValue(groupAttrService.getDeviceIdsByGroupId(groupId)));
		return "/goodsDetail/{id}";	
	}
	
	
}
