package com.autoboys.dao;

import java.util.List;
import com.autoboys.domain.*;

public interface ProviderDAO {

	public void saveOrUpdateProvider(Provider provider);
	public int updateMainInfo(Provider provider);
	public List<Provider> listProvider();
	public Provider listProviderById(Long providerId);
	public void deleteProvider(Long providerId);
	public int updateLogo(Provider prov);
	//public int updateLogo(Long id, String logo);
	public int updateImage(Long providerId,String imagePath,int index);	
	
}
