package com.tedu.duanzu.Service;


import com.tedu.duanzu.entity.OrderItem;
import com.tedu.duanzu.entity.vo.PageObject;



public interface TbOrderItemService {
	PageObject<OrderItem> findDingDans(Integer landlordId,
			Integer pageCurrent);

	PageObject<OrderItem> findStatus(Integer landlordId,
			Integer affirmCancel,
			Integer pageCurrent);

	PageObject<OrderItem> findByStatus
	(Integer landlordId,Integer status,Integer pageCurrent);

	PageObject<OrderItem> findBytrade
	(Integer landlordId,Integer tradeStatus,Integer pageCurrent);
}
