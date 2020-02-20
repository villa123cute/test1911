package com.tedu.duanzu.entity;

import java.util.Date;

import lombok.Data;
@Data
public class OrderMaster {

	//订单id
	private Integer orderId;
	//订单号
	private String orderNumber;
	//交易状态1成功2失败
	private Integer tradeStatus;
	//订单状态0取消，1确定，2离店
	private Integer orderStatus;
	//订单金额
	private Double orderPrice;
	//付款金额
	private Double payPrice;
	//订单创建时间
	private Date createTime;
	//订单支付时间
	private Date payTime;


	
}
