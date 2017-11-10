package com.td.post.dao.impl;

import java.util.List;

import com.td.crm.base.impl.BaseDaoImpl;
import com.td.department.domain.CrmDepartment;
import com.td.post.domain.CrmPost;

public class PostDaoImpl extends BaseDaoImpl<CrmPost> {
	
	public List<CrmPost> findAll(CrmDepartment department){
		return this.getHibernateTemplate().find("from CrmPost where department = ?",department);
	}
}
