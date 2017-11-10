package com.td.crm.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.td.classes.service.impl.ClassesServiceImpl;
import com.td.coursetype.service.impl.CourseTypeServiceImpl;
import com.td.department.service.impl.DepartmentServiceImpl;
import com.td.post.service.impl.PostServiceImpl;
import com.td.staff.service.impl.StaffServiceImpl;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private T t;
	public T getModel() {
		return t;
	}
	public BaseAction() {// 实例化t
		try {
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();// 获得T运行时Class
			Class<T> clazz = (Class<T>) paramType.getActualTypeArguments()[0];
			t = clazz.newInstance();//反射创建实例
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//员工
	private StaffServiceImpl staffService;
	//职务
	private PostServiceImpl postService;
	//部门
	private DepartmentServiceImpl departmentService;
	//课程类别
	private CourseTypeServiceImpl courseTypeService;
	//班级
	private ClassesServiceImpl classesService;
	
	// 分页数据
	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	private int pageSize = 2;  //固定值
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	//简化值栈操作
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	
	public void set(String key ,Object o){
		ActionContext.getContext().getValueStack().set(key, o);
	}
	
	public void put(String key, Object value){
		ActionContext.getContext().put(key, value);
	}
	
	public void putSession(String key, Object value){
		ActionContext.getContext().getSession().put(key, value);
	}
	
	public void putApplication(String key, Object value){
		ActionContext.getContext().getApplication().put(key, value);
	}
	public StaffServiceImpl getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffServiceImpl staffService) {
		this.staffService = staffService;
	}
	public PostServiceImpl getPostService() {
		return postService;
	}
	public void setPostService(PostServiceImpl postService) {
		this.postService = postService;
	}
	public DepartmentServiceImpl getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentServiceImpl departmentService) {
		this.departmentService = departmentService;
	}
	public CourseTypeServiceImpl getCourseTypeService() {
		return courseTypeService;
	}
	public void setCourseTypeService(CourseTypeServiceImpl courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	public ClassesServiceImpl getClassesService() {
		return classesService;
	}
	public void setClassesService(ClassesServiceImpl classesService) {
		this.classesService = classesService;
	}
	
	

}
