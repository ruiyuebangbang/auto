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

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = -6659925652584240539L;

	private Product product ;
	
	private List<Product> productList;
	
		
	/**
	 * To save or update Product.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		//ProductDAO.saveOrUpdateProduct(Product);
		return SUCCESS;
	}
	
	/**
	 * To list all Products.
	 * @return String
	 */
	public String productList()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		return SUCCESS;
	}
	
	/**
	 * To delete a Product.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		return SUCCESS;
	}
	
	/**
	 * To list a single Product by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if(request.getMethod().equals("GET")){
			return INPUT;
		}else{
			return SUCCESS;
		}
	}
	
	public String mappingVehicle()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if(request.getMethod().equals("GET")){
			return INPUT;
		}else{
			return SUCCESS;
		}
	}

	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> ProductList) {
		this.productList = productList;
	}
	


}
