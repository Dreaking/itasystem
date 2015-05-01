package com.ita.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.ita.action.base.UserBaseAction;
import com.ita.util.PhotoFliter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Upload extends UserBaseAction {

	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型
	private String tip;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String execute() throws Exception {
		if (new PhotoFliter().isPhoto(imageFileName)) {
			if (image.length() > 2768227) {
				setTip("TOO_BIG");
			} else {
				ActionContext ctx = ActionContext.getContext();
				String userEmail = (String) ctx.getSession().get(
						WebConstant.USER_EMAIL);
				SimpleDateFormat df = new SimpleDateFormat("_MM_dd_HH_mm_ss");// 设置日期格式
				String time = df.format(new Date());//
				// System.out.println(time);
				setImageFileName(userEmail + time + ".jpg");
				// System.out.println(imageFileName);
				String realpath = ServletActionContext.getServletContext()
						.getRealPath("/images");

				// D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
				// System.out.println("realpath: "+realpath);
				if (image != null) {
					File savefile = new File(new File(realpath), imageFileName);
					if (!savefile.getParentFile().exists())
						savefile.getParentFile().mkdirs();
					FileUtils.copyFile(image, savefile);
					setTip("文件上传成功");
				}
			}
		} else {
			setTip("NOT_JPG");

		}
		return SUCCESS;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

}