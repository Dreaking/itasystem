package com.ita.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.ita.action.base.UserBaseAction;
import com.ita.model.User;
import com.ita.service.UserManager;
import com.ita.vo.PassBean;
import com.opensymphony.xwork2.ActionContext;

public class ChangePassAction extends UserBaseAction{
	
	private PassBean pass;
	
	private String tip;
	
	//passBean的getter和settter
	public PassBean getPass() {
		return pass;
	}
	public void setPass(PassBean pass) {
		this.pass = pass;
	}
	//tip的getter和setter方法
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute()throws Exception{
		ActionContext ctx= ActionContext.getContext();
		String userEmail = (String)ctx.getSession().get(WebConstant.USER_EMAIL);
		int result=userManager.changePass(getPass(), userEmail);
		if(result==0){
			setTip("not-same");
		}else if(result==-1){
			setTip("pass-error");
		}else{
			setTip("changesuccess");
		}		
		return SUCCESS;
	}
	
}