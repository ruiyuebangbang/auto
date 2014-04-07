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

public class StoreAction extends ActionSupport implements ModelDriven<Provider> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2427437062687643199L;
	
	@Override
	public String execute() throws Exception {		
		return SUCCESS;
	}

	@Override
	public Provider getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String queryProvider() {
		return SUCCESS;
	}
	
}
