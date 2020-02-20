package com.tedu.duanzu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.duanzu.Service.GaiKuangService;
import com.tedu.duanzu.entity.OrderItem;
import com.tedu.duanzu.entity.vo.JsonResult;

@RestController
public class GaiKuangController {
	@Autowired
	private GaiKuangService gaiKuangService;

	@RequestMapping("/aaa")
	public JsonResult showData(
			String payTime
			,String payTime2) {
		List<OrderItem> tbOrderMasters=gaiKuangService.selectIncom(payTime, payTime2);
		return new JsonResult(tbOrderMasters);
	}
	@RequestMapping("/bbb")
	public JsonResult showJDL(String createTime
			,String createTime2) {
		Double showJDL = gaiKuangService.selectJDL(createTime, createTime2);
		return new JsonResult(showJDL);
	}

	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(
			RuntimeException e) {
		//输出异常栈中的信息
		e.printStackTrace();
		//封装异常信息
		return new JsonResult(e);
	}
}
