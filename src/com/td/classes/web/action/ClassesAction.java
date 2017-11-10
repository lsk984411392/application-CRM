package com.td.classes.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.registry.infomodel.User;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.td.classes.domain.CrmClasses;
import com.td.coursetype.domain.CrmCourseType;
import com.td.crm.base.BaseAction;

public class ClassesAction extends BaseAction<CrmClasses>{
	
	public String findAll(){
		List<CrmClasses> allClasses = this.getClassesService().findAll();
		ActionContext.getContext().getValueStack().set("allClasses", allClasses);
		return "findAll";
	}
	public String uploadUI(){
		CrmClasses findclasses = this.getClassesService().findById(this.getModel());
		this.push(findclasses);
		return "uploadUI";
	}
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	public String upload() throws IOException{
		/*CrmClasses findClasses = this.getClassesService().findById(this.getModel());
		String parentPath = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
		String path=generatePath(parentPath);
		findClasses.setUploadTime(new Date());
		findClasses.setUploadPath(path);
		findClasses.setUploadFilename(TokenHelper.generateGUID()+uploadFileName);
		upload.renameTo(new File(path,findClasses.getUploadFilename()));
		this.getClassesService().update(findClasses);
		System.out.println(uploadContentType);*/
		String parentPath = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
		String childPath=UUID.randomUUID().toString().replace("-", "");
		FileUtils.copyFile(upload, new File(parentPath+File.separator+childPath,uploadFileName));
		CrmClasses findClasses = this.getClassesService().findById(this.getModel());
		findClasses.setUploadTime(new Date());
		findClasses.setUploadPath(parentPath+File.separator+childPath);
		findClasses.setUploadFilename(uploadFileName);
		this.getClassesService().update(findClasses);
		return "upload";
	}
	public String show(){
		CrmClasses findClasses = this.getClassesService().findById(this.getModel());
		this.push(findClasses);
		return "show";
	}
	public String addOrEditUI(){
		if(StringUtils.isNotBlank(this.getModel().getClassId())){
			CrmClasses classesByFind = this.getClassesService().findById(this.getModel());
			this.push(classesByFind);
		}
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.set("allCourseType", allCourseType);
		return "addOrEditUI";
	}
	public String addOrEdit(){
		this.getClassesService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	public String delete(){
		this.getClassesService().delete(this.getModel());
		
		return "delete";
	}
	private InputStream inputStream;
	private String originalFilename;
	public String download() throws FileNotFoundException{
		CrmClasses classByFind = this.getClassesService().findById(this.getModel());
		originalFilename=classByFind.getUploadFilename();
		inputStream=new FileInputStream(new File(classByFind.getUploadPath(),classByFind.getUploadFilename()));
		return "download";
	}
	
	
	
	
	
	
	
	/*public String generatePath(String fu){
		DateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		String childPath = s.format(new Date());
		File f=new File(fu,childPath);
		if(!f.exists()){
			f.mkdirs();
		}
		return fu+File.separator+childPath;
	}*/


	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getOriginalFilename() {
		return originalFilename;
	}
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

}
