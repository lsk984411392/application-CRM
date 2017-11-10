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

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="${pageContext.request.contextPath}/staffAction_addUI">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件 -->
<s:form action="staffAction_findAll" namespace="/">

	<s:hidden id="pageNum" name="pageNum" value="1"></s:hidden>
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    	<s:select name="post.department.depId" list="allDepartment" listKey="depId" listValue="depName" 
	    	onchange="changePost(this)" headerKey="" headerValue="--请选择部门--">
			</s:select>

	    </td>
	    <td width="80px" >职务：</td><!--  /////////////////////////////////////////这里不能回显职务？？？？？？？？？？？？？？ 是因为当高级搜索时，
	    								name属性和value属性专一致时才会回显，部门有value值，而职务没有，所以将所有职务推入栈顶，便于回显	-->														-->
	    <td width="200px" >
	    <s:select name="post.postId" list="allCrmPst" id="postSelectId"
	    	listKey="postId" listValue="postName"
	    	headerKey="" headerValue="----请--选--择----"></s:select> 
	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><s:textfield name="staffName" size="12"></s:textfield></td>
	    <td ></td>
	  </tr>
	</table>
</s:form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
    <td width="11%" align="center">删除</td>
  </tr>
  
    <s:iterator value="pageBean.data" status="sta">
	  <tr class="tabtd1"> 
	    <td align="center"><s:property value="staffName"/> </td>
	    <td align="center"><s:property value="gender"/> </td>
	    <td align="center"><s:date name="onDutyDate" format="yyyy-MM-dd" />  </td>
	    <td align="center"><s:property value="post.department.depName"/> </td>
	    <td align="center"><s:property value="post.postName"/> </td>
	  	<td width="7%" align="center">
	  		<s:a action="staffAction_editUI" namespace="/">
	  			<s:param name="staffId" value="staffId"></s:param>
	  			<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" />
	  		</s:a>
	  	</td>
	  	<td width="11%" align="center">
	  		<s:a action="staffAction_delete" namespace="/" onclick="return confirm('您确定要删除?') " >
	  			<s:param name="staffId" value="staffId"></s:param>
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
            <a href="javascript:void(0)" onclick="showPage(<s:property value='%{pageBean.pageNum + 1 gt pageBean.totalPage?pageBean.totalPage:pageBean.pageNum + 1  }'/>)">[下一页]</a>&nbsp;&nbsp;
            <a href="javascript:void(0)" onclick="showPage(<s:property value="pageBean.totalPage" />)">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
</body>
<script type="text/javascript">
	function showPage(num){
			//1 修改隐藏域的值
			document.getElementById("pageNum").value = num;
			//2 提交表单
			document.forms[0].submit();
		}
	function changePost(obj){
		var depId=obj.value;
		var postSelectElement = document.getElementById("postSelectId");// 获得select对象
		if(depId==""){
			postSelectElement.innerHTML = "<option value=''>----请--选--择----</option>";
			return;
		}
		var re=null;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  re=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  re=new ActiveXObject("Microsoft.XMLHTTP");
		  }
			re.onreadystatechange = function(){//2.2 设置回调函数
				if(re.readyState == 4 && re.status == 200){//请求完成，正常响应
					var textData = re.responseText;//3 获得数据，并展示 ,手动ajax 获得 json数据 字符串
					var jsonData = eval("("+textData+")");	//3.1 将字符串 手动 转换 json对象
					postSelectElement.innerHTML = "";
					for(var i = 0 ; i < jsonData.length ; i++){//3.2 遍历
						var postObj = jsonData[i];
						var postId = postObj.postId;// 获得职务id
						var postName = postObj.postName;// 获得职务名称
						postSelectElement.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";//3.3 将数显示到select标签
					}
					
				}
			}
			//2.3 创建连接
			var url = "${pageContext.request.contextPath}/postAction_findAllPostWithDepartment?department.depId=" + depId;
			re.open("GET", url);
			//2.4 发送请求
			re.send(null);
	}

</script>
</html>
