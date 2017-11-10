package com.td.post.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.td.department.domain.CrmDepartment;
import com.td.post.dao.impl.PostDaoImpl;
import com.td.post.domain.CrmPost;

public class PostServiceImpl {
	private PostDaoImpl postDao;
	public void setPostDao(PostDaoImpl postDao) {
		this.postDao = postDao;
	}
	public List<CrmPost> findAll(CrmDepartment department){
		return postDao.findAll(department);
	}
	public List<CrmPost> findAll(){
		return postDao.findAll();
	}
	public CrmPost findById(CrmPost post) {
		if(StringUtils.isBlank(post.getPostId())){
			return null;
		}
		return postDao.findById(post.getPostId());
		
	}
	public void addOrEdit(CrmPost post) {
		if(StringUtils.isBlank(post.getPostId())){
			post.setPostId(null);
		}
		postDao.saveOrUpdate(post);
		
	}
	public void delete(CrmPost post) {
		postDao.delete(post);
		
	}
	
}
