package com.tedu.duanzu.entity;

import lombok.Data;

@Data
public class FacilitiesServices 
{
  private Integer id;
  
  private String equipment;            //居家设备
  
  private String  sanitaryEquipment;   //卫浴设备
  
  private String kitchenEquipment;  //餐厨设备
	
  private String  entertainmentEquipment;  //娱乐设备

  private String safetyEquipment;   //安全设备
  
  private String buildingEquipment;  //建筑设备
  
  private String  peripheralEquipment;  //周边设备
  
  private String otherServices;  //其他服务
}
