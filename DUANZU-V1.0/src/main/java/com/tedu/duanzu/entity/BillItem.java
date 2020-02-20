package com.tedu.duanzu.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;



public class BillItem {
	private Integer billId;
	private String billNumber;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date billDate;
	private Integer billAmount;
	private Double money;
	private Double brokerage;
	private Double income;
	private Integer status;
	// 
	//0220 jbj 5
	//  8 9 9 6
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date arrivalDate;
	private Integer landlordId;
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public Integer getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
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
	public String getStatus() {
		if(status==1) {
			return "宸茶浆璐�";
		}else if(status==2) {
			return "鏈浆璐�";
		}else if(status==3) {
			return "杞处澶辫触";
		}else {
			return "鏃犵姸鎬�";
		}
	}
	public void setStatus(int status) {
			this.status = status;	
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Integer getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(Integer landlordId) {
		this.landlordId = landlordId;
	}
	//。。
}
