package com.autoboys.action;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.autoboys.util.*;
import com.autoboys.dao.*;
import com.autoboys.domain.*;

public class AjaxAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 781068284193885361L;
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private Map<String, Object> session;
	private List<VehicleBrand> brandList = new ArrayList<VehicleBrand>();
	private List<VehicleSeries> seriesList = new ArrayList<VehicleSeries>();
	private List<VehicleEmission> emissionList = new ArrayList<VehicleEmission>();
	private List<VehicleYear> yearList = new ArrayList<VehicleYear>();
	private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private VehicleCategoryDAO vehicleCategoryDAO = new VehicleCategoryDAOImpl();
	private VehicleBrandDAO vehicleBrandDAO = new VehicleBrandDAOImpl();
	private VehicleSeriesDAO vehicleSeriesDAO = new VehicleSeriesDAOImpl();
	private VehicleEmissionDAO vehicleEmissionDAO = new VehicleEmissionDAOImpl();
	private VehicleYearDAO vehicleYearDAO = new VehicleYearDAOImpl();
	private VehicleDAO vehicleDAO = new VehicleDAOImpl();
	
	
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;;
		
	}
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	/**
	 * 异步获取头部快捷菜单信息
	 * @return
	 * @throws Exception
	 */
	public String loadHeader() throws Exception {
		//根据Cookie获取所选车辆信息
		String currentModel = (String)session.get("currentModel");
		Vehicle vehicle = null;
		if(currentModel == null){
			Cookie autoBoysVM = CookieUtil.getCookie(request, "AutoboysVM");
			if(autoBoysVM != null){
				vehicle = vehicleDAO.getVehicleByPrimaryKey(new Integer(autoBoysVM.getValue()));
				if(vehicle != null){
					currentModel = vehicle.getFullName();
					session.put("currentModel", currentModel);
				}
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 根据父类Code获取车型列表
	 * @return
	 * @throws Exception
	 */
	public String confirmVechicle() throws Exception {
		String vehicleId = request.getParameter("vehicle_id");
		String currentModel = vehicleDAO.getVehicleByPrimaryKey(new Integer(vehicleId)).getFullName();
				
		//设置选定车系
		CookieUtil.setCookie(request, response, "AutoboysVM", vehicleId, 31536000);
		if(currentModel != null) 
		{
			//CookieUtil.setCookie(request, response, "CurrentVM", URLEncoder.encode(currentModel,"utf-8"), 31536000);
			HttpSession session = request.getSession(); 
			session.setAttribute("currentModel",currentModel);
			//System.out.println("current model set to session:"+currentModel);
			
		}
		printWriteHTML("var data = {\"success\":true}");
		return null;
	}
	/**
	 * 根据首字母查询汽车品牌
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getBrands() throws Exception {
		
		String firstCharacter = request.getParameter("fc");
		if(firstCharacter == null || firstCharacter.length()==0 || firstCharacter.equals("1")){
			brandList = vehicleBrandDAO.listHotVehicleBrand();
		}else{
			brandList = vehicleBrandDAO.listVehicleBrandByFC(firstCharacter);
		}
		session.put("firstCharacter", firstCharacter);
		return SUCCESS;
	}
	/**
	 * 根据父类Code获取车系列表
	 * @return
	 * @throws Exception
	 */
	public String getVehicleSeries() throws Exception {
		String pcode = request.getParameter("pcode");
		System.out.println("pcode:"+pcode);
		//设置选定品牌cookie
		//CookieUtil.setCookie(request, response, "AutoboysVB", pcode, 31536000);
		seriesList = vehicleSeriesDAO.listByBrandCode(pcode);
		request.setAttribute("seriesList", seriesList);
		VehicleBrand brand = vehicleBrandDAO.getVehicleBrand(pcode);
		session.put("curBrandCode", pcode);
		session.put("curBrandName", brand.getCname());
		return SUCCESS;
	}
	/**
	 * 根据父类Code获取排量信息
	 * @return
	 * @throws Exception
	 */
	public String getVehicleEmission() throws Exception {
		String pcode = request.getParameter("pcode");
		//System.out.println("series:"+pcode);
		//设置选定车系
		//CookieUtil.setCookie(request, response, "AutoboysVS", pcode, 31536000);
		//emissionList = vehicleEmissionDAO.listBySeriesCode(pcode);
		//modify by Kevin 2014.4.7 排量改为直接从vehicle表获取
		vehicleList = vehicleDAO.getVehiclesBySeries(pcode);
		VehicleSeries series = vehicleSeriesDAO.getVehicleSeries(pcode);
		
		session.put("curSeriesCode", pcode);
		session.put("curSeriesName",series.getCname());
		return SUCCESS;
	}
	
	/**
	 * 获取车型信息
	 * @return
	 * @throws Exception
	 */
	public String getVehicles() throws Exception {
		
		String code = request.getParameter("pcode");
		vehicleList = vehicleDAO.getVehiclesByEmission(code);
		VehicleEmission emission = vehicleEmissionDAO.getVehicleEmission(code);
		session.put("curEmissionCode", code);
		session.put("curEmissionName", emission.getCname());
		
		return SUCCESS;
	}
	
	/**
	 * 根据首字母查询汽车品牌
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getVehicleYear() throws Exception {
		
		String code = request.getParameter("pcode");
		yearList = vehicleYearDAO.listByEmissionCode(code);
		VehicleEmission emission = vehicleEmissionDAO.getVehicleEmission(code);
		session.put("curEmissionCode", code);
		session.put("curEmissionName", emission.getCname());
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
	
	public String getEmissionFromWeb() throws Exception{
		seriesList =  vehicleSeriesDAO.listVehicleSeries();
		Iterator<VehicleSeries> iter = seriesList.iterator(); 
		VehicleSeries vs = new VehicleSeries();
		String url ="http://www.yangche51.com/handlers/choosecar/choosecarprovider.aspx?json={\"Alphabet\":\"A\",\"AutoBrandId\":2249,\"AutoModelId\":0,\"AutoModelSubId\":0,\"ChooseType\":3,\"MainAutoModelID\":{0},\"SubIds\":null,\"Year\":0}&_=1395903411367";
		int count = 0;
		FileWriter writer = new FileWriter("E:/VehicleEmission.txt", true);
		while(iter.hasNext())  
        {  
            vs=(VehicleSeries)iter.next(); 
            URL getUrl = new URL(url.replace("{0}", vs.getCode()));
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
			// 取得输入流，并使用Reader读取
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			
			boolean beg = false;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				if(line.indexOf("class=\"carNature\"")>=0){
					beg = true;
				}
				if(line.indexOf("</ul>")>=0){
					beg = false;
				}
				if(beg){
					sb.append(line);
				}				
			}
            //System.out.println(sb); 
			//"ChooseType":4,"MainAutoModelID":1002,"SubIds":"54718","Year":0}' title=
            String regx = (",\"SubIds\":\"(.*?)\",\"Year\":0}' title='(.*?)'>");
			Pattern p= Pattern.compile(regx);
			Matcher  macher =p.matcher(sb.toString());
			String sql =null;
			while(macher.find()){ 
				//if(macher.group(1).indexOf(",")> 0){
					String[] arr = macher.group(1).split(",");
					for(int i = 0;i<arr.length;i++){
						sql = "insert into vehicle_emission (series_code,code,cname) values ('"+vs.getCode()+"','"+arr[i]+"','"+macher.group(2)+"');";
						count++;
						/*
						VehicleEmission emission = new VehicleEmission();
						emission.setCode(arr[i]);
						emission.setSeriesCode(vs.getCode());
						emission.setCname(macher.group(2));
						vehicleEmissionDAO.saveOrUpdateEmission(emission);
						*/
						
			            writer.write(sql+"\r\n");
			            
						System.out.println(sql);
					}
					
				/*
					sql = "insert into vehicle_emission (series_code,code,cname) values ('"+vs.getCode()+"','"+macher.group(1)+"','"+macher.group(2)+"')";
				}else{
					sql = "insert into vehicle_emission (series_code,code,cname) values ('"+vs.getCode()+"','"+macher.group(1)+"','"+macher.group(2)+"')";
				}*/
					
				
			}
            
        }  
		writer.close();
		return null;
	}
	
	public String updateEmission() throws Exception{
		List<Vehicle> list =  vehicleDAO.listVehicle();
		Iterator<Vehicle> iter = list.iterator(); 
		Vehicle vehicle = null;
		int count = 0;
		PrintWriter pw = new PrintWriter("E:\\Users\\workspace\\data\\Vehicle.txt"); 
		while(iter.hasNext())  
        {  
			vehicle = iter.next();
			String url ="http://www.autohome.com.cn/spec/"+vehicle.getId()+"/"; 
            URL getUrl = new URL(url);
    		//HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
    		//connection.connect();
    		BufferedReader reader = new BufferedReader(new InputStreamReader(getUrl.openStream(),"gb2312"));
			// 取得输入流，并使用Reader读取
			String line;
			
			boolean beg = false;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				if(line.indexOf("<li><span>发")>=0){
					beg = true;
				}
				if(beg){
					sb.append(line);
				}	
				if(line.indexOf("</li>")>=0){
					beg = false;
				}
							
			}
			String regx = ("</span>(.*?) (.*?)</li>");
			Pattern p= Pattern.compile(regx);
			Matcher  macher =p.matcher(sb.toString());
			String sql =null;
			while(macher.find()){ 
				sql = "insert into vehicle (id,series_code,emission_code,full_name,year_code) values ('"+vehicle.getId()+"','"+vehicle.getSeriesCode()+"','"+macher.group(1)+"','"+vehicle.getFullName()+"','"+vehicle.getYearCode()+"');";
				System.out.println(sql);
				pw.println(sql); 
			}
            
        }  
		
		return null;
	}
	
	public String getYearFromWeb() throws Exception{
		emissionList =  vehicleEmissionDAO.listVehicleEmission();
		Iterator<VehicleEmission> iter = emissionList.iterator(); 
		VehicleEmission vs = new VehicleEmission();
		String url ="http://www.yangche51.com/handlers/choosecar/choosecarprovider.aspx?json={\"AutoBrandId\":2202,\"MainAutoModelID\":1341,\"AutoModelId\":0,\"AutoModelSubId\":0,\"Year\":0,\"ChooseType\":4,\"Alphabet\":\"Z\",\"SubIds\":\"{0}\"}&_=1395910340549";
		int count = 0;
		FileWriter writer = new FileWriter("E:/VehicleYear.txt", true);
		while(iter.hasNext())  
        {  
            vs=(VehicleEmission)iter.next(); 
            URL getUrl = new URL(url.replace("{0}", vs.getCode()));
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
			// 取得输入流，并使用Reader读取
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			
			boolean beg = false;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				if(line.indexOf("--natureTips--")>=0){
					beg = true;
				}
				if(line.indexOf("</ul>")>=0){
					beg = false;
				}
				if(beg){
					sb.append(line);
				}				
			}
            //System.out.println(sb); 
            String regx = (",\"Year\":(.*?),\"ChooseType\":5,");
			Pattern p= Pattern.compile(regx);
			Matcher  macher =p.matcher(sb.toString());
			String sql =null;
			while(macher.find()){ 
				//if(macher.group(1).indexOf(",")> 0){
					
						sql = "insert into vehicle_year (emission_code,code,cname) values ('"+vs.getCode()+"','"+vs.getCode()+macher.group(1)+"','"+macher.group(1)+"年');";
						count++;
						/*
						VehicleEmission emission = new VehicleEmission();
						emission.setCode(arr[i]);
						emission.setSeriesCode(vs.getCode());
						emission.setCname(macher.group(2));
						vehicleEmissionDAO.saveOrUpdateEmission(emission);
						*/
						
			            writer.write(sql+"\r\n");
			            
						System.out.println(sql);
					
					
				/*
					sql = "insert into vehicle_emission (series_code,code,cname) values ('"+vs.getCode()+"','"+macher.group(1)+"','"+macher.group(2)+"')";
				}else{
					sql = "insert into vehicle_emission (series_code,code,cname) values ('"+vs.getCode()+"','"+macher.group(1)+"','"+macher.group(2)+"')";
				}*/
					
				
			}
            
        }  
		writer.close();
		return null;
	}
	
	private void printWriteHTML(String html){
		
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(html);
		} catch (IOException e) {
			// log.error(e.getMessage(),e.fillInStackTrace());
		}
		pw.flush();
		pw.close();
	}
	
	public List<VehicleBrand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<VehicleBrand> brandList) {
		this.brandList = brandList;
	}
	
	public List<VehicleSeries> getSeriesList() {
		return seriesList;
	}

	public void setSeriesList(List<VehicleSeries> seriesList) {
		this.seriesList = seriesList;
	}
	
	public List<VehicleEmission> getEmissionList() {
		return emissionList;
	}

	public void setEmissionList(List<VehicleEmission> emissionList) {
		this.emissionList = emissionList;
	}
	
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	public List<VehicleYear> getYearList() {
		return yearList;
	}

	public void setYearList(List<VehicleYear> yearList) {
		this.yearList = yearList;
	}
	
	
}
