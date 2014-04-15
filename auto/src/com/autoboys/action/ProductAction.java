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
	private ServiceCatDAO serviceCatDAO = new ServiceCatDAOImpl();
	private ServiceDAO serviceDAO = new ServiceDAOImpl();
	private ProductDAO pdao = new ProductDAOImpl();
	private VehicleSeriesDAO vehicleSeriesDAO = new VehicleSeriesDAOImpl();
	private VehicleBrandDAO   vehicleBrandDAO = new VehicleBrandDAOImpl();
	
	private Product product ;
	
	private List<Product> productList;
	
	private List<ServiceCat> cats;//服务类别
	private List<Service> sevs;   //服务
	private List<VehicleBrand> brands;//汽车品牌
	private List<VehicleSeries> series;//汽车系列
	private Pager pager ;//保存分页信息
	
	private String selCategory;
	private String selVehicleBrand;
	private String selVehicleSeries;
	
	
	public String getSelVehicleBrand() {
		return selVehicleBrand;
	}

	public void setSelVehicleBrand(String selVehicleBrand) {
		this.selVehicleBrand = selVehicleBrand;
	}

	public String getSelVehicleSeries() {
		return selVehicleSeries;
	}

	public void setSelVehicleSeries(String selVehicleSeries) {
		this.selVehicleSeries = selVehicleSeries;
	}

	public String getSelCategory() {
		return selCategory;
	}

	public void setSelCategory(String selCategory) {
		this.selCategory = selCategory;
	}
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	public List<ServiceCat> getCats() {
		return cats;
	}

	public List<Service> getSevs() {
		return sevs;
	}

	public List<VehicleBrand> getBrands() {
		return brands;
	}

	public List<VehicleSeries> getSeries() {
		return series;
	}

	public void setCats(List<ServiceCat> cats) {
		this.cats = cats;
	}

	public void setSevs(List<Service> sevs) {
		this.sevs = sevs;
	}

	public void setBrands(List<VehicleBrand> brands) {
		this.brands = brands;
	}

	public void setSeries(List<VehicleSeries> series) {
		this.series = series;
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

	public void setProductList(List<Product> pls) {
		this.productList = pls;
	}
	
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
	public String list()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		cats = serviceCatDAO.listServiceCat();
		if(selCategory != null && !selCategory.equals("")) {
			sevs = serviceDAO.listServiceByCatId(selCategory);
		} else {
			sevs = serviceDAO.listService();
		}
		brands = vehicleBrandDAO.listVehicleBrand();
		if(selVehicleBrand !=null && !selVehicleBrand.equals("")) {
			series = vehicleSeriesDAO.listByBrandCode(selVehicleBrand);
		} else {
			series = new ArrayList<VehicleSeries>();
		}
		
		if(pager == null) {
			pager = new Pager();
		}
		if(product==null) {
			product = new Product();
		}
		pager.setTotal(pdao.qryProductsCount(product,selCategory,selVehicleBrand,selVehicleSeries));
		productList = pdao.qryProductsList(product,selCategory,selVehicleBrand,selVehicleSeries, pager.getPageCurr(), pager.getPageSize());
		
		
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



}
