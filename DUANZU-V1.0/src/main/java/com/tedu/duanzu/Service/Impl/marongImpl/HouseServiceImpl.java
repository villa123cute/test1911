package com.tedu.duanzu.Service.Impl.marongImpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.ResolverUtil.Test;
//import org.omg.PortableInterceptor.TRANSPORT_RETRY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.tedu.duanzu.Dao.marongDao.HouseDao;
import com.tedu.duanzu.Service.marongService.HouseService;
import com.tedu.duanzu.common.ServiceException;
import com.tedu.duanzu.entity.FacilitiesServices;
import com.tedu.duanzu.entity.HouseDescription;
import com.tedu.duanzu.entity.HouseDetails;
import com.tedu.duanzu.entity.HouseLocation;
import com.tedu.duanzu.entity.HousePicture;
import com.tedu.duanzu.entity.HousePrice;
import com.tedu.duanzu.entity.vo.PageObject;



@Service
public class HouseServiceImpl implements HouseService
{  
	@Autowired
   HouseDao houseDao;
	
	public List<HouseLocation> findAll(Long masterPhone)
	{
		List<HouseLocation> houseList = houseDao.findAll(masterPhone);
		return  houseList;
	}

	@Override
	public int getRowCount(Long landlordId) {
		int rows = houseDao.getRowCount(landlordId);
		return rows;
	}

	@Override
	public PageObject<HouseLocation> findPageObjects(Long masterPhone, Integer pageCurrent) {
		 if(pageCurrent==null||pageCurrent<1)
			  throw new IllegalArgumentException("当前页码不正确");
			  //2.基于条件查询总记录数
			  //2.1) 执行查询
			  int rowCount=houseDao.getRowCount(masterPhone);
			  //2.2) 验证查询结果，假如结果为0不再执行如下操作
			  if(rowCount==0)
	          throw new ServiceException("系统没有查到对应记录");
			  //3.基于条件查询当前页记录(pageSize定义为2)
			  //3.1)定义pageSize
			  int pageSize=2;
			  //3.2)计算startIndex
			  int startIndex=(pageCurrent-1)*pageSize;
			  //3.3)执行当前数据的查询操作
			  List<HouseLocation> records=
					  houseDao.findPageObjects(masterPhone, startIndex, pageSize);
			  //4.对分页信息以及当前页记录进行封装
			  //4.1)构建PageObject对象
			  PageObject<HouseLocation> pageObject=new PageObject<>();
			  //4.2)封装数据
			  pageObject.setPageCurrent(pageCurrent);
			  pageObject.setPageSize(pageSize);
			  pageObject.setRowCount(rowCount);
			  pageObject.setRecords(records);
	          pageObject.setPageCount((rowCount-1)/pageSize+1);
			  //5.返回封装结果。
			  return pageObject;

	}
    
