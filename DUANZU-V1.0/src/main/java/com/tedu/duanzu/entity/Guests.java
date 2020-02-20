package com.tedu.duanzu.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Guests implements Serializable{
	private static final long serialVersionUID = -2612599253740826680L;
	/**宾客id*/
	private Integer guestId;
	/**宾客姓名*/
	private String realName;
	/**身份证号*/
	private String idCard;
	/**性别*/
	private String sex;
	/**备注*/
	private String comment;
	/**会员等级*/
	private String memberlevel;
	/**手机号码*/
	private Long phoneNumber;
	
	
	/** 入住時間*/
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	@JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )

	private Date checkInTime;
	/**最后入住时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date checkOutTime;
	
	
	/**房东ID*/
	private Integer landlordId;
}
