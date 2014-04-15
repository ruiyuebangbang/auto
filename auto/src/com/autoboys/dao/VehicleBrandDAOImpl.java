package com.autoboys.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.autoboys.domain.*;

public class VehicleBrandDAOImpl implements VehicleBrandDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<VehicleBrand> listVehicleBrand() {
		List<VehicleBrand> courses = null;
		try {
			courses = session.createQuery("from VehicleBrand").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleBrand> listVehicleBrandByFC(String fc) {
		List<VehicleBrand> list = null;
		try {
			SQLQuery query = session.createSQLQuery("select * from Vehicle_Brand where first_character = ?");
			query.setParameter(0,fc);
			query.addEntity(VehicleBrand.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public VehicleBrand getVehicleBrand(String code) {
		VehicleBrand brand = null;
		try{
			brand = (VehicleBrand) session.get(VehicleBrand.class, code);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return brand;
	}

	@Override
	public List<VehicleBrand> listHotVehicleBrand() {
		List<VehicleBrand> list = null;
		try {
			SQLQuery query = session.createSQLQuery("select * from Vehicle_Brand where is_hot = 1");
			query.addEntity(VehicleBrand.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
