package com.autoboys.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.autoboys.domain.*;

public class VehicleDAOImpl implements VehicleDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<Vehicle> listVehicle() {
		List<Vehicle> courses = null;
		try {
			courses = session.createQuery("from Vehicle").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public Vehicle getVehicleByPrimaryKey(Integer id) {
		Vehicle vehicle = null;
		try {
			vehicle = (Vehicle) session.get(Vehicle.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle;
		
	}

	@Override
	public List<Vehicle> getVehiclesByEmission(String emisionCode) {
		List<Vehicle> list = null;
		try {
			SQLQuery query = session.createSQLQuery("select * from Vehicle where emission_code = ?");
			query.setParameter(0,emisionCode);
			query.addEntity(Vehicle.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Vehicle> getVehiclesBySeries(String seriesCode) {
		List<Vehicle> list = null;
		try {
			Query query = session.createQuery("select distinct series_code,emission_code from Vehicle where series_code = ?");
			query.setParameter(0,seriesCode);
			//query.addEntity(Vehicle.class);
			List<Object[]> olist = query.list();
			for(Object[] ol : olist){  
				Vehicle vehicle = new Vehicle();
				vehicle.setSeriesCode(ol[0].toString());
				vehicle.setEmissionCode(ol[1].toString());
				list.add(vehicle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
