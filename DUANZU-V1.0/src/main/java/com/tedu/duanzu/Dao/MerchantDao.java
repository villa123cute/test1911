package com.tedu.duanzu.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.duanzu.entity.Merchant;

@Mapper
public interface MerchantDao {
	
	/**负责将商家审核成功后的信息写入到数据库*/
	@Insert("insert into tb_business(type,name,IDnumber,ID_path,passport_path,businesslicense_path)"
			+ " values(#{type},#{name},#{IDnumber},#{IDpath},#{passportpath},#{businesslicensepath})")
	int insertObject( Merchant entity);
	
	Merchant findMerchantByID(String landlord_id);
}
