package com.autoboys.dao;

import java.util.List;

import com.autoboys.domain.*;

public interface VehicleDAO {

	public List<Vehicle> listVehicle();
	
	public Vehicle getVehicleByPrimaryKey(Integer id);
	
	public List<Vehicle> getVehiclesByEmission(String emisionCode);
	
	public List<Vehicle> getVehiclesBySeries(String seriesCode);
	
}
