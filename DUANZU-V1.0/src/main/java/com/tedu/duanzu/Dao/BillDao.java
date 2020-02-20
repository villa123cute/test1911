package com.tedu.duanzu.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.duanzu.entity.BillItem;
import com.tedu.duanzu.entity.LandlordInfo;
import com.tedu.duanzu.entity.LiquidateInfo;
import com.tedu.duanzu.entity.OrderInfo;

@Mapper
public interface BillDao {
	List<BillItem> findBillByStatus(Integer landlordId,Integer status,Integer startIndex,Integer pageSize);
	Integer getRowCount(Integer landlordId,Integer status);
	LandlordInfo findLandlordInfo(Integer landlordId);
	List<LiquidateInfo> findLiquidateInfo(String billNumber,Integer liquidateType);
	OrderInfo findOrderInfo();
}
