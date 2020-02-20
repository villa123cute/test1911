package com.tedu.duanzu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.duanzu.Service.BillService;
import com.tedu.duanzu.common.vo.PageObject;
import com.tedu.duanzu.entity.BillItem;
import com.tedu.duanzu.entity.LandlordInfo;
import com.tedu.duanzu.entity.LiquidateInfo;
import com.tedu.duanzu.entity.vo.JsonResult;

@RestController
@RequestMapping("/bill/")
public class BillController {
	@Autowired
	BillService billService;
	@RequestMapping("doFindBill")
	public JsonResult findBillByStatus(Integer landlordId,Integer status,Integer pageCurrent) {
		PageObject<BillItem> findBill = billService.findBillByStatus(landlordId,status,pageCurrent);
		return new JsonResult(findBill);
	}
	@RequestMapping("doFindLandlord")
	public JsonResult findLandlordInfo(Integer landlordId) {
		LandlordInfo findLandlordInfo = billService.findLandlordInfo(landlordId);
		return new JsonResult(findLandlordInfo);
	}
	
	@RequestMapping("doFindLiquidate")
	public JsonResult findLiquidateInfo(String billNumber,Integer liquidateType) {
		List<LiquidateInfo> findLiquidateInfo = billService.findLiquidateInfo(billNumber,liquidateType);
		return new JsonResult(findLiquidateInfo);
	}
}
