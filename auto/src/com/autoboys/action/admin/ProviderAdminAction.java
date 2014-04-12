package com.autoboys.action.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.autoboys.dao.ProviderDAO;
import com.autoboys.dao.ProviderDAOImpl;
import com.autoboys.domain.Pager;
import com.autoboys.domain.Provider;
import com.autoboys.domain.ProviderProduct;
import com.opensymphony.xwork2.ActionSupport;
public class ProviderAdminAction  extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5848973847833251891L;
	private ProviderDAO dao = new ProviderDAOImpl();
	
	private Pager pager ;//保存分页信息
	private List<Provider> providerList;

	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<Provider> getProviderList() {
		return providerList;
	}

	public void setProviderList(List<Provider> providerList) {
		this.providerList = providerList;
	}

	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("");
		return SUCCESS;
	}
	
	public String queryProvider() throws Exception {
		if(pager == null) {
			pager = new Pager();
		}

		pager.setTotal(dao.qryCount());
		providerList = dao.qryProviderList( pager.getPageCurr(), pager.getPageSize());
	
		return SUCCESS;
	}
	
	public String auditProvider() throws Exception {
		if(pager == null) {
			pager = new Pager();
		}
	
		pager.setTotal(dao.qryCount());
		providerList = dao.qryProviderList( pager.getPageCurr(), pager.getPageSize());		
			return SUCCESS;
	}
}
