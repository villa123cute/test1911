package com.tedu.duanzu.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.duanzu.Dao.BillDao;
import com.tedu.duanzu.Service.BillService;
import com.tedu.duanzu.common.ServiceException;
import com.tedu.duanzu.common.vo.PageObject;
import com.tedu.duanzu.entity.BillItem;
import com.tedu.duanzu.entity.LandlordInfo;
import com.tedu.duanzu.entity.LiquidateInfo;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	BillDao billDao;

	@Override
	public PageObject<BillItem> findBillByStatus(Integer landlordId,Integer status,Integer pageCurrent) {
		int pageSize = 6;
		if(pageCurrent==null||pageCurrent<1)
			  throw new IllegalArgumentException("当前页码不正确");
		Integer rowCount = billDao.getRowCount(landlordId,status);
		if(rowCount==0)
			  throw new ServiceException("系统没有查到对应记录");
		int startIndex=(pageCurrent-1)*pageSize;
		List<BillItem> records = billDao.findBillByStatus(landlordId,status,startIndex,pageSize);
		if(records==null||records.size()==0) {
			throw new ServiceException("可能没有需要查找的数据");
		}
		PageObject<BillItem> pageObject = new PageObject<BillItem>(records,pageCurrent,pageSize,rowCount);
		return pageObject;
	}

	@Override
	public LandlordInfo findLandlordInfo(Integer landlordId) {
		// TODO Auto-generated method stub
		LandlordInfo findLandlordInfo = billDao.findLandlordInfo(landlordId);
		if(findLandlordInfo==null)
			throw new ServiceException("没有请求的商户数据，请维护相关信息");
		return findLandlordInfo;
	}

	@Override
	public List<LiquidateInfo> findLiquidateInfo(String billNumber,Integer liquidateType) {
		// TODO Auto-generated method stub
		List<LiquidateInfo> findLiquidateInfo = billDao.findLiquidateInfo(billNumber,liquidateType);
		if(findLiquidateInfo==null)
			throw new ServiceException("没有请求到相关的结算单数据");
		return findLiquidateInfo;
	}
	
}
