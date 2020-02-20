package com.tedu.duanzu.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tedu.duanzu.entity.OrderItem;

@Mapper
public interface GaiKuangDao {
	/**
	 * 基于房东id,时间段,查询总金额
	 * @param landlordId 房东id
	 * @param payTime 开始时间
	 * @param payTime2 结束时间
	 * @return
	 */
	List<OrderItem> selectIncom(@Param("landlordId")Integer landlordId,
			@Param("payTime")String payTime,
			@Param("payTime2")String payTime2);
	/**
	 * 基于房东id,时间段,查询总订单数
	 * @param landlordId
	 * @param createTime
	 * @param createTime2
	 * @return
	 */
	int selectSumRows(@Param("landlordId")Integer landlordId,
			@Param("createTime")String createTime,
			@Param("createTime2")String createTime2);
	/**
	 * 基于房东id,时间段,查询成功订单数
	 * @param landlordId
	 * @param payTime
	 * @param payTime2
	 * @return
	 */
	int selectRows(@Param("landlordId")Integer landlordId,
			@Param("payTime")String payTime,
			@Param("payTime2")String payTime2);
	
	
}
