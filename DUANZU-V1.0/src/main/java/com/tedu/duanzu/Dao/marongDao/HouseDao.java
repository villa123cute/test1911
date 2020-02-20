package com.tedu.duanzu.Dao.marongDao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tedu.duanzu.entity.FacilitiesServices;
import com.tedu.duanzu.entity.HouseDescription;
import com.tedu.duanzu.entity.HouseDetails;
import com.tedu.duanzu.entity.HouseLocation;
import com.tedu.duanzu.entity.HousePrice;
import com.tedu.duanzu.entity.HousePicture;

import lombok.Delegate;

@Mapper
public interface HouseDao {   
	 public List<HouseLocation> findAll(Long masterPhone);
	
 int getRowCount(@Param("landlordId") Long landlordId);
   
   List<HouseLocation> findPageObjects(
		      @Param("landlordId")Long landlordId,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);
   
   int insertHouseLocation(HouseLocation house);
   
   int updateHouseLocation(HouseLocation house);
   
   int updateHouseHouseDetails(HouseLocation house);
   
   int updateHouseDescription(HouseLocation house);
   
   int insertFacilitiesServices(FacilitiesServices house);
   
   int insertPriceSetting(HousePrice house);
   
   @Select("select house_id from tb_house_price where house_id=#{houseId}")
   Object findPriceSettingId(Integer houseId);
   
   int updatePriceSetting(HousePrice house);
   
   int updateFacilitiesServices(FacilitiesServices house);
   
   @Select("select * from tb_house_facilities_services where id=#{houseId} ")
   FacilitiesServices findFacilitiesServicesById(Integer houseId);
   
   @Delete("delete  from tb_house where house_id=#{houseId}")
    int doDeleteHouseLocation(Integer houseId);
   
   @Delete("delete  from tb_house_facilities_services where house_id=#{houseId}")
   int doDeleteFacilitiesServices(Integer houseId);
   
   @Delete("delete  from tb_house_price where house_id=#{houseId}")
   int doDeletePriceSetting(Integer houseId);
   
   int findById( 
		   @Param("threeLevelInkage")String threeLevelInkage,
		   @Param("streetAddress")String streetAddress,
		   @Param("houseNumber")String houseNumber,
		   @Param("landlordId")Integer landlordId
		   );
   
   int insertHousePicture(HousePicture housePicture);
   
   int updateHousePicture(HousePicture housePicture);
   
   @Select("select * from tb_house_picture where house_id=#{houseId} and class_name=#{className}")
   HousePicture selectHousePictureById(Integer houseId,String className);
   
}
