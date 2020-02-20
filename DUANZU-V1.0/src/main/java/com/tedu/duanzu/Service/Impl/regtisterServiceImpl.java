package com.tedu.duanzu.Service.Impl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tedu.duanzu.Dao.registerDao;
import com.tedu.duanzu.Service.regtisterService;
import com.tedu.duanzu.entity.regtister;
@Service
public class regtisterServiceImpl implements regtisterService{
	@Autowired
	private registerDao regtisterDao ;

	@Override
	public int registerInset(regtister reg) {
		if(StringUtils.isEmpty(reg.getNickname()))throw new IllegalArgumentException("账户不能为空");
		if(StringUtils.isEmpty(reg.getPassword()))throw new IllegalArgumentException("密码不能为空");
		String salt=UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5",
							reg.getPassword(),
										salt,
										1);
		String password = sh.toHex();//转换为16进制
		reg.setPassword(password);
		reg.setSalt(salt);
		int rows = regtisterDao.registerInset(reg);
		
		return rows;
	
	}
	
}