	@Transactional
	@Override
	public int insertHouse(HouseLocation house) {
		int rows=0;
		String threeLevelInkage = house.getThreeLevelInkage();
		if(StringUtils.isEmpty(threeLevelInkage))
			throw new IllegalArgumentException("地址不能为空");
		if(StringUtils.isEmpty(house.getStreetAddress()))
			throw new IllegalArgumentException("街道小区不能为空");
		if(StringUtils.isEmpty(house.getHouseNumber()))
			throw new IllegalArgumentException("门牌号不能为空");
		String threeLevelInkageString=house.getThreeLevelInkage();
		String[] arr = threeLevelInkageString.split("/");
		if(arr.length==2)
		{
			house.setHouseCity(arr[0]);
			house.setHarea(arr[1]);
			house.setHproper(arr[0]);
			house.setHouseAddress(arr[0]+arr[1]+house.getStreetAddress()+house.getHouseNumber());
		}else {
		house.setProvince(arr[0]);
		house.setHouseCity(house.getHproper());
		house.setHouseAddress(arr[0]+arr[1]+arr[2]+house.getStreetAddress()+house.getHouseNumber());
	    }
		
		if(StringUtils.isEmpty(house.getHouseId())) {
		  rows=houseDao.insertHouseLocation(house);
		}else {
			rows = houseDao.updateHouseLocation(house);
		}
		
		try {
			String streetAddress=house.getStreetAddress();
			String houseNumber=house.getHouseNumber();
			Integer landlordId=house.getLandlordId();
			int houseId = houseDao.findById(threeLevelInkageString, streetAddress, houseNumber, landlordId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("您已发布相同地址的房子!");
		}
		return rows;
}



	@Override
	public int findById(HouseLocation house) 
	{   
		Integer landlordId = house.getLandlordId();
		String streetAddress = house.getStreetAddress();
		String threeLevelInkage = house.getThreeLevelInkage();
		String houseNumber = house.getHouseNumber();
		int houseId = houseDao.findById(threeLevelInkage,streetAddress,houseNumber,landlordId);
		return houseId;
	}

	@Override
	public int updateHouseHouseDetails(HouseLocation house) {
		if(StringUtils.isEmpty(house.getFloorSpace()))
			throw new IllegalArgumentException("面积不能为空");
		if(StringUtils.isEmpty(house.getRentalMode()))
			throw new IllegalArgumentException("出租方式不能为空");
		if(StringUtils.isEmpty(house.getClass()))
			throw new IllegalArgumentException("房屋类型不能为空");
		if(StringUtils.isEmpty(house.getHouseType()))
			throw new IllegalArgumentException("房屋户型不能为空");
		if(StringUtils.isEmpty(house.getBedType()))
			throw new IllegalArgumentException("床型不能为空");
		int rows = houseDao.updateHouseHouseDetails(house);
		return rows;
	}
    
	@Override
	public int updateHouseDescription(HouseLocation  house) {
		if(StringUtils.isEmpty(house.getHouseName()))
			throw new IllegalArgumentException("房屋名称不能为空");
		if(StringUtils.isEmpty(house.getHouseFeature()))
			throw new IllegalArgumentException("房屋特色不能为空");
		int rows = houseDao.updateHouseDescription(house);
		return rows;
	}

	@Override
	public int insertFacilitiesServices(FacilitiesServices house)
	{   
		System.out.println(house.toString());
		Integer houseId = house.getId();
		FacilitiesServices facilitiesServices = houseDao.findFacilitiesServicesById(houseId);
		int rows=0;
		if(StringUtils.isEmpty(facilitiesServices)){
		rows = houseDao.insertFacilitiesServices(house);
		}else {
			rows = houseDao.updateFacilitiesServices(house);
		}
		return rows;
	}

	@Override
	public int insertPriceSetting(HousePrice house) {
		int rows=0;
		 Integer houseId = house.getHouseId();
		if(StringUtils.isEmpty(houseDao.findPriceSettingId(houseId))) {
		 rows = houseDao.insertPriceSetting(house);
		}else {
			rows = houseDao.updatePriceSetting(house);
		}
		return rows;
	}
    
	@Transactional(rollbackFor = Throwable.class)
	@Override
	public int doDeleteHouseLocation(Integer houseId) {
		int row1 = houseDao.doDeleteHouseLocation(houseId);
		int row2 =houseDao.doDeleteFacilitiesServices(houseId);
		int row3 =houseDao.doDeletePriceSetting(houseId);
	  if(row1==1 && row2==1 &&row3==1) {
		  return 1;
	  }else {
		  return 0;
	}
}

	@Override
	public int insertHousePicture(HousePicture housePicture) {
	      Integer houseId = housePicture.getHouseId();
	      String str=housePicture.getPicturePath();
	      housePicture.setPicturePath(str.substring(str.indexOf("<br/>")+5, str.lastIndexOf("<br/>"))); 
	      String className=housePicture.getClassName();
	      int rows=0;
	      if(StringUtils.isEmpty(houseDao.selectHousePictureById(houseId,className)))
	      {
	    	  rows = houseDao.insertHousePicture(housePicture);
	      }else {
	    	   rows = houseDao.updateHousePicture(housePicture);
	      }
		return rows;
	}


}
