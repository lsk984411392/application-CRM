package com.td.department.web.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.td.crm.base.BaseAction;
import com.td.department.domain.CrmDepartment;
import com.td.department.service.impl.DepartmentServiceImpl;

public class DepartmentAction extends BaseAction<CrmDepartment>{
	
	public String findAll(){
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.set("allDepartment", allDepartment);
		return "findAll";
	}
	public String editUI(){
		if(StringUtils.isNotBlank(this.getModel().getDepId())){
			CrmDepartment departmentByFind = this.getDepartmentService().findById(this.getModel());
			this.push(departmentByFind);
		}
		return "editUI";
	}
	public String addOrEdit(){
		this.getDepartmentService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	public String delete(){
		this.getDepartmentService().delete(this.getModel());
		return "delete";
	}

}
