package com.td.department.domain;

import java.util.HashSet;
import java.util.Set;

import com.td.post.domain.CrmPost;

public class CrmDepartment {
	/**
	 * CREATE TABLE `crm_department` (
  `depId` varchar(255) NOT NULL PRIMARY KEY,
  `depName` varchar(50) DEFAULT NULL
);
	 */
	private String depId;
	private String depName;
	private Set<CrmPost> postSet=new HashSet<CrmPost>();//可new可不new，建议new，一对多，一方建议new，多的不new
	
	
	
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Set<CrmPost> getPostSet() {
		return postSet;
	}
	public void setPostSet(Set<CrmPost> postSet) {
		this.postSet = postSet;
	}
	
}
