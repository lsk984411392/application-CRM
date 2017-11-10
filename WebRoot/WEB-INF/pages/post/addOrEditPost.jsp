<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[职务管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="javascript:sub()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<s:form action="postAction_addOrEdit" namespace="/">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
		<s:hidden name="postId"></s:hidden>
	 <tr>
	    <td>选择部门：</td>
	    <td>
	    	<s:select name="department.depId" list="allDepartment" listKey="depId" listValue="depName" 
	    		headerKey="" headerValue="----请--选--择----" id="s1"></s:select>
 		<font color="red" id="f1"></font> </td>
 		 
	    <td>职务：</td>
	    <td>
	    	<s:textfield name="postName" id="t1"></s:textfield><font color="red" id="f2"></font>
	    </td>
	  </tr>
	</table>
</s:form>
<script type="text/javascript">
		function sub(){
			if($("#s1").val()==""){
				$("#f1").html("部门必须选哦！");
				return;
			}
			if($("#t1").val()==""){
				$("#f2").html("请选择职务！");
				return;
			}
			else{
			$("form")[0].submit();
			
			}
		}
</script>
</body>
</html>
