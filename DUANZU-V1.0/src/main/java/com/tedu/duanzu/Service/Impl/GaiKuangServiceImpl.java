package com.tedu.duanzu.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.duanzu.Dao.GaiKuangDao;
import com.tedu.duanzu.Service.GaiKuangService;
import com.tedu.duanzu.entity.OrderItem;

@Service
public class GaiKuangServiceImpl implements GaiKuangService {
	@Autowired
	private GaiKuangDao gaiKuang;
	
	//房东id
	private Integer landlordId=1;
	
	
	@Override
	public List<OrderItem> selectIncom(String payTime, String payTime2) {
		//参数验证
		if(landlordId==null)
			throw new IllegalArgumentException("请登录");
		//查询总金额
		List<OrderItem> Incoms = gaiKuang.selectIncom(landlordId, payTime, payTime2);
		
		return Incoms;
	}


	@Override
	public Double selectJDL(String createTime, String createTime2) {
		int selectSumRow = gaiKuang.selectSumRows(landlordId, createTime, createTime2);
		int selectRows = gaiKuang.selectRows(landlordId, createTime, createTime2);
		int JD=selectSumRow-selectRows;
		System.out.println(JD);
		Double JDL = (double)JD/selectSumRow;
		return JDL;
	}



}
