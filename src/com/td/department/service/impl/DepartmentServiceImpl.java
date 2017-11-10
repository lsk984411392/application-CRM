package com.td.department.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.td.department.dao.impl.DepartmentDaoImpl;
import com.td.department.domain.CrmDepartment;

public class DepartmentServiceImpl {
	
	private DepartmentDaoImpl departmentDao;
	public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
		this.departmentDao = departmentDao;
	}
	public List<CrmDepartment> findAll(){
		return departmentDao.findAll();
	}
	public CrmDepartment findById(CrmDepartment department) {
		return departmentDao.findById(department.getDepId());
		
	}
	public void addOrEdit(CrmDepartment department) {
		if(StringUtils.isBlank(department.getDepId())){
			department.setDepId(null);
		}
		departmentDao.saveOrUpdate(department);
		
	}
	public void delete(CrmDepartment department) {
		departmentDao.delete(department);
		
	}
}
