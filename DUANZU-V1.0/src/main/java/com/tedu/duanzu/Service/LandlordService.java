package com.tedu.duanzu.Service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.tedu.duanzu.entity.Landlord;

public interface LandlordService {

	int saveObject(MultipartFile file,Landlord lord);
	
	int updateObject(Landlord entity);
	
    List<Map<String,Object>> findObject();



}
