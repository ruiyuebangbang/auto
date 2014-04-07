package com.autoboys.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.autoboys.domain.*;

public class VehicleCategoryDAOImpl implements VehicleCategoryDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String getFullNameByCode(String code) {
		String fullName = null ;
		try {
			VehicleCategory vc = (VehicleCategory) session.get(VehicleCategory.class, code);
			if(vc != null)	fullName = vc.getFullName();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
		return fullName;
	}
	/**
	 * Used to list VehicleCatetorys by parent Id.
	 */

	@Override
	@SuppressWarnings("unchecked")
	public List<VehicleCategory> listVehicleByParentId(String pCode) {
		List<VehicleCategory> list = null;
		try {
			SQLQuery query = session.createSQLQuery("select * from vehicle_category where p_code = ? order by manufacturer ,first_character");
			query.setParameter(0,pCode);
			query.addEntity(VehicleCategory.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleCategory> listVehicleBrandsByFC(String firstCharacter) {
		List<VehicleCategory> list = null;
		try {
			SQLQuery query = session.createSQLQuery("select * from vehicle_category where p_code = '0' and first_character = ? order by first_character");
			query.setParameter(0,firstCharacter);
			query.addEntity(VehicleCategory.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
