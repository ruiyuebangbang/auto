package com.autoboys.action.provider;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class ServiceAction extends ActionSupport implements ServletRequestAware{
	
	private HttpServletRequest request;
	
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 商家配置服务项目
	 * @return
	 */
	public String serviceConfig() {
		return SUCCESS;
	}
	
}
