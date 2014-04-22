package com.autoboys.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import com.autoboys.util.ImageUtil;
public class UploadAction extends ActionSupport{

	private File Filedata;
	
	private String FiledataContentType;
	
	private String FiledataFileName;
		
	public String execute() throws Exception
	{
		String realpath = ServletActionContext.getServletContext().getRealPath("/uploadimage");
		String imageType = FiledataFileName.substring(FiledataFileName.lastIndexOf('.'));
		InputStream is = new FileInputStream(Filedata);
		OutputStream os = null;
		
		if (Filedata != null) {
			File savefile = new File(new File(realpath), "test.jpg");
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			ImageUtil.resizeImage(Filedata, 120, 120,"jpg" , savefile.getAbsolutePath());
			//FileUtils.copyFile( Filedata, savefile);
		}
		return SUCCESS;
	}

	public File getFiledata() {
		return Filedata;
	}

	public void setFiledata(File Filedata) {
		this.Filedata = Filedata;
	}

	public String getFiledataContentType() {
		return FiledataContentType;
	}

	public void setFiledataContentType(String FiledataContentType) {
		this.FiledataContentType = FiledataContentType;
	}

	public String getFiledataFileName() {
		return FiledataFileName;
	}

	public void setFiledataFileName(String FiledataFileName) {
		this.FiledataFileName = FiledataFileName;
	}
	
}
