package com.autoboys.action.admin;

import java.util.ArrayList;
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
import com.autoboys.dao.ProviderRegionDAO;
import com.autoboys.domain.Pager;
import com.autoboys.domain.Provider;
import com.autoboys.domain.ProviderProduct;
import com.autoboys.domain.ProviderRegion;
import com.opensymphony.xwork2.ActionSupport;
public class ProviderAdminAction  extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5848973847833251891L;
	private ProviderDAO dao = new ProviderDAOImpl();
	private ProviderRegionDAO rdao = new ProviderRegionDAO();
	
	
	private Pager pager ;//保存分页信息
	private List<Provider> providerList;
	private Provider provider;
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

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
	
	private HttpServletRequest request;
    //实现接口中的方法
    public void setServletRequest(HttpServletRequest request){
    	this.request = request;
    }

	private	List<ProviderRegion> regions1;
	private Long region1;
	private	List<ProviderRegion> regions2;
	private Long region2;
    
	
	public List<ProviderRegion> getRegions1() {
		return regions1;
	}

	public void setRegions1(List<ProviderRegion> regions1) {
		this.regions1 = regions1;
	}

	public Long getRegion1() {
		return region1;
	}

	public void setRegion1(Long region1) {
		this.region1 = region1;
	}

	public List<ProviderRegion> getRegions2() {
		return regions2;
	}

	public void setRegions2(List<ProviderRegion> regions2) {
		this.regions2 = regions2;
	}

	public Long getRegion2() {
		return region2;
	}

	public void setRegion2(Long region2) {
		this.region2 = region2;
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
		pager.setTotal(dao.qryProviderCnt(provider.getSHORT_NAME(),region1,region2));
		providerList = dao.qryProviderList(provider.getSHORT_NAME(),region1,region2, pager.getPageCurr(), pager.getPageSize());
	
		
		regions1 =  rdao.getChildrenByParent(0L);
		if(region1 !=null) {
			regions2 = rdao.getChildrenByParent(region1);
		} else {
			regions2 = new ArrayList<ProviderRegion>();
		}
		
		return SUCCESS;
	}
	
	public String auditProviderQry() throws Exception {

		if(pager == null) {
			pager = new Pager();
		}
		pager.setTotal(dao.qryAuditProviderCnt());
		providerList = dao.qryAuditProviderList( pager.getPageCurr(), pager.getPageSize());		
		return SUCCESS;
	}
	
	public String auditProvider() throws Exception {
		String 	pid = request.getParameter("pid");
		String  stat = request.getParameter("stat");
		dao.auditProvider(Long.parseLong(pid), Integer.parseInt(stat));
		return SUCCESS;
	}
}
