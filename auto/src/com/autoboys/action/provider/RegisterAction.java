package com.autoboys.action.provider;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.autoboys.dao.MemberDAO;
import com.autoboys.dao.MemberDAOImpl;
import com.autoboys.domain.Member;
import com.autoboys.domain.Provider;
import com.autoboys.domain.ProviderRegion;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport implements ServletRequestAware{
	
	//private Provider provider;
	
	//private	List<ProviderRegion> regions1;
	//Long region1;
	//private	List<ProviderRegion> regions2;
	//Long region2;
	//private	List<ProviderRegion> regions3;
		
	
	/*public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

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

	public List<ProviderRegion> getRegions3() {
		return regions3;
	}

	public void setRegions3(List<ProviderRegion> regions3) {
		this.regions3 = regions3;
	}*/

	Member mb;
	
	public Member getMb() {
		return mb;
	}

	public void setMb(Member mb) {
		this.mb = mb;
	}
	
	private MemberDAO memberDAO = new MemberDAOImpl();
	
	
	private HttpServletRequest request;
    //实现接口中的方法
    public void setServletRequest(HttpServletRequest request){
     this.request = request;
    }
	
	@Override
	public String execute() throws Exception {
		String method = request.getMethod();
		if(method.equals("POST"))	{
			int ret = memberDAO.insertProvider(mb);
			switch(ret) {
				case -1001:
					this.addFieldError("mb.mobile", "<div class='field-error'>手机号已经存在</div>");
					return "create";
				case -1002:
					this.addFieldError("mb.email", "<div class='field-error'>公司名已经存在</div>");
					return "create";
				case -1003:
					this.addFieldError("mb.nickName", "<div class='field-error'>昵称已经存在</div>");
					return "create";
			}
			
			return SUCCESS;
		}else{
			
			
			return "create";
		}
	}
	
}
