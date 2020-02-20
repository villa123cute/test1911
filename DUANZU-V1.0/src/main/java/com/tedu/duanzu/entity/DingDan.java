package com.tedu.duanzu.entity;

import java.util.Date;

import lombok.Data;


@Data
public class DingDan {

	
	//订单详情id
	private Integer itemId;
	//房屋名称
	private String houseName;
	//房东id
	private Integer landlordId;
	//入住人id
	private Integer lodgerId;
	//预定开始时间
	private Date reservationStart;
	//预定结束时间
	private Date reservationEnd;
	//预定套数
	private Integer houseNumber;
	//总房费
	private Double grossPrice;
	//押金信息
	private Integer tradeStatus;
	

}
