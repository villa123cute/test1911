package com.tedu.duanzu.controller.marongController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.duanzu.Service.marongService.HouseService;
import com.tedu.duanzu.entity.HouseLocation;

@Controller
@RequestMapping("/")
public class pageController 
{  
	
	@Autowired
    HouseService houseService;
	
	@RequestMapping("HousingManagement")
   public String doFind()
   {
	   return "house/houseAdministration";
   }

    //房屋位置 HousingLocation
	@RequestMapping("doHousingLocation")
	public String toHousingLocation()
	{   
		return "house/HousingLocation";
	}
	//房屋详情 HousingDetails
	@RequestMapping("doHousingDetails")
	public String toHousingDetails()
	{   
		return "house/HousingDetails";
	}
	

	//房屋描述 HouseDescription
	@RequestMapping("doHouseDescription")
	public String toHouseDescription()
	{   
		
		return "house/HouseDescription";
	}
	//设施服务 FacilitiesServices
	@RequestMapping("doFacilitiesServices")
	public String toFacilitiesServices()
	{
		return "house/FacilitiesServices";
	}
	//入住规则 AdmissionRules
	@RequestMapping("doAdmissionRules")
	public String toAdmissionRules()
	{
		return "house/AdmissionRules";
	}
	//房屋照片  HousePhotos
	@RequestMapping("doHousePhotos")
	public String toHousePhotos()
	{
		return "house/HousePhotos";
	}
	//价格  PriceSetting
	@RequestMapping("doPriceSetting")
	public String toPriceSetting()
	{
		return "house/PriceSetting";
	}
	//身份验证  IdentityVerification
	@RequestMapping("doIdentityVerification")
	public String toIdentityVerification()
	{
		return "house/IdentityVerification";
	}
	
	
	
	
	
	
	
	
	 //房屋位置 HousingLocation
		@RequestMapping("doUpdateHousingLocation")
		public String toUpdateHousingLocation()
		{   
			return "updateHouse/UpdateHousingLocation";
		}
		//房屋详情 HousingDetails
		@RequestMapping("doUpdateHousingDetails")
		public String toUpdateHousingDetails()
		{   
			return "updateHouse/UpdateHousingDetails";
		}
		

		//房屋描述 HouseDescription
		@RequestMapping("doUpdateHouseDescription")
		public String toUpdateHouseDescription()
		{   
			
			return "updateHouse/UpdateHouseDescription";
		}
		//设施服务 FacilitiesServices
		@RequestMapping("doUpdateFacilitiesServices")
		public String toUpdateFacilitiesServices()
		{
			return "updateHouse/UpdateFacilitiesServices";
		}
		//入住规则 AdmissionRules
		@RequestMapping("doUpdateAdmissionRules")
		public String toUpdateAdmissionRules()
		{
			return "updateHouse/UpdateAdmissionRules";
		}
		//房屋照片  HousePhotos
		@RequestMapping("doUpdateHousePhotos")
		public String toUpdateHousePhotos()
		{
			return "updateHouse/UpdateHousePhotos";
		}
		//价格  PriceSetting
		@RequestMapping("doUpdatePriceSetting")
		public String toUpdatePriceSetting()
		{
			return "updateHouse/UpdatePriceSetting";
		}
		//身份验证  IdentityVerification
		@RequestMapping("doUpdateIdentityVerification")
		public String toUpdateIdentityVerification()
		{
			return "updateHouse/UpdateIdentityVerification";
		}
		
}
