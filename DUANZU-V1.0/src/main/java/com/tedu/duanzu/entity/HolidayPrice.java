package com.tedu.duanzu.entity;

import lombok.Data;

@Data
public class HolidayPrice {
	private String holidayName;
	private Double price;
	@Override
	public String toString() {
		return "HolidayPrice [holidayName=" + holidayName + ", price=" + price + "]";
	}
}
