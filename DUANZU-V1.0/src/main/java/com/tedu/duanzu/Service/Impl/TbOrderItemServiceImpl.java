package com.tedu.duanzu.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.duanzu.Dao.TbOrderItemDao;
import com.tedu.duanzu.Service.TbOrderItemService;
import com.tedu.duanzu.common.ServiceException;
import com.tedu.duanzu.common.config.PageProperties;
import com.tedu.duanzu.entity.DingDan;
import com.tedu.duanzu.entity.OrderItem;
import com.tedu.duanzu.entity.vo.PageObject;
@Service
public class TbOrderItemServiceImpl implements TbOrderItemService {
	@Autowired
	private TbOrderItemDao tbOrderItemDao;
	@Autowired
	private PageProperties pageProperties; 
	@Override
	public PageObject<OrderItem> findDingDans(Integer landlordId, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("传的页面不正确");
		int rowCount = tbOrderItemDao.findById2(landlordId);
		if(rowCount==0)
			throw new ServiceException("查的记录不存在");
		int pageSize=pageProperties.getPageSize();
		int startIndex=(pageCurrent-1)*pageSize;
		List<OrderItem> records =tbOrderItemDao.findDingDans(landlordId, startIndex, pageSize);
		System.out.println(records);
		return new PageObject<>(records, pageCurrent, pageSize, rowCount);


	}
	@Override
	public PageObject<OrderItem> findStatus(Integer landlordId, Integer affirmCancel, Integer pageCurrent) {
		//判断页面请求页是否出错
		if(pageCurrent==null||pageCurrent<1)throw new IllegalArgumentException("页面请求不正确");
		int rowCount = tbOrderItemDao.findById("landlord_id", landlordId,"affirm_cancel",affirmCancel);
		//判断记录是否存在
		if(rowCount==0)throw new ServiceException("没有数据了");
		int pageSize =  pageProperties.getPageSize();
		//求出起始下标
		int startIndex=(pageCurrent-1)*pageSize;
		List<OrderItem> records = tbOrderItemDao.findStatus(landlordId, affirmCancel, startIndex, pageSize);
		//封装
		return new PageObject<>(records, pageCurrent, pageSize, rowCount);
	}
	@Override
	public PageObject<OrderItem> findByStatus(Integer landlordId, Integer status, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页面不正确");
		int rowCount =tbOrderItemDao.findById("landlord_id", landlordId,"status",status);
		if(rowCount==0)throw new ServiceException("记录不存在");
		int pageSize=pageProperties.getPageSize();
		int startIndex=(pageCurrent-1)*pageSize;
		List<OrderItem> records = tbOrderItemDao.findByStatus(landlordId, status, startIndex, pageSize);
		System.out.println("records"+records);
		return new PageObject<>(records, pageCurrent, pageSize, rowCount);
	}
	@Override
	public PageObject<OrderItem> findBytrade(Integer landlordId, Integer tradeStatus, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页面不正确");
		int rowCount = tbOrderItemDao.findById("landlord_id", landlordId,"trade_status",tradeStatus);
		if(rowCount==0)throw new ServiceException("记录不存在");
		int pageSize=pageProperties.getPageSize();
		int startIndex=(pageCurrent-1)*pageSize;
		List<OrderItem> records = tbOrderItemDao.findBytrade(landlordId, tradeStatus, startIndex, pageSize);
		return new PageObject<>(records, pageCurrent, pageSize, rowCount);
	}



}
