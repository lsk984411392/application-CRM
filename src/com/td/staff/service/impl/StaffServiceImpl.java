package com.td.staff.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.td.pageCut.PageBean;
import com.td.staff.dao.impl.StaffDaoImpl;
import com.td.staff.domain.CrmStaff;

public class StaffServiceImpl {
	private StaffDaoImpl daoImpl;
	public void setDaoImpl(StaffDaoImpl daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	public CrmStaff login(CrmStaff staff){
		return daoImpl.find(staff.getLoginName(), staff.getLoginPwd());
	}
	public PageBean findAllStaff(CrmStaff staff, int pageNum, int pageSize){
		
		StringBuilder sb=new StringBuilder();
		List l=new ArrayList();
		if(StringUtils.isNotBlank(staff.getStaffName())){
			sb.append(" and staffName like ?");
			l.add("%"+staff.getStaffName()+"%");
		}
		if(staff.getPost()!=null){
			if(StringUtils.isNotBlank(staff.getPost().getPostId())){
				sb.append(" and postId in (?)");
				l.add(staff.getPost().getPostId());
			}
		}
		
		
		
		Object[] params = l.toArray();
		String condition = sb.toString();
		
		//2分页
				//2.1 总记录数
		int totalRecord = daoImpl.getTotalRecord(condition,params);
				//2.2 创建对象
		PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);
				//2.3 分页数据
		List<CrmStaff> data = daoImpl.findAll(condition, params,pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setData(data);
		
		return pageBean;
	}
	public CrmStaff findStaffById(String staffId){
		return daoImpl.findById(staffId);
	}

	public void logou() {
		
	}

	public void updateStaff(CrmStaff staff) {
		/* 3 方法3：先通过id查询，比较密码是否一致
		 * * 如果不一致，对密码进行MD5加密
		 * * 将出OID之外的数据，全部设置
		 * * 原因：一级缓存被修改了，与快照不一致，默认情况下，当提交，自动执行update语句。
		 */
		daoImpl.update(staff);
		/*if(! findStaff.getLoginPwd().equals(staff.getLoginPwd())){
			findStaff.setLoginPwd(staff.getLoginPwd());
		}
		findStaff.setLoginName(staff.getLoginName());
		findStaff.setStaffName(staff.getStaffName());
		findStaff.setGender(staff.getGender());
		findStaff.setOnDutyDate(staff.getOnDutyDate());
		findStaff.setPost(staff.getPost());*/
	}

	public void addSatff(CrmStaff staff) {
		daoImpl.save(staff);
		
	}

	public void delete(CrmStaff staff) {
		daoImpl.delete( staff);
		
	}


}
