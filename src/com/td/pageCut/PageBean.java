package com.td.pageCut;

import java.util.List;

import com.td.coursetype.domain.CrmCourseType;

public class PageBean<T> {
	private int pageNum;
	private int pageSize;
	private int totalRecord;
	private int startIndex;
	private int totalPage;
	private List<T> data;
	public PageBean(int pageNum,int pageSize,int totalRecord){
		this.pageNum=pageNum;
		this.pageSize=pageSize;
		this.totalRecord=totalRecord;
		this.startIndex=(this.pageNum-1)*this.pageSize;
		this.totalPage=(this.totalRecord+this.pageSize-1)/this.pageSize;
		
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
}
