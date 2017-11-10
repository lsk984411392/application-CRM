package com.td.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.td.coursetype.dao.impl.CourseTypeDaoImpl;
import com.td.coursetype.domain.CrmCourseType;
import com.td.pageCut.PageBean;

public class CourseTypeServiceImpl {
	private CourseTypeDaoImpl courseTypeDao;
	public void setCourseTypeDao(CourseTypeDaoImpl courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	
	
	public void addOrEditCourse(CrmCourseType courseType) {
		courseTypeDao.saveOrUpdate(courseType);
		
	}
	public CrmCourseType findCourseTypeById(CrmCourseType courseType) {
		return courseTypeDao.findById(courseType.getCourseTypeId());
		
	}
	public void delete(CrmCourseType courseType) {
		courseTypeDao.delete(courseType);
		
	}
	public List<CrmCourseType> findAll(){
		return courseTypeDao.findAll();
	}
	public PageBean<CrmCourseType> findByCondition(CrmCourseType courseType, int pageNum, int pageSize) {
		StringBuilder sb=new StringBuilder();
		List l=new ArrayList();
		if(StringUtils.isNotBlank(courseType.getCourseName())){
			sb.append(" and courseName like ?");
			l.add("%"+courseType.getCourseName()+"%");
		}
		if(StringUtils.isNotBlank(courseType.getRemark())){
			sb.append(" and remark like ?");
			l.add("%"+courseType.getRemark()+"%");
		}
		if(StringUtils.isNotBlank(courseType.getTotalStart())){
			sb.append(" and total >= ?");
			l.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if(StringUtils.isNotBlank(courseType.getTotalEnd())){
			sb.append(" and total <= ?");
			l.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		if(StringUtils.isNotBlank(courseType.getCourseCostStart())){
			sb.append(" and courseCost >= ?");
			l.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if(StringUtils.isNotBlank(courseType.getCourseCostEnd())){
			sb.append(" and courseCost <= ?");
			l.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}
		Object[] params = l.toArray();
		String condition = sb.toString();
		
		//2分页
				//2.1 总记录数
		int totalRecord = this.courseTypeDao.getTotalRecord(condition,params);
				//2.2 创建对象
		PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);
				//2.3 分页数据
		List<CrmCourseType> data = this.courseTypeDao.findAll(condition, params,pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setData(data);
		
		return pageBean;
		
	}
	
}
