<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>
<script type="text/javascript">
		function show1(){
			var f1=document.getElementById("f1");
			f1.innerHTML="只能输入数字哦！！！";
		}
		function show2(){
			var f1=document.getElementById("f1");
			f1.innerHTML="";
		}
		function show3(){
			var f2=document.getElementById("f2");
			f2.innerHTML="只能输入数字哦！！！";
		}
		function show4(){
			var f2=document.getElementById("f2");
			f2.innerHTML="";
		}
	</script>


<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[课程类别]</td>
   
    <td width="57%"align="right">
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
			<img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" />
		</a>      
    	<%--编辑前：添加类别 --%>
    	<a href="${pageContext.request.contextPath}/courseTypeAction_addOrEditUI">
	       	<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>


<%--条件查询 start --%>
<s:form action="courseTypeAction_findByCondition" namespace="/" >
	<%--隐藏域，存放当前页 --%>
	<s:hidden id="pageNum" name="pageNum" value="1"></s:hidden>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">名称：</td>
	    <td><s:textfield name="courseName" size="30"></s:textfield> </td>
	  </tr>
	  <tr>
	    <td >简介：</td>
	    <td ><s:textfield name="remark" size="30"></s:textfield> </td>
	  </tr>
	  <tr>  
	    <td >总学时：</td>
	    <td >
	    	<s:textfield name="totalStart" size="12" onfocus="show1()" onblur="show2()"/>至<s:textfield name="totalEnd" size="12" onfocus="show1()" onblur="show2()"/><font color="red" id="f1"></font>
	  </tr>
	  <tr>
	    <td>课程费用：</td>
	    <td >
	    	<s:textfield name="courseCostStart" size="12" onfocus="show3()" onblur="show4()"/>至<s:textfield name="courseCostEnd" size="12" onfocus="show3()" onblur="show4()" /><font color="red" id="f2"></font>
	  </tr>
	</table>
</s:form>

<%--条件查询 end --%>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="97%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="13%" align="center">名称</td>
    <td width="13%" align="center">收费标准</td>
    <td width="13%" align="center">总学时</td>
    <td width="25%" align="center">简介</td>
	<td width="11%" align="center">编辑</td>
	<td width="11%" align="center">删除</td>
  </tr>
  <%--数据展示，单行：tabtd1；双行：tabtd2 --%>
  	
  	<s:iterator value="pageBean.data" status="vs">
   <tr class="tabtd1">
	    <td align="center"><s:property value="courseName" /> </td>
	     <td align="center"><s:property value="courseCost" /></td>
	    <td align="center"><s:property value="total" /></td>
	    <td align="center"><s:property value="remark" /> </td>
	  	<td width="11%" align="center">
	  		<s:a action="courseTypeAction_addOrEditUI" namespace="/" >
	  			<s:param name="courseTypeId" value="courseTypeId"></s:param>
	  			<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" />
	  		</s:a>
	  		
	  	</td>
	  	<td width="11%" align="center">
	  		<s:a action="courseTypeAction_delete" namespace="/" onclick="return confirm('您确定要删除?') " >
	  			<s:param name="courseTypeId" value="courseTypeId"></s:param>
	  			<img src="${pageContext.request.contextPath}/images/button/delete.gif" class="img" />
	  		</s:a>
	  	</td>
	  </tr>
  </s:iterator>
 

 
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第<s:property value="pageBean.pageNum"/>/<s:property value="pageBean.totalPage" />页</span>
        <span>
        	
            	<a href="javascript:void(0)" onclick="showPage(1)">[首页]</a>&nbsp;&nbsp;
            	<a href="javascript:void(0)" onclick="showPage(<s:property value="pageBean.pageNum - 1>0?pageBean.pageNum-1:1" />)">[上一页]</a>&nbsp;&nbsp;
        	
        	
           		<a href="javascript:void(0)" onclick="showPage(<s:property value='%{pageBean.pageNum + 1 gt pageBean.totalPage?pageBean.totalPage:pageBean.pageNum + 1  }'/>   )">[下一页]</a>&nbsp;&nbsp;
            	<a href="javascript:void(0)" onclick="showPage(<s:property value="pageBean.totalPage" />)">[尾页]</a>&nbsp;&nbsp;
        	
        </span>
    </td>
  </tr>
</table>
<script type="text/javascript">
	function showPage(num){
			//1 修改隐藏域的值
			document.getElementById("pageNum").value = num;
			//2 提交表单
			document.forms[0].submit();
		}
	
	
	
</script>
</body>
</html>
