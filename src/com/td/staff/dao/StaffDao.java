package com.td.staff.dao;

import com.td.crm.base.BaseDao;
import com.td.staff.domain.CrmStaff;

public interface StaffDao extends BaseDao<CrmStaff>{
	public CrmStaff find(String loginName,String loginPwd);
	
	
}
