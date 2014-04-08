package com.autoboys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_brand")
public class VehicleBrand {

	private String code;
	private String cname;
	private String ename;
	private String firstCharacter;
	//private String pcode;
	private String manufacturer;
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	//private String logoSmall;
	private String brandLogo;
	//private String fullName;
	
	@Id
	@GeneratedValue
	@Column(name="code")	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="cname")
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Column(name="ename")
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Column(name="first_character")
	public String getFirstCharacter() {
		return firstCharacter;
	}
	public void setFirstCharacter(String firstCharacter) {
		this.firstCharacter = firstCharacter;
	}
	
	@Column(name="brand_logo")
	public String getBrandLogo() {
		return brandLogo;
	}
	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}
	



	
	

}
