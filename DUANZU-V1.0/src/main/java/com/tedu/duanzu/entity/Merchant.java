package com.tedu.duanzu.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Merchant implements Serializable{
	private static final long serialVersionUID = -4253248692922561321L;
	//编号
	private Integer id;
	//证件类型
	private String 	type;
	//姓名
	private String name;
	//身份证号
	private String IDnumber;
	//身份证路径
	private String IDpath;//url
	//护照路径
	private String passportpath;
	//营业执照路径
	private String businesslicensepath;
	//接收图片
	private  MultipartFile[] files;
	
	private Integer status;
	
	
}