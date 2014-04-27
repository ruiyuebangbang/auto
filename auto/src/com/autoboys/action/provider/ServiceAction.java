package com.autoboys.action.provider;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.autoboys.dao.ServiceCatDAO;
import com.autoboys.dao.ServiceCatDAOImpl;
import com.autoboys.domain.ServiceCat;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = -7934678560516553269L;

	private static Logger log = Logger.getLogger(ServiceAction.class);
	private HttpServletRequest request;
	private ServiceCatDAO serviceCatDAO = new ServiceCatDAOImpl();
	private List<ServiceCat> serviceCats ;
	
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
		serviceCats = serviceCatDAO.listServiceCat();
		return SUCCESS;
	}
	
}
