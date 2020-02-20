package com.tedu.duanzu.entity;

import lombok.Data;

@Data
public class HouseDetails 
{    
	 private Integer id; 
	
	 private String rentalMode;      //出租方式
	 
	 private String houseClass;    //房屋类型     公寓或酒店
	 
	 private Integer floorSpace;   //面积
	 
	 private String ambitus;   //环境
	 
	 private String houseType;    //户型!四室三厅
	 
	 private String bedType;     //大床?上下铺?
}
