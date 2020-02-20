package com.tedu.duanzu.Service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.tedu.duanzu.Dao.LandlordDao;
import com.tedu.duanzu.Service.LandlordService;
import com.tedu.duanzu.common.ServiceException;
import com.tedu.duanzu.entity.Landlord;
import io.micrometer.core.instrument.util.StringUtils;

@Service
public class LandlordServiceImpl implements LandlordService {
	@Autowired
	private LandlordDao landlordDao;
	

	@Override
	public int updateObject(Landlord entity) {
		if(entity==null)
			throw new IllegalArgumentException("保存不能为空");
		if(StringUtils.isEmpty(entity.getNickname()))
			throw new IllegalArgumentException("房东昵称不能为空");
		int rows = landlordDao.updateObject(entity);
		return rows;
	}

	@Override
	public List<Map<String, Object>> findObject() {
		List<Map<String, Object>> list = 
				landlordDao.findObjects();
		if(list==null||list.size()==0)
			throw new ServiceException("数据不存在");
		return list;
	}

	@Override
	public int saveObject(MultipartFile file, Landlord lord) {
		lord.setLandlordPath(uploadFile(file));
		int row = landlordDao.insertObject(lord);
		return row;
	}
	
	public String uploadFile(MultipartFile file) {
		  String name = UUID.randomUUID().toString().replaceAll("-", "");
		  //获取文件的扩展名
		  String ext = file.getOriginalFilename();
		 
		  String url = "D:/upload";
		  //以绝对路径保存重名命后的图片
		  try {
		   file.transferTo(new File(url+"/"+name + "." + ext));
		  } catch (IllegalStateException e) {
		   e.printStackTrace();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  //把图片存储路径保存到数据库
		  String imgUrl = "/"+name + "." + ext;
		  return imgUrl;

		 }

		}

	

