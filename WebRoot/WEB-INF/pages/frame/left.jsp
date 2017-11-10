<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<HTML><HEAD>
<link href="${pageContext.request.contextPath}/css/dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
</HEAD>
<BODY bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center" >
<tr>
<div class="dtree">
	<script type="text/javascript">
		d = new dTree('d','${pageContext.request.contextPath}');
		d.add('01','-1','CRM管理系统');
		
		d.add('0103','01','教学部');
		<%-- 班级前缀和包结构命名：classesm ，其他命名class --%>
		d.add('010301','0103','班级管理','${pageContext.request.contextPath}/classesAction_findAll','','right');
		d.add('010302','0103','课程类别','${pageContext.request.contextPath}/courseTypeAction_findByCondition.action','','right');
		d.add('0105','01','人力资源部');
		d.add('010501','0105','部门管理','${pageContext.request.contextPath}/departmentAction_findAll','','right');
		d.add('010502','0105','职务管理','${pageContext.request.contextPath}/postAction_findAll','','right');
		d.add('010503','0105','员工管理','${pageContext.request.contextPath}/staffAction_findAll.action','','right');
		
		document.write(d);
	</script>
	<%-- 将用户跟踪页面修改成
		* 原始页面位置：WEB-INF/pages/user
		* 修改页面位置：WEB-INF/pages/follow
	--%>
</div>
</tr>
</table>
</BODY>
</HTML>
      			
			


      