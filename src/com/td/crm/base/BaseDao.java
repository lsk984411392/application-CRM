package com.td.crm.base;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public void saveOrUpdate(T t);
	public T findById(java.io.Serializable id);//通过id查询
	public List<T> findAll();//查询所有
	public List<T> findAll(String condition, Object[] params);//条件查询
	public int getTotalRecord(String condition, Object[] params);//分页，查询总记录数
	public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize);//分页，查询结果
	public List<T> findAll(DetachedCriteria criteria);//离线条件查询，使用QBC
	public List<T> findAll(DetachedCriteria criteria , int startIndex ,int pageSize);//分页
}
