package com.tedu.duanzu.Service;

import java.util.List;

import com.tedu.duanzu.common.vo.PageObject;
import com.tedu.duanzu.entity.BillItem;
import com.tedu.duanzu.entity.LandlordInfo;
import com.tedu.duanzu.entity.LiquidateInfo;

public interface BillService {
	PageObject<BillItem> findBillByStatus(Integer landlordId,Integer status,Integer pageCurrent);
	LandlordInfo findLandlordInfo(Integer landlordId);
	List<LiquidateInfo> findLiquidateInfo(String billNumber,Integer liquidateType);
}
