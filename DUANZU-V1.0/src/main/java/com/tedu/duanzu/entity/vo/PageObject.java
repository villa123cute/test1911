package com.tedu.duanzu.entity.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2241694875619510487L;
	//当前页的页码值	
	private Integer pageCurrent;
	//页面大小
	private Integer pageSize;
	//总行数
	private Integer rowCount;
	//总页数
	private Integer pageCount;
	//当前页记录
	private List<T> records;
	public PageObject(List<T> records,Integer pageCurrent, Integer pageSize, Integer rowCount) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;
		this.pageCount =rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}
	}
	
	
		
}
