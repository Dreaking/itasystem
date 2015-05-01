package com.ita.action.authority;

import com.ita.action.WebConstant;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserAuthorityInterceptor extends AbstractInterceptor{
	
	public String intercept(ActionInvocation invocation) throws Exception{
		//创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//获取HttpSession的userEmail属性
		String userEmail=(String) ctx.getSession().get(WebConstant.USER_EMAIL);
		//对比登陆状态
		if(userEmail !=null){
			return invocation.invoke();
		}
		else{
			return Action.LOGIN;
		}
		
	}
	
}