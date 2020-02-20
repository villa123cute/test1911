package com.tedu.duanzu.entity;

import lombok.Data;

@Data
public class Credentials {
	//编号
	private Integer id;
	//证件类型
	private String 	type;
	//姓名
	private String name;
	//身份证号
	private String IDnumber;
	//公司名
	private String company;
	//公司注册号
	private String companyNumber;
	
}
