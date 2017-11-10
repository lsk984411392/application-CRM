package com.td.staff.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.td.crm.base.BaseAction;
import com.td.department.domain.CrmDepartment;
import com.td.pageCut.PageBean;
import com.td.post.domain.CrmPost;
import com.td.staff.domain.CrmStaff;

public class StaffAction extends BaseAction<CrmStaff>{
	
	public String login(){
		CrmStaff findStaff = this.getStaffService().login(this.getModel());
		if(findStaff!=null){
			putSession("loginStaff", findStaff);
			return SUCCESS;
		}
		this.addFieldError("", "用户名或密码错误");//这里不用配字段，赔了也用不了
		return "login";
	}
	public String home(){
		return "home";
	}
	public String findAll(){
		PageBean pageBean = this.getStaffService().findAllStaff(this.getModel(),this.getPageNum(),this.getPageSize());
		this.set("pageBean", pageBean);
		List<CrmDepartment> allDepartment =this.getDepartmentService().findAll();
		this.set("allDepartment", allDepartment);
		List<CrmPost> allCrmPst = this.getPostService().findAll();
		this.set("allCrmPst", allCrmPst);
		return "findAll";
	}
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	public String editUI(){
		CrmStaff findStaff = this.getStaffService().findStaffById(this.getModel().getStaffId());
		this.push(findStaff);
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.set("allDepartment", allDepartment);
		return "editUI";
	}
	public String edit(){
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}
	public String addUI(){
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		ActionContext.getContext().getValueStack().set("allDepartment", allDepartment);
		return "addUI";
	}
	public String add(){
		this.getStaffService().addSatff(this.getModel());
		return "add";
	}
	public String delete(){
		this.getStaffService().delete(this.getModel());
		return "delete";
	}
	public String editPwd(){
			CrmStaff loginStaff = (CrmStaff) ActionContext.getContext().getSession().get("loginStaff");
			loginStaff.setLoginPwd(this.getModel().getLoginPwd());
			this.getStaffService().updateStaff(loginStaff);
		return "loginn";/*这里返回login  此方法会执行两次，导致密码为null，不知道为什么？？？？？？*/
	}

}
