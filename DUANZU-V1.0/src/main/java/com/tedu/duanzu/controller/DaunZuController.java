package com.tedu.duanzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DaunZuController {
	@RequestMapping("{moduleUI}")
	public String doIndex(@PathVariable String moduleUI) {
		return moduleUI;
	}
	@RequestMapping("dingdan/{moduleUI}")
	public String doOrderUI(@PathVariable String moduleUI) {
		return "dingdan/"+moduleUI;
	}
	@RequestMapping("common/{moduleUI}")
	public String doCommonUI(@PathVariable String moduleUI) {
		return "common/"+moduleUI;
	}
	@RequestMapping("countPage/{moduleUI}")
	public String doPageUI(@PathVariable String moduleUI) {
		return "countPage/"+moduleUI;
	}
	@RequestMapping("gk/{moduleUI}")
	public String doGKUI(@PathVariable String moduleUI) {
		return "gk/"+moduleUI;
	}
	@RequestMapping("house/{moduleUI}")
	public String doHouseUI(@PathVariable String moduleUI) {
		return "house/"+moduleUI;
	}
}
