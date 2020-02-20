package com.tedu.duanzu.Dao;



import org.apache.ibatis.annotations.Select;



public interface BaseDao {
	@Select("select count(*) from tb_order_item where ${column2}=#{id2} and ${column}=#{id}")
	int findById(String column2,Integer id2,
				String column,Integer id);
	

}
