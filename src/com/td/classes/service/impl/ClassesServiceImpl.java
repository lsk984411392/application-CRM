package com.td.classes.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.td.classes.dao.impl.ClassesDaoImpl;
import com.td.classes.domain.CrmClasses;

public class ClassesServiceImpl {
	private ClassesDaoImpl classesDao;
	public void setClassesDao(ClassesDaoImpl classesDao) {
		this.classesDao = classesDao;
	}
	
	
	public List<CrmClasses> findAll() {
		return classesDao.findAll();
		
	}
	public CrmClasses findById(CrmClasses classes) {
		return classesDao.findById(classes.getClassId());
		
	}
	public void update(CrmClasses classes) {
		classesDao.update(classes);
		
	}

	public void addOrEdit(CrmClasses classes) {
		if(StringUtils.isBlank(classes.getClassId())){
			classes.setClassId(null);
		}
		classesDao.saveOrUpdate(classes);
		
	}


	public void delete(CrmClasses model) {
		classesDao.delete(model);
		
	}
	
}
