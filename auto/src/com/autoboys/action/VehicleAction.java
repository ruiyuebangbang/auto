package com.autoboys.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.autoboys.dao.VehicleCategoryDAO;
import com.autoboys.dao.VehicleCategoryDAOImpl;
import com.autoboys.dao.VehicleSeriesDAO;
import com.autoboys.dao.VehicleSeriesDAOImpl;
import com.autoboys.domain.User;
import com.autoboys.domain.VehicleCategory;
import com.autoboys.domain.VehicleSeries;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VehicleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3324047803117359078L;
	
	//private HttpServletRequest request;
	//private VehicleCategory vehicleCategory = new VehicleCategory();
	private List<VehicleCategory> vehicleCategories = new ArrayList<VehicleCategory>();
	private VehicleCategoryDAO vehicleCategoryDAO = new VehicleCategoryDAOImpl();
	
	//public void setServletRequest(HttpServletRequest arg0) {
	//	this.request = arg0;
	//}
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("Action 出来");
		return SUCCESS;
	}
	/**
	 * 供应商修改能提供维修的汽车品牌
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String providerChangeBrands() throws Exception {
		vehicleCategories = vehicleCategoryDAO.listVehicleByParentId("0");
		//request.setAttribute("vehicleCategories", vehicleCategories); 
		//System.out.println("list.size:"+vehicleCategories.size());
		return SUCCESS;
	}
	
	/**
	 * 选择车型
	 * @return
	 * @throws Exception
	 */
	public String chooseVehicle() throws Exception {
		
		return SUCCESS;
	}
	
	public List<VehicleCategory> getVehicleCategories() {
		return vehicleCategories;
	}

	public void setVehicleCategories(List<VehicleCategory> vehicleCategories) {
		this.vehicleCategories = vehicleCategories;
	}
	
	
	
}
