package com.tedu.duanzu.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Landlord implements Serializable{
	
	private static final long serialVerqwdsionUID = -7724292748370697094L;

	private Integer id;
	
	private String LandlordPath;
	
	private String nickname;
	
	private String houseArea;
	
	private String houseCity;
	
	private String welcoming;
	
	private String introduce;
	
	private Integer receiveForeignGuests;
	
	private Integer receiceLanguage;
	
	private Integer invoice;
	
	private Integer CreditDepositFree;
	
	private Integer DishonestTenant;
	
	private Integer stage;
	
	private MultipartFile files;

	private String MasterNumber;
	
	
	private String startTime;
	
	
	private String endTime;

	private String customerNumber;
	
	private String serviceNumber;
	
	private String serviceWork;
	
	private String serviceEmail;
	
}
