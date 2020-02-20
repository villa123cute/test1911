package com.tedu.duanzu.Service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.duanzu.Dao.MerchantDao;
import com.tedu.duanzu.Service.MerchantService;
import com.tedu.duanzu.entity.Merchant;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class MerchantServiceImpl implements MerchantService{
	
	@Autowired
	private MerchantDao merchantDao;

	@Override
	public int saveObject(Merchant entity, MultipartFile[] upload,HttpServletRequest req) {
		//1参数有效性校验
				if(entity==null)
					throw new IllegalArgumentException("保存对象不能为空");
				if(StringUtils.isEmpty(entity.getName()))
					throw new IllegalArgumentException("商户名不能为空");
				int i = 0;
				for(MultipartFile file : upload) {
					String imgUrl  = uploadFile(file,req);
					System.out.println(imgUrl);
					if(i == 0) {
						entity.setIDpath(imgUrl);
					}
					if(i == 1) {
						entity.setPassportpath(imgUrl);
					}else {
						entity.setBusinesslicensepath(imgUrl);
					}
					i++;
						
				}
				//2保存角色自身信息
				int rows = merchantDao.insertObject(entity);
				return rows;
	}
	public String uploadFile(MultipartFile file,HttpServletRequest req) {
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		//获取文件的扩展名
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		//设置图片上传路径
		//String url = req.getSession().getServletContext().getRealPath("/upload");
		String url = "C:/upload";
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
	@Override
	public Merchant findMerchantByID(String landlord_id) {
		Merchant m = merchantDao.findMerchantByID(landlord_id);
		return m;
	}

}
