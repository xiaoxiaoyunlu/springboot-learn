package com.zsy.WXDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zsy.WXDemo.domain.query.BaseQuery;

/**
 * 所有mapper的父接口
 * @author zj
 *
 * @param <T>
 */
@Mapper
public interface BaseMapper<T> {
	/**
	 * 创建t对象对于的数据表
	 */
	public void createTable() throws Exception;
	/**
	 * 保存t对象
	 * @param t
	 */
	public void save(T t) throws Exception;
	
	/**
	 * 修改t对象
	 * @param t
	 */
	public void update(T t) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Long id) throws Exception;
	
	/**
	 * 根据ID获取t对象
	 * @param id
	 * @return
	 */
	public T get(Long id) throws Exception;

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	public List<T> queryList(BaseQuery query) throws Exception;
	
	/**
	 * 总数查询
	 * @param query
	 * @return
	 */
	public Integer queryTotal(BaseQuery query) throws Exception;
}
