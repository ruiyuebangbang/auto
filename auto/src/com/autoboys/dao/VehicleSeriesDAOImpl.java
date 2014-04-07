package com.autoboys.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.autoboys.domain.*;

public class VehicleSeriesDAOImpl implements VehicleSeriesDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<VehicleSeries> listVehicleSeries() {
		List<VehicleSeries> list = null;
		try {
			//courses = session.createQuery("from Vehicle_series").list();
			SQLQuery query = session.createSQLQuery("select * from Vehicle_Series");
			query.addEntity(VehicleSeries.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<VehicleSeries> listByBrandCode(String brandCode) {
		List<VehicleSeries> list = null;
		try {
			SQLQuery query = session.createSQLQuery("select * from Vehicle_Series where brand_code = ?");
			query.setParameter(0,brandCode);
			query.addEntity(VehicleSeries.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	
	@Override
	public VehicleSeries getVehicleSeries(String code) {
		VehicleSeries series = null;
		try{
			series = (VehicleSeries) session.get(VehicleSeries.class, code);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return series;
	}

}
