package com.tedu.duanzu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tedu.duanzu.Service.LandlordService;
import com.tedu.duanzu.entity.Landlord;
import com.tedu.duanzu.entity.vo.JsonResult;

@JsonFormat
@Controller
@RequestMapping("/landlord/")
public class LandlordController {
	@Autowired
	private LandlordService landlordService; 
	
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(Landlord entity) {
		int rows = landlordService.updateObject(entity);
		return new JsonResult(rows) ;
	}
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
	return new JsonResult(landlordService.findObject());
		
	}
	
	@RequestMapping("qwer")
	@ResponseBody
	public JsonResult a(Landlord land) {
		System.out.println("land："+land);
	     return new JsonResult("update ok");
	}
	@RequestMapping("fileUpload")
	@ResponseBody
	public JsonResult saveImg(@ModelAttribute Landlord lord) {
		System.out.println("WOSHISHUI:"+lord.toString());
		int rows = landlordService.saveObject(lord.getFiles(),lord);
	
		return new JsonResult("ok");
		
		
	}
	

}
