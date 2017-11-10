<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script type="text/javascript">
	function submit(){
		var n1=document.getElementById("nameId");
		var c1=document.getElementById("courseTypeId");
		var s1=document.getElementById("s1");
		var s2=document.getElementById("s2");
		if(n1.value==""){
			s1.innerHTML="不能为空哦！";
		}
		if(c1.value==""){
				s2.innerHTML="不能为空哦！";return;
			}
		document.forms[0].submit();
	
	}

</script>
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
    <td width="44%" align="left">[编辑班级]</td>
   
    <td width="52%"align="right">
    	<a href="javascript:void(0)" onclick="javascript:submit()">
    		<img src="${pageContext.request.contextPath}/images/button/save.gif" />
    	</a>
       <a href="javascript:void(0)" onclick="javascript:window.history.go(-1)">
       		<img src="${pageContext.request.contextPath}/images/button/tuihui.gif" />
       </a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<s:form action="classesAction_addOrEdit" namespace="/">
	<s:hidden name="classId"></s:hidden>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">班级名称：</td>
	    <td width="20%"><s:textfield name="name" id="nameId"></s:textfield> <span id="s1" style="color:red"></span></td>
	    <td width="8%">所属类别：</td>
	    <td width="62%">
	    	<s:select name="courseType.courseTypeId" list="allCourseType" listKey="courseTypeId" listValue="courseName"
	    	headerKey="" headerValue="---请选择---" id="courseTypeId"><span id="s2" style="color:red"></span></s:select>
		</td>
	  </tr>
	  <tr>
	    <td>开课时间：</td> 
	    <td>
	    	<s:textfield name="beginTime"  readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"></s:textfield>
	    </td>
	    <td>结业时间：</td>
	    <td>
	    	<s:textfield name="endTime" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"></s:textfield>
	    </td>
	  </tr>
	  <tr>
	    <td>其他说明：</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="4">
	    	<s:textarea name="remark" cols="60" rows="10"></s:textarea>
	  </tr>
	</table>
</s:form>

</body>
</html>
