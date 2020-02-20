package com.tedu.duanzu.Dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.tedu.duanzu.entity.Landlord;

@Mapper
public interface LandlordDao{
	/**持久化*/
	int insertObject(Landlord lord);
	/**修改*/
	int updateObject(Landlord entity);
	/**根据房东id查表*/
	@Select("select * where id=#{id}")
	List<Map<String,Object>> findObjects();
}
