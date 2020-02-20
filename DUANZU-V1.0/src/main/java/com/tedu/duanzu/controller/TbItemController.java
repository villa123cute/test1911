package com.tedu.duanzu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tedu.duanzu.Service.TbOrderItemService;
import com.tedu.duanzu.entity.OrderItem;
import com.tedu.duanzu.entity.vo.JsonResult;
import com.tedu.duanzu.entity.vo.PageObject;

@Controller
@RequestMapping("/dingdan/")
public class TbItemController {
	@Autowired
	private TbOrderItemService tbOrderItemService;
	@RequestMapping("doFindAll")
	@ResponseBody
	public JsonResult DingDanUI(Integer landlordId,Integer pageCurrent) {
		PageObject<OrderItem> findDingDans = tbOrderItemService.findDingDans(landlordId, pageCurrent);
		System.out.println(findDingDans);
		return new JsonResult(findDingDans);
		}
	@RequestMapping("doFindAffirm")
	@ResponseBody
	public JsonResult AffirmCancel(Integer landlordId,Integer affirmCancel,Integer pageCurrent) {
		PageObject<OrderItem> findStatus = tbOrderItemService.findStatus(landlordId, affirmCancel, pageCurrent);
		return new JsonResult(findStatus);
	}	
	@RequestMapping("doFindStatus")
	@ResponseBody
	public JsonResult StatusS(Integer landlordId,Integer status,Integer pageCurrent) {
		PageObject<OrderItem> findByStatus = tbOrderItemService.findByStatus(landlordId, status, pageCurrent);
		return new JsonResult(findByStatus);
	}
	//交易状态,未支付查询
	@RequestMapping("doFindOkOrNo")
	@ResponseBody
	public JsonResult trade(Integer landlordId,Integer tradeStatus,Integer pageCurrent) {
		PageObject<OrderItem> findBytrade = tbOrderItemService.findBytrade(landlordId, tradeStatus, pageCurrent);
		System.out.println("我是人:"+findBytrade);
		return new JsonResult(findBytrade);
	}
	@RequestMapping("pageUI")
	public String pageUI() {
		return "common/page2";
	}
}
