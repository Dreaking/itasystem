package com.ita.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.struts2.ServletActionContext;

import com.ita.action.base.UserBaseAction;
import com.opensymphony.xwork2.ActionContext;

public class UploadPhoto extends UserBaseAction{
	
	private String tip;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute() throws Exception{
		
		ActionContext ctx = ActionContext.getContext();
		String userEmail = (String) ctx.getSession().get(WebConstant.USER_EMAIL);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		String realpathString=servletContext.getRealPath("/");
		String pathString=realpathString+"/images/";
		
		String imageName=userEmail.substring(0, userEmail.length()-4)+".jpg";
				
		Part part=request.getPart("file");
		
		String header =part.getHeader("content-disposition");
		System.out.println(header);
		String fileName=header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
		
		//判断是否图片
		boolean isPhoto=false;
		isPhoto=com.ita.fliter.PhotoFliter.isPhoto(fileName);
		if(!isPhoto) {
			setTip("NOT_PHOTO");
		}else{		
		//写入发布区间
		int len=-1;
		File file=new File("D:/kaohe/eclipse-jee-kepler-SR2-win32-x86_64/myproject/jsp-exam/WebContent/images/"+imageName);
		System.out.println("D:/kaohe/eclipse-jee-kepler-SR2-win32-x86_64/myproject/jsp-exam/WebContent/images/");
		InputStream in=part.getInputStream();
		OutputStream out =new FileOutputStream(file);
		byte[] buf=new byte[1024];
		while((len=in.read(buf))!=-1){
			out.write(buf,0,len);
		}
		in.close();
		out.close();
		}
		
		//写入工作区间
//		int len=-1;
//		File file=new File(pathString+imageName);
//		InputStream in2=part.getInputStream();
//		OutputStream out2 =new FileOutputStream(file);
//		byte[] buf2=new byte[1024];
//		while((len=in2.read(buf2))!=-1){
//			out2.write(buf2,0,len);
//		}
//		in2.close();
//		out2.close();		
//
//		}
		
		
		
		return SUCCESS;
		
		
	}
	
}