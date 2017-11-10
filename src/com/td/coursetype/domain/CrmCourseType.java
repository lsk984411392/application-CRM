package com.td.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import com.td.classes.domain.CrmClasses;

public class CrmCourseType {
	/*
	 * CREATE TABLE `crm_course_type` (
  `courseTypeId` varchar(255) NOT NULL PRIMARY KEY,
  `courseCost` double DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `courseName` varchar(500) DEFAULT NULL,
  `remark` varchar(5000) DEFAULT NULL
);
	 */
	private String courseTypeId;
	private Double courseCost;////////////////
	private Integer total;//总学时
	private String courseName;
	private String remark;
	private Set<CrmClasses> classesSet=new HashSet<CrmClasses>();
	
	private String totalStart;//起始学时（多条件查询）
	private String totalEnd;//结束学时（多条件查询）
	private String courseCostStart;//起始课程花费费用（多条件查询）
	private String courseCostEnd;//起始花费费用（多条件查询）
	public String getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public Double getCourseCost() {
		return courseCost;
	}
	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<CrmClasses> getClassesSet() {
		return classesSet;
	}
	public void setClassesSet(Set<CrmClasses> classesSet) {
		this.classesSet = classesSet;
	}
	public String getTotalStart() {
		return totalStart;
	}
	public void setTotalStart(String totalStart) {
		this.totalStart = totalStart;
	}
	public String getTotalEnd() {
		return totalEnd;
	}
	public void setTotalEnd(String totalEnd) {
		this.totalEnd = totalEnd;
	}
	public String getCourseCostStart() {
		return courseCostStart;
	}
	public void setCourseCostStart(String courseCostStart) {
		this.courseCostStart = courseCostStart;
	}
	public String getCourseCostEnd() {
		return courseCostEnd;
	}
	public void setCourseCostEnd(String courseCostEnd) {
		this.courseCostEnd = courseCostEnd;
	}
	
}
