package com.tedu.duanzu.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.duanzu.entity.regtister;

@Mapper
public interface registerDao {
	int registerInset(regtister reg);
	
	regtister findByName(String username);
}
