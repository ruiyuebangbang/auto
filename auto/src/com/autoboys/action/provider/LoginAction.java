package com.autoboys.action.provider;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.autoboys.domain.Member;
import com.opensymphony.xwork2.ActionSupport;
import com.autoboys.dao.*;
import com.autoboys.domain.Member;
public class LoginAction  extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6174293091280859668L;
	//实现接口中的方法
	private HttpServletRequest request;
	private Map<String, Object> session;
	private MemberDAO memberDAO = new MemberDAOImpl();
	private Member member = new Member();
    public void setServletRequest(HttpServletRequest request){
     this.request = request;
    }
    @Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public String execute() throws Exception {
		if(! request.getMethod().equals("POST"))	{
			return SUCCESS;
		}else{
			String method = request.getMethod();

			if(! method.equals("POST"))	{
				return "login";
			}else{
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				String captcha = request.getParameter("captcha");
				if(captcha == null || captcha.trim().length() != 4 || !captcha.trim().equals(session.get("captcha"))){
					
					this.addFieldError("member.captcha", "<div class='field-error'>验证码不正确，请重新输入！</div>");
					return "login";
				}
				Member member = memberDAO.queryByUserName(userName);
				
				if(member == null) {
					this.addFieldError("member.username", "<div class='field-error'>抱歉，该账号不存在！<a href='register.action' >立即注册</a></div>");
					return "login";
				}else if (!member.getPassword().equals(password)){
					this.addFieldError("member.password", "<div class='field-error'>密码不正确，再试试看！</div>");
					return "login";
				}
				request.getSession(true).setAttribute("login_user", member);
				
				
			}
			return SUCCESS;
		}
		
	}
	
	public String plogin() throws Exception {
		return SUCCESS;
	}
}
