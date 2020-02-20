package com.tedu.duanzu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;



public class OrderItem implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2044989913646369560L;

	//订单详情id
	private Integer itemId;
	
	//订单表id
	private String orderId;
	
	//唯一订单id
	private String orderNumber;
	
	//预定人id
	private Integer bespeakId;
	
	//入住人id
	private Integer lodgerId;
	//入住人名
	private String lodger;
	
	//入住人数
	private Integer lodgerNumber;
	
	//房屋id
	private Integer houseId;
	//图片路径
	private List<String> picturePath;
	//房屋名称
	private String houseName;
	
	
	//预定房屋数量
	private Integer houseNumber;
	
	//预定开始时间
	@JsonFormat(
	        pattern = "yyyy-MM-dd HH:mm:ss",
	        timezone = "GMT+8"
	)
	private Date reservationStart;
	
	//预定结束时间
	@JsonFormat(
	        pattern = "yyyy-MM-dd HH:mm:ss",
	        timezone = "GMT+8"
	)
	private Date reservationEnd;
	
	//预定天数
	private Integer reservationDay;
	
	//总金额
	private Double grossPrice;
	
	//交易状态0未缴费，1,已交定金,2已交押金，3已付清
	private Integer tradeStatus;
	
	//评分
	private Integer score;
	
	//评论
	private String comment;
	//订单支付时间
	@JsonFormat(
	        pattern = "yyyy-MM-dd HH:mm:ss",
	        timezone = "GMT+8"
	)
	private Date payTime;
	//订单创建时间
	@JsonFormat(
	        pattern = "yyyy-MM-dd HH:mm:ss",
	        timezone = "GMT+8"
	)
	private Date createTime;
	//入住信息1 待入住 2已入住 3已离店
	private Integer status;
	//是/否确认 1确认 2待确认 3已取消
	private Integer affirmCancel;
	//入住时间
	@JsonFormat(
	        pattern = "yyyy-MM-dd HH:mm:ss",
	        timezone = "GMT+8"
	)
	private Date CheckInTime;
	//离店时间
	@JsonFormat(
	        pattern = "yyyy-MM-dd HH:mm:ss",
	        timezone = "GMT+8"
	)
	private Date CheckOutTime;
	
	
	public String getLodger() {
		return lodger;
	}
	public void setLodger(String lodger) {
		this.lodger = lodger;
	}
	public List<String> getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(List<String> picturePath) {
		this.picturePath = picturePath;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getBespeakId() {
		return bespeakId;
	}
	public void setBespeakId(Integer bespeakId) {
		this.bespeakId = bespeakId;
	}
	public Integer getLodgerId() {
		return lodgerId;
	}
	public void setLodgerId(Integer lodgerId) {
		this.lodgerId = lodgerId;
	}
	public Integer getLodgerNumber() {
		return lodgerNumber;
	}
	public void setLodgerNumber(Integer lodgerNumber) {
		this.lodgerNumber = lodgerNumber;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public Integer getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Date getReservationStart() {
		return reservationStart;
	}
	public void setReservationStart(Date reservationStart) {
		this.reservationStart = reservationStart;
	}
	public Date getReservationEnd() {
		return reservationEnd;
	}
	public void setReservationEnd(Date reservationEnd) {
		this.reservationEnd = reservationEnd;
	}
	public Integer getReservationDay() {
		return reservationDay;
	}
	public void setReservationDay(Integer reservationDay) {
		this.reservationDay = reservationDay;
	}
	public Double getGrossPrice() {
		return grossPrice;
	}
	public void setGrossPrice(Double grossPrice) {
		this.grossPrice = grossPrice;
	}
	public String getTradeStatus() {
		if(tradeStatus==0) {
			return "未缴费";
		}else if(tradeStatus==1) {
			return "已交定金";
		}else if(tradeStatus==2) {
			return "已交押金";
		}else {
			return "已付清";
		}
	}
	public void setTradeStatus(Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		if(status==1) {
			return "待入住";
		}else if(status==2) {
			return "已入住";
		}else {
			return "已离店";
		}
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAffirmCancel() {
		if(affirmCancel==1) {
			return "确认";
		}else if(affirmCancel==2) {
			return "已确认";
		}else {
			return "已取消";
	}
		}
	public void setAffirmCancel(Integer affirmCancel) {
		this.affirmCancel = affirmCancel;
	}
	public Date getCheckInTime() {
		return CheckInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		CheckInTime = checkInTime;
	}
	public Date getCheckOutTime() {
		return CheckOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		CheckOutTime = checkOutTime;
	}
	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", orderId=" + orderId + ", orderNumber=" + orderNumber + ", bespeakId="
				+ bespeakId + ", lodgerId=" + lodgerId + ", lodger=" + lodger + ", lodgerNumber=" + lodgerNumber
				+ ", houseId=" + houseId + ", picturePath=" + picturePath + ", houseName=" + houseName
				+ ", houseNumber=" + houseNumber + ", reservationStart=" + reservationStart + ", reservationEnd="
				+ reservationEnd + ", reservationDay=" + reservationDay + ", grossPrice=" + grossPrice
				+ ", tradeStatus=" + tradeStatus + ", score=" + score + ", comment=" + comment + ", payTime=" + payTime
				+ ", createTime=" + createTime + ", status=" + status + ", affirmCancel=" + affirmCancel
				+ ", CheckInTime=" + CheckInTime + ", CheckOutTime=" + CheckOutTime + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}