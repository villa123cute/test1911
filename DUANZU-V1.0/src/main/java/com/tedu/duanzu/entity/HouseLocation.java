package com.tedu.duanzu.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class HouseLocation 
{
   private Integer houseId;
   
   private Integer landlordId; //房东ID   1
   
   private String province;   //省份
   
   private String hproper;    // 台州市  1

   private String houseCity;   //城市: 拉萨市 1 
   
   private String  harea;        //区:  岳麓区  XX县  1

   private String streetAddress;    //街道地址:  望城坡街道   1
   
   private String houseAddress;     //房屋地址: 长沙市岳麓区达美D6   1
   
   private String  threeLevelInkage;   //三级联动:湖南省岳麓区望城坡街道  1

  // private  Long masterPhone;    //老板电话  1

  // private Boolean leaseWay;   //租赁方式   1

 //  private Integer peopleNumber;  //人数  1

   private String houseNumber;   //门牌号  1

  // private Boolean togetherStatus;    //共同地位  1

   private String status;   //已上架?  1
   
   private Date  houseTime;  //家庭时间  1

  // private String landlordName;   //房东姓名    1
   
   private String state;               //房屋状态:已发布? 1
   
   private String additionalExplanation;       //补充说明  1
   
   
  
  
   //details
   private String rentalMode;      //出租方式  
	 
	 private String houseClass;    //房屋类型     公寓或酒店    1
	 
	 private Integer floorSpace;   //面积  1
	 
	 private String ambitus;     //环境  1
	 
	 private String houseType;    //户型!四室三厅  1
	 
	 private String bedType;     //大床?上下铺?  1
	 
	 //descrition
     private String houseName;  //房屋名称:  富基世纪公园            1
	 
	 private String houseFeature;   //房屋特色  1
	 
	 private String position;   //位置  1
	 
	 private String PeripheralIntroduction;  //其他
	 
}
