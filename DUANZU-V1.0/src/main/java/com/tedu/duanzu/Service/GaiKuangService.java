package com.tedu.duanzu.Service;

import java.util.List;

import com.tedu.duanzu.entity.OrderItem;

public interface GaiKuangService {

	List<OrderItem> selectIncom(String payTime,String payTime2);

	Double selectJDL(String createTime,String createTime2);
}
