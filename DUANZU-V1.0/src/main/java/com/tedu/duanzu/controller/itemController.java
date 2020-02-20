package com.tedu.duanzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/tb/")
public class itemController {
	
	@RequestMapping("dingdan")
	public String select() {
		
		return "dingdan";
		
	}
}
