package com.tedu.duanzu.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.tedu.duanzu.entity.OrderItem;



@Mapper
public interface TbOrderItemDao extends BaseDao{

	int findById2(Integer landlordId);
	List<OrderItem> findDingDans(
			@Param("landlordId")Integer landlordId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);

	String findName(@Param("house_id") Integer house_id);
	String findPic(@Param("house_id") Integer house_id);

	
	
	List<OrderItem> findStatus( @Param("landlordId") Integer landlordId,
			@Param("affirmCancel")Integer affirmCancel,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);

	
	List<OrderItem>	findByStatus(@Param("landlordId")Integer landlordId,
			@Param("status")Integer status,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);


	
	
	List<OrderItem>	findBytrade(@Param("landlordId")Integer landlordId,
			@Param("tradeStatus")Integer tradeStatus,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);


}
