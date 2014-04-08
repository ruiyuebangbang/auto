package com.autoboys.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.autoboys.dao.*;
import com.autoboys.domain.*;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -6659925652584240539L;

	private Member user ;
	private List<Member> userList ;
	private MemberDAO userDAO = new MemberDAOImpl();
		
	/**
	 * To save or update user.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		userDAO.saveOrUpdateMember(user);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//request.getSession().getAttribute("xxx");
		Member member = (Member) request.getSession().getAttribute("login_user");
		long providerId = member.getProvid();
		userList = userDAO.listMemberByPro(providerId);
		user = new Member();
		user.setProvid(providerId);
		user.setClassid(2);
		user.setIsAdmin(0);
		user.setVerifiedemail(0);
		return SUCCESS;
	}
	
	public String editPassword()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if (!request.getMethod().equals("POST")) {
			return "editForm";
		}
		
		Member member = (Member) request.getSession().getAttribute("login_user");
		long id = member.getId();
		user.setId(id);
		userDAO.modifyPassword(user);
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		userDAO.deleteMember(Long.parseLong(request.getParameter("id")));
		
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		user = userDAO.queryMemberById(Long.parseLong(request.getParameter("id")));
		
		//request.getSession().getAttribute("xxx");
		Member member = (Member) request.getSession().getAttribute("login_user");
		long providerId = member.getProvid();
		userList = userDAO.listMemberByPro(providerId);
		return SUCCESS;
	}

	
	
	public Member getUser() {
		return user;
	}

	public void setUser(Member user) {
		this.user = user;
	}

	public List<Member> getUserList() {
		return userList;
	}

	public void setUserList(List<Member> userList) {
		this.userList = userList;
	}
	


}
