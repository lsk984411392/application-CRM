package com.td.post.web.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.td.crm.base.BaseAction;
import com.td.department.domain.CrmDepartment;
import com.td.post.domain.CrmPost;

public class PostAction extends BaseAction<CrmPost>{
	
	public String findAllPostWithDepartment() throws IOException{
		List<CrmPost> allPost = this.getPostService().findAll(this.getModel().getDepartment());
		//2 将java对象 转换 json数据
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"department","staffSet"});//2.1 排除不需要数据
		String jsonData = JSONArray.fromObject(allPost, jsonConfig).toString();//2.2 转换
		//3 将json数据发送给浏览器
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");//3.1 响应中文乱码
		ServletActionContext.getResponse().getWriter().print(jsonData);//3.2 发送
		return "none";
	}
	public String findAll(){
		List<CrmPost> allPost = this.getPostService().findAll();
		this.set("allPost", allPost);
		return "findAll";
	}
	public String editUI(){
		CrmPost postByFind = this.getPostService().findById(this.getModel());
		this.push(postByFind);
		List<CrmDepartment> allDepartment =this.getDepartmentService().findAll();
		this.set("allDepartment",allDepartment);
		return "editUI";
	}
	public String addOrEdit(){
		this.getPostService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	public String delete(){
		this.getPostService().delete(this.getModel());
		return "delete";
	}

}
