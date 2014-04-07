package com.autoboys.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.autoboys.dao.*;
import com.autoboys.domain.Member;

public class LoginAction extends ActionSupport implements ServletRequestAware{
	String returnURL;
	
	public String getReturnURL() {
		return returnURL;
	}

	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7436200132703837430L;
	private MemberDAO memberDAO = new MemberDAOImpl();
	private Member member = new Member();
	private HttpServletRequest request;
    //实现接口中的方法
    public void setServletRequest(HttpServletRequest request){
     this.request = request;
    }
	
	@Override
	public String execute() throws Exception {
		String method = request.getMethod();

		if(! method.equals("POST"))	{
			return "login";
		}else{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			Member member = memberDAO.queryByUserName(userName);
			if(member == null) {
				this.addFieldError("member.username", "<div class='field-error'>抱歉，该账号不存在！<a href='register.action' >立即注册</a></div>");
				return "login";
			}else if (!member.getPassword().equals(password)){
				this.addFieldError("member.password", "<div class='field-error'>密码不正确，再试试看！</div>");
				return "login";
			}
			request.getSession(true).setAttribute("login_user", member);
			
			//returnURL = request.getParameter("returnURL");
			if(returnURL == null||"".equals(returnURL)) return "home";
			else { 
				ServletActionContext.getResponse().sendRedirect(returnURL);
				//request.getRequestDispatcher(returnURL).forward(request, ServletActionContext.getResponse());
				return null;
			}
		}	
	}
	
}
