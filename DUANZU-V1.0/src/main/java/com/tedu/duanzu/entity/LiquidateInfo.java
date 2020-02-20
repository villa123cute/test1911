package com.tedu.duanzu.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class LiquidateInfo {
	private Integer liquidateId;
	private String liquidateNumber;
	//0-房费结算，1-押金扣款，2-调整单
	private Integer liquidateType;
	private String orderNumber;
	private OrderInfo orderInfo;
	private Double money;
	private Double brokerage;
	private Double income;
	//0-线上支付，1-线下支付
	private Integer payType;
	//1-未转账，2-已转账，3-转账失败
	private Integer payStatus;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date payDate;
	public Integer getLiquidateId() {
		return liquidateId;
	}
	public void setLiquidateId(Integer liquidateId) {
		this.liquidateId = liquidateId;
	}
	public String getLiquidateNumber() {
		return liquidateNumber;
	}
	public void setLiquidateNumber(String liquidateNumber) {
		this.liquidateNumber = liquidateNumber;
	}
	public String getLiquidateType() {
		if(liquidateType==0) {
			return "房费结算";
		}else if(liquidateType==1) {
			return "押金扣款";
		}else if(liquidateType==2) {
			return "调整单";
		}
		return null;
	}
	public void setLiquidateType(Integer liquidateType) {
		this.liquidateType = liquidateType;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Double getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(Double brokerage) {
		this.brokerage = brokerage;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public String getPayType() {
		if(payType==0) {
			return "线上支付";
		}else if(payType==1) {
			return "线下支付";
		}
		return null;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getPayStatus() {
		if(payStatus==1) {
			return "未转账";
		}else if(payStatus==2) {
			return "已转账";
		}else if(payStatus==3) {
			return "转账失败";
		}
		return null;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
}
