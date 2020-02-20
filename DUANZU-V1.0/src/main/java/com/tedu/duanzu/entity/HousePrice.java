package com.tedu.duanzu.entity;

import java.util.List;

import lombok.Data;

@Data
public class HousePrice {
	private Integer houseId;
	private String houseName;
	private Double basePrice;
	private Double weekdayPrice;
	private Double weekendPrice;
	private Integer chargingMode;
	private String cleanMoney;      //清洁费
	private String peopleNumber;   //入住人数
	private String addPeopleMoney;  // 加人收费
	private Integer scheduledDays;   //入住天数
	private String  housingDeposit;          //是否收押金
	private Integer cancelDays;     //入住前多少天取消可全额退款
	private Double falsify;   //退款规则  50%
	private List<String> picPath;
	private List<HolidayPrice> prices;
	@Override
	public String toString() {
		String holidayPrice = "";
		if(prices!=null) {
			for (HolidayPrice price : prices) {
				holidayPrice = holidayPrice + price.toString();
			}
		}
		return "HousePrice [houseId=" + houseId + ", houseName=" + houseName + ", basePrice=" + basePrice
				+ ", weekdayPrice=" + weekdayPrice + ", weekendPrice=" + weekendPrice + ", chargingMode=" + chargingMode + ", picPath=" + picPath +  ", holidayPrice =" + holidayPrice + "]";
	}
}
