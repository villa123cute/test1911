package com.tedu.duanzu.Service.marongService;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tedu.duanzu.entity.FacilitiesServices;
import com.tedu.duanzu.entity.HouseDescription;
import com.tedu.duanzu.entity.HouseDetails;
import com.tedu.duanzu.entity.HouseLocation;
import com.tedu.duanzu.entity.HousePicture;
import com.tedu.duanzu.entity.HousePrice;
import com.tedu.duanzu.entity.vo.PageObject;



public interface HouseService 
{
	 public List<HouseLocation> findAll(Long masterPhone);
	 
	 public int getRowCount(Long landlordId);
	 
	 
	 PageObject<HouseLocation> findPageObjects(
			 Long masterPhone,
			 Integer pageCurrent);
   
	 public int insertHouse(HouseLocation house);
	 
	 int updateHouseHouseDetails(HouseLocation house);
	 
	 int updateHouseDescription(HouseLocation  house);
	 
	 int insertFacilitiesServices(FacilitiesServices house);
	 
	 int insertPriceSetting(HousePrice house);
	 
	 int findById(HouseLocation house);
	 
	  int doDeleteHouseLocation(Integer houseId);
	  
	 int  insertHousePicture (HousePicture housePicture);
}
