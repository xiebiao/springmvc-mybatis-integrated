package com.xiebiao.mybatis.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 实现了mybatis一些相关的特性.<br/>
 * 1.分页查询中计算 LIMIT start,end. <br/>
 * 2.排序.<br/>
 * </p>
 * 
 * @author xiaog
 * 
 */
public class BaseDomain implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 动态字段. 在ibatis文件中可用“dynamicFields.xxx”方式读取动态字段值
	 */
	protected Map<String, Object> dynamicFields = new HashMap<String, Object>();

	/** 最大行数. */
	// private static final int MAX_ROWS = 9999999;

	Integer id;
	/**
	 * 返回结果
	 */
	Integer result;

	private int start;

	/**
	 * 查询数据条数
	 */
	private int rows;

	/**
	 * 排序字段(例sp.spCode).
	 */
	private String sort;

	/**
	 * 正序|反序(例ASC).
	 */
	private String order;

	public BaseDomain() {
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 设置动态字段值.
	 * 
	 * @param fieldName
	 *            字段名称
	 * @param value
	 *            字段值
	 */
	public void setField(String fieldName, Object value) {
		dynamicFields.put(fieldName, value);
	}

	/**
	 * 返回动态字段值.
	 * 
	 * @param fieldName
	 *            字段名称
	 * @return 对象
	 */
	public Object getField(String fieldName) {
		if (dynamicFields == null) {
			return null;
		}
		return dynamicFields.get(fieldName);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getStart() {
		return start;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
