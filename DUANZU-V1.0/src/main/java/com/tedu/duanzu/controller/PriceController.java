package com.tedu.duanzu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.duanzu.Service.PriceService;
import com.tedu.duanzu.entity.HousePrice;
import com.tedu.duanzu.entity.vo.JsonResult;

@RestController
@RequestMapping("/price/")
public class PriceController {
	@Autowired
	PriceService priceService;
	@RequestMapping("doFindAllPrice")
	public JsonResult findAllPrice(Integer landlordId) {
		return new JsonResult(priceService.findAllPrice(landlordId));
	}
	@RequestMapping("doUpdatePrice")
	public JsonResult updatePrice(HousePrice housePrice) {
		priceService.updatePrice(housePrice);
		return new JsonResult("更新成功！");
	}	
}
