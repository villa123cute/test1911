package com.tedu.duanzu.entity;

import lombok.Data;

@Data
public class regtister {
	//昵称
	private String nickname;
	//密码
	private String password;
	//邮箱
	private String serviceEmail;
	//手机号码 
	private String MasterNumber;
	//盐值 
	private String salt;
	 
}
