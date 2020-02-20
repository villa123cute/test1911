package com.tedu.duanzu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.duanzu.Service.MerchantService;
import com.tedu.duanzu.entity.Merchant;
import com.tedu.duanzu.entity.vo.JsonResult;

@RestController
@RequestMapping("/business/")
public class MerchantController {
	
	@Autowired
	private MerchantService merchantService;
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(@ModelAttribute Merchant form,HttpServletRequest req) {
		System.out.println(form);
		System.out.println(form.getName());
		System.out.println(form.getFiles());
		merchantService.saveObject(form,form.getFiles(),req);
		return new JsonResult("save ok");
	}
	@RequestMapping("getDetails")
	public JsonResult getDetails(String userid) {
		Merchant m = merchantService.findMerchantByID(userid);
		System.out.println(m);
		return new JsonResult(m);
	}
}
