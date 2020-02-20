package com.tedu.duanzu.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.duanzu.Dao.PriceDao;
import com.tedu.duanzu.Service.PriceService;
import com.tedu.duanzu.common.ServiceException;
import com.tedu.duanzu.entity.HousePrice;

@Service
public class PriceServiceImpl implements PriceService{
	@Autowired
	PriceDao priceDao;
	@Override
	public List<HousePrice> findAllPrice(Integer landlordId){
		List<HousePrice> allPrice = priceDao.findAllPrice(landlordId);
		if(allPrice==null||allPrice.size()==0)throw new ServiceException("查找的房屋不存在");
		for (HousePrice housePrice : allPrice) {
			if(housePrice.getBasePrice()==null&&housePrice.getWeekdayPrice()==null&&housePrice.getWeekendPrice()==null&&housePrice.getPrices()==null)
				throw new ServiceException("房屋没有设置任何价格");
		}
		return allPrice;
	}
	@Override
	public Integer updatePrice(HousePrice housePrice) {
		// TODO Auto-generated method stub
		Integer row = priceDao.updatePrice(housePrice);
		if(row==null||row==0)throw new ServiceException("需要更新的数据可能不存在");
		return row;
	}
}
