package com.td.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	//配置拦截器
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		Object object = ActionContext.getContext().getSession().get("loginStaff");
		if(object==null){//如果session作用域中为空（不存在登录信息）返回login,并带回有好信息提示-亲，请先登录呦
			Object obj = arg0.getAction();
			if(obj instanceof ActionSupport){
				ActionSupport obj1=(ActionSupport)obj;
				obj1.addFieldError("","亲，请先登录呦" );
			}
			return "login";
		}
		return arg0.invoke();//如果不为空，说明已登录，放行
	}

}
