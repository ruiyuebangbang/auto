package com.autoboys.action.provider;


import com.opensymphony.xwork2.ActionSupport;

public class ProviderAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("����");
		return SUCCESS;
	}
	
}
