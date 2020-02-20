package com.tedu.duanzu.controller.marongController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


import javax.servlet.http.HttpServletRequest;
import javax.swing.JEditorPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.duanzu.Service.marongService.HouseService;
import com.tedu.duanzu.entity.FacilitiesServices;
import com.tedu.duanzu.entity.HouseLocation;
import com.tedu.duanzu.entity.HousePicture;
import com.tedu.duanzu.entity.HousePrice;
import com.tedu.duanzu.entity.vo.JsonResult;


@RestController
@RequestMapping("/house/")
public class HouseController 
{    
	@Autowired
     HouseService houseService;
	
   @RequestMapping("doFindAll")
   public List<HouseLocation> findAll(Model model,Long landlordId)
   {
	   List<HouseLocation> list = houseService.findAll(landlordId);
	   model.addAttribute("HouseList",list);
	   return list;
   }
    
   @RequestMapping("selectHouseCount")
    public int selectHouseCount(Long landlordId)
    {   
    	int count = houseService.getRowCount(landlordId);
    	return count;
    }
   
   @RequestMapping("saveHouse")
   public JsonResult insertHouse(HouseLocation house)
   {   
	   int rows=houseService.insertHouse(house);
	   return new JsonResult("提交成功!");
   }
   
	
    @RequestMapping("updateHouseDetails") 
    public JsonResult insertHouseDetails(HouseLocation house) { 
	int rows=houseService.updateHouseHouseDetails(house);
	 return new JsonResult("提交成功"); }
    
    @RequestMapping("updateHouseDescription") 
    public JsonResult insertHouseHouseDescription (HouseLocation  house) { 
	int rows=houseService.updateHouseDescription(house);
	 return new JsonResult("提交成功"); }
	
    @RequestMapping("doInsertFacilitiesServices")
   public JsonResult doInsertFacilitiesServices(FacilitiesServices house)
   {
	   int rows = houseService.insertFacilitiesServices(house);
	   return new JsonResult("提交成功");
   }
    
    @RequestMapping("doUpdateSettingPrice")
    public JsonResult doUpdateSettingPrice(HousePrice house)
    {   
    	int rows = houseService.insertPriceSetting(house);
    	return new JsonResult("提交成功");
    }
    
   @RequestMapping("doFindById")
   public JsonResult findById(HouseLocation house)
	{ 
		int houseId = houseService.findById(house);
	   return new JsonResult(houseId);
   }
   
   @RequestMapping("doDeleteObject")
   public JsonResult dodeleteObject(Integer houseId)
   {   
	   int rows = houseService.doDeleteHouseLocation(houseId);
	   return new JsonResult(rows);
   }
   
   @RequestMapping("doInsertHousePicture")
   public JsonResult doInsertPicture(HousePicture housePicture) {
	  int rows = houseService.insertHousePicture(housePicture);
	  return new JsonResult(rows);
   }
  
}
