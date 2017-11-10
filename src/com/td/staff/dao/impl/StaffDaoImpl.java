package com.td.staff.dao.impl;

import java.util.List;

import com.td.crm.base.impl.BaseDaoImpl;
import com.td.staff.dao.StaffDao;
import com.td.staff.domain.CrmStaff;

public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao{
	public CrmStaff find(String loginName,String loginPwd){
		List<CrmStaff> list = this.getHibernateTemplate().find("from CrmStaff where loginName=? and loginPwd=?",loginName,loginPwd);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}
}
