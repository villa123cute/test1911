package com.tedu.duanzu.entity;

import lombok.Data;

@Data
public class MerchantManage {
	//编号
	private Integer id;
	//银行卡
	private String BankCard;
	//个人账号、企业账号
	private String AccountNumber;
	//商户名称
	private String MerchantName;
	//开户银行
	private String BankName;
	//开户城市
	private String OpenCity;
	//开户支行
	private String BankBranch;
	//银行账号
	private String BankAccount;
	//公私类型
	private String NumberType;
	//开户姓名
	private String OwnerName;
	//按天结算、按月结算
	private String AccountTime;
	//联系电话
	private String OwnerPhone;
}
