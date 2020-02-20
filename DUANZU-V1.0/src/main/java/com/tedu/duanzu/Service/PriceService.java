package com.tedu.duanzu.Service;

import java.util.List;

import com.tedu.duanzu.entity.HousePrice;

public interface PriceService {
	List<HousePrice> findAllPrice(Integer landlordId);
	Integer updatePrice(HousePrice housePrice);
}
