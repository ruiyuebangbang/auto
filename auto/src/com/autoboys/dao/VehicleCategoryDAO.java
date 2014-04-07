package com.autoboys.dao;

import java.util.List;
import com.autoboys.domain.*;

public interface VehicleCategoryDAO {

	public List<VehicleCategory> listVehicleByParentId(String pCode);
	public List<VehicleCategory> listVehicleBrandsByFC(String firstCharacter);
	public String getFullNameByCode(String code);
	
}
