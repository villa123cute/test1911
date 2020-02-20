package com.tedu.duanzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class Page2Controller {
	@RequestMapping("index1")
	public String doIndexUI() {
		return "index1";
	}
	@RequestMapping("fupo")
	public String fupo() {
		return "login";
	}
	@RequestMapping("zhuce")
	public String zhuce() {
		return "zhuce";
	}
	@RequestMapping("fenye")
	public String fenye() {
		return "stores";
	}
}
