package com.tedu.duanzu.Service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.tedu.duanzu.entity.Merchant;

public interface MerchantService {
	
	/**保存商户数据*/
	int saveObject(Merchant entity,MultipartFile[] upload,HttpServletRequest req);
	Merchant findMerchantByID(String landlod_id);
}
