<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>

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
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form action="staffAction_add" namespace="/" >
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td>
	    	<s:textfield name="loginName"  ></s:textfield>
	    </td>
	    <td>密码：</td>
	    <td>
	    	<s:password name="loginPwd"  ></s:password>
	    </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td>
	    	<s:textfield name="staffName" ></s:textfield>
	    </td>
	    <td>性别：</td>
	    <td>
	    	<s:radio list="{'男','女'}" name="gender"></s:radio>
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<s:select list="allDepartment" listValue="depName" listKey="depId" name="post.department.depId" onchange="changePost(this)" headerKey="" headerValue="----请--选--择----"></s:select>
	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<s:select name="post.postId" list="post!=null?post.department.postSet:{}" id="postSelectId"
	    	listKey="postId" listValue="postName" headerKey="" headerValue="----请--选--择----"></s:select>
    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<!-- <input type="text" name="onDutyDate" value="2014-04-24" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/> -->
	   		<s:date name="onDutyDate" format="yyyy-MM-dd" var="myDate"/>
	   		<s:textfield name="onDutyDate" readonly="true" value="%{#myDate}" onfocus="c.showMoreDay=true; c.show(this);"></s:textfield>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>
<script type="text/javascript">
	function changePost(obj){
		var depId=obj.value;
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
					var postSelectElement = document.getElementById("postSelectId");// 获得select对象
					postSelectElement.innerHTML = "<option value=''>----请--选--择----</option>";
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

</body>
</html>
