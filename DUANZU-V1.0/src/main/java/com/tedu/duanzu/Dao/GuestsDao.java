package com.tedu.duanzu.Dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tedu.duanzu.entity.Guests;

@Mapper
public interface GuestsDao {
	//通过客户端传过来的参数进行模糊查询
	public List<Guests> fandAll(Guests guests);
	
	//通过会员等级进行查询
	public List<Guests> member(@Param("landlordId")Integer landlordId,@Param("memberlevel")String memberlevel);
	
	//添加新的宾客
	public int Addbk(Guests guests);
	
	@Insert("insert into tb_landlord_member (id,landlord_id,guest_id) values (null,#{landlordId},#{guestId}) ")
	public int Addzj(Guests guests);
	
	
	int deleteObjects(Integer gusetId);
	
	
	@Select("select * from tb_guest where guest_id=#{guestId}")
	public Guests Select(Integer gusetId);
}
