package com.autoboys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE_CATEGORY")
public class ServiceCat {

	private String code;
	private String name;
	private String remark;
	
	@Id
	@Column(name="code")	
	public String getCode() {
		return code;
	}
	public void setCode(String id) {
		this.code = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String password) {
		this.remark = password;
	}

}
