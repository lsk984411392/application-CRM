package com.td.coursetype.web.action;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.td.coursetype.domain.CrmCourseType;
import com.td.crm.base.BaseAction;
import com.td.pageCut.PageBean;

public class CourseTypeAction extends BaseAction<CrmCourseType> {
	
	public String addOrEditCourse(){
		this.getCourseTypeService().addOrEditCourse(this.getModel());
		return "addOrEdit";
	}
	public String addOrEditUI(){
		if(StringUtils.isNotBlank(this.getModel().getCourseTypeId())){
			CrmCourseType findCourse = this.getCourseTypeService().findCourseTypeById(this.getModel());
			this.push(findCourse);		
		}
		return "addOrEditUI";
	}
	
	public String findByCondition(){
		PageBean pageBean = this.getCourseTypeService().findByCondition(this.getModel(),this.getPageNum(),this.getPageSize());
		this.set("pageBean", pageBean);
		return "findByCondition";
	}
	public String delete(){
		this.getCourseTypeService().delete(this.getModel());
		return "delete";
	}
	


	
}
