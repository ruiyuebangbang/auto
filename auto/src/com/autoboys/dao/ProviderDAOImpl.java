package com.autoboys.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.autoboys.domain.*;
import com.autoboys.util.*;
public class ProviderDAOImpl implements ProviderDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a provider.
	 */
	public void saveOrUpdateProvider(Provider provider) {
		try {
			session.saveOrUpdate(provider);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a provider.
	 */
	
	public void deleteProvider(Long providerId) {
		try {
			Provider provider = (Provider) session.get(Provider.class, providerId);
			session.delete(provider);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the providers.
	 */
	@SuppressWarnings("unchecked")
	public List<Provider> listProvider() {
		List<Provider> courses = null;
		try {
			courses = session.createQuery("from Provider").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single provider by Id.
	 */
	
	public Provider listProviderById(Long providerId) {
		Provider provider = null;
		try {
			provider = (Provider) session.get(Provider.class, providerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return provider;
	}

	/**
	 * 更新主要信息
	 */
	public int updateMainInfo(Provider provider) {
		int ret = 0;
		try {
			String sql = " update Provider set REGION_ID =?, SHORT_NAME=?,FULL_NAME=?, AGENT=?,TELEPHONE=?, "   
      + " SERVICE_PHONE=?,SERVICE_TIME=?,ADDRESS=?,REMARK=?,QUALIFICATION=?"
      + " where id = ?";
			session.beginTransaction();
			Query q = session.createQuery(sql);
			
			q.setLong(0, provider.getREGION_ID());
			q.setString(1, provider.getSHORT_NAME());
			q.setString(2, provider.getFULL_NAME());
			q.setString(3, provider.getAGENT());
			q.setString(4, provider.getTELEPHONE());
			q.setString(5, provider.getSERVICE_PHONE());
			q.setString(6, provider.getSERVICE_TIME());
			q.setString(7, provider.getADDRESS());
			q.setString(8, provider.getREMARK());
			q.setString(9, provider.getQUALIFICATION());
			q.setLong(10, provider.getID());
			ret = q.executeUpdate();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return ret;
	}
	
	public int updateLogo(Provider prov) {
		int ret = 0;
		Connection conn = null;
		try {
			conn = ProxoolConnection.getConnection();
			CallableStatement cs = conn.prepareCall(" update provider set logo =? where id = ?");
			cs.setString(1,prov.getLOGO());
			cs.setLong(2, prov.getID());

			ret = cs.executeUpdate();
			
			//session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//session.getTransaction().rollback();
		} finally {
			try {conn.close();}catch(Exception e){}
		}
		return ret;
	}
	
/*	public int updateLogo(Long id, String logo) {
		int ret = 0;
		try {
			String sql = " update provider set logo =? where id = ?";
			session.beginTransaction();
			Query q = session.createSQLQuery(sql);
			
			q.setString(0,logo);
			q.setLong(1, id);

			ret = q.executeUpdate();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return ret;
	}*/
	
	public int updateImage(Long providerId,String imagePath,int index) {
		int ret = 0;
		Connection conn = null;
		try {
			conn = ProxoolConnection.getConnection();
			CallableStatement cs = conn.prepareCall("{Call p_update_provider_image(?,?)}");
			cs.setLong(1, providerId);
			cs.setString(2, imagePath);
			cs.executeUpdate();
			cs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			//session.getTransaction().rollback();
		} finally {
			try {conn.close();}catch(Exception e){}
		}
		return ret;
	}
	
}
