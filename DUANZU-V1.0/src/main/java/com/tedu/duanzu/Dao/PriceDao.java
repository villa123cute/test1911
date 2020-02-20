package com.tedu.duanzu.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tedu.duanzu.entity.HolidayPrice;
import com.tedu.duanzu.entity.HousePrice;

@Mapper
public interface PriceDao {
	List<HousePrice> findAllPrice(@Param("landlordId")Integer landlordId);
	List<HolidayPrice> findHolidayPrice(@Param("houseId")Integer houseId);
	String findPic(@Param("houseId")Integer houseId);
	Integer updatePrice(HousePrice housePrice);
}
