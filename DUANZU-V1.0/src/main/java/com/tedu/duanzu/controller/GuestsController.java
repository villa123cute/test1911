package com.tedu.duanzu.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.duanzu.Service.GuestsService;
import com.tedu.duanzu.entity.Guests;
import com.tedu.duanzu.entity.vo.JsonResult;

@RestController
@RequestMapping("/guest/")
public class GuestsController {
	@Autowired
	private GuestsService guestsService;
	
	
	@RequestMapping("fandAll")
	public JsonResult fandAll(Guests guests) {
		List<Guests> fd = guestsService.fandAll(guests);
		return new JsonResult(fd);
	}
	@RequestMapping("member")
	public JsonResult member(Integer landlordId,String memberlevel){
		
		return new JsonResult(guestsService.member(landlordId, memberlevel));
		
	}
	
	
	@RequestMapping("inset")
	public JsonResult inset(Guests guests) {
		guestsService.Addbkk(guests);
		
		return new JsonResult("添加OK");
		
	}
	
	@RequestMapping("doDeleteObjects")
	public JsonResult deleteObjects(Integer guestId) {
		guestsService.deleteObjects(guestId);
		return new JsonResult("删除成功");
		
	}
	@RequestMapping("select")
	public JsonResult select(Integer gusetId) {
		
		return new JsonResult(guestsService.Select(gusetId));
	}
}
